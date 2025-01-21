package br.ufba.tomorrow.toDoProject.domain.entities;

import br.ufba.tomorrow.toDoProject.api.dto.UsuarioCreateDTO;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String senha;
    @OneToMany(mappedBy = "usuario")
    private List<Todo> todoList;

    public Usuario(long idUsuario) {
        this.id = idUsuario;
    }

    public Usuario(UsuarioCreateDTO dto) {
        this.email = dto.getEmail();
        this.senha = dto.getSenha();
    }

    public Usuario() {}

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Todo> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<Todo> todoList) {
        this.todoList = todoList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) && Objects.equals(email, usuario.email) && Objects.equals(senha, usuario.senha) && Objects.equals(todoList, usuario.todoList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, senha, todoList);
    }
}
