package br.ufba.tomorrow.toDoProject.repository;

import br.ufba.tomorrow.toDoProject.domain.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Usuario save(Usuario usuario);
    public Usuario findByEmail(String email);
}
