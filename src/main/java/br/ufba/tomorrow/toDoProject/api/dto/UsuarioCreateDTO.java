package br.ufba.tomorrow.toDoProject.api.dto;

import br.ufba.tomorrow.toDoProject.domain.entities.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class UsuarioCreateDTO {
    @NotBlank(message = "O e-mail não pode ser em branco!")
    @Email(message="O e-mail informado não é valido!")
    private String email;
    @Size(min=5, max=20, message="A senha deve ter entre 5 e 20 caracteres.")
    private String senha;

    public UsuarioCreateDTO() {}

    public UsuarioCreateDTO(Usuario usu) {
        this.email = usu.getEmail();
        this.senha = usu.getSenha();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioCreateDTO that = (UsuarioCreateDTO) o;
        return Objects.equals(email, that.email) && Objects.equals(senha, that.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, senha);
    }
}
