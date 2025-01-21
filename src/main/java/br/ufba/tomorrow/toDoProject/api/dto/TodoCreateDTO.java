package br.ufba.tomorrow.toDoProject.api.dto;

import br.ufba.tomorrow.toDoProject.domain.entities.Estado;

import java.time.LocalDate;

public class TodoCreateDTO {
    private long idUsuario;
    private String item;
    private LocalDate prazo;
    private Estado estado;

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
