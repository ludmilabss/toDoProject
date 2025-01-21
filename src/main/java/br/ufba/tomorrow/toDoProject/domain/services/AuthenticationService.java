package br.ufba.tomorrow.toDoProject.domain.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Collections;
import java.util.Date;

@Service
public class AuthenticationService {
    static final long EXPIRATIONTIME = 1000 * 60 * 15;
    static final String SIGNINGKEY = "O segredo longo da zorra tenho muito a fazer";
    static final String PREFIX = "Bearer";
    private static final SecretKey SECRETKEY = Keys.hmacShaKeyFor(SIGNINGKEY.getBytes());

    static public void addToken(HttpServletResponse res, String email) {
        System.out.println("Chegou aqui!");

        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + EXPIRATIONTIME);
        String JwtToken = Jwts.builder()
                .claim("sub", email)
                .claim("iat", now.getTime())
                .claim("exp", expirationDate.getTime())
                .signWith(SECRETKEY)
                .compact();

        res.addHeader("Authorization", PREFIX + " " + JwtToken);
        res.addHeader("Access-Control-Expose-Headers", "Authorization");
    }

    static public Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null) {
            if (token.startsWith(PREFIX)) token = token.substring(PREFIX.length()).trim();
            else throw new MalformedJwtException("Invalid Authorization header format");
            Claims claims = Jwts.parser()
                    .verifyWith(SECRETKEY)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            String email = claims.get("sub", String.class);
            if (email != null)
                return new UsernamePasswordAuthenticationToken(email,
                        null, Collections.emptyList());
        }
        return null;
    }
}
