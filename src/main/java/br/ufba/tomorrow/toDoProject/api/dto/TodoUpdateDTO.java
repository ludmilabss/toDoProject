package br.ufba.tomorrow.toDoProject.api.dto;

import br.ufba.tomorrow.toDoProject.domain.entities.Estado;

import java.time.LocalDate;
import java.util.Objects;

public class TodoUpdateDTO {
    private long id;
    private String item;
    private LocalDate prazo;
    private LocalDate conclusao;
    private Estado estado;

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

    public LocalDate getConclusao() {
        return conclusao;
    }

    public void setConclusao(LocalDate conclusao) {
        this.conclusao = conclusao;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoUpdateDTO that = (TodoUpdateDTO) o;
        return id == that.id && Objects.equals(item, that.item) && Objects.equals(prazo, that.prazo) && Objects.equals(conclusao, that.conclusao) && estado == that.estado;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, item, prazo, conclusao, estado);
    }
}
