package br.ufba.tomorrow.toDoProject.api.dto;

import br.ufba.tomorrow.toDoProject.domain.entities.Estado;
import br.ufba.tomorrow.toDoProject.domain.entities.Todo;

import java.time.LocalDate;

public class TodoDTO {
    private long id;
    long idUsuario;
    private String item;
    private LocalDate prazo;
    private Estado estado;

    public TodoDTO (){}

    public TodoDTO (Todo todo) {
        this.id = todo.getId();
        this.idUsuario = todo.getUsuario().getId();
        this.item = todo.getItem();
        this.prazo = todo.getPrazo();
        this.estado = todo.getEstado();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
