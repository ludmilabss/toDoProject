package br.ufba.tomorrow.toDoProject.api.dto;

import br.ufba.tomorrow.toDoProject.domain.entities.Usuario;

import java.util.Objects;

public class UsuarioDTO {
    private Long id;
    private String email;

    public UsuarioDTO() {}

    public UsuarioDTO(Usuario usu) {
        this.id = usu.getId();
        this.email = usu.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioDTO that = (UsuarioDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }
}
