package br.ufba.tomorrow.toDoProject.api.controllers;

import br.ufba.tomorrow.toDoProject.api.dto.TodoCreateDTO;
import br.ufba.tomorrow.toDoProject.api.dto.TodoDTO;
import br.ufba.tomorrow.toDoProject.api.dto.TodoUpdateDTO;
import br.ufba.tomorrow.toDoProject.domain.entities.Estado;
import br.ufba.tomorrow.toDoProject.domain.services.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TodoDTO> criar(@RequestBody TodoCreateDTO todo) {
        System.out.println("Chegou aqui: " + todo.getIdUsuario());
        return new ResponseEntity<TodoDTO>(service.criar(todo), HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<TodoDTO>> listarPorUsuario(@PathVariable long userId) {
        return new ResponseEntity<List<TodoDTO>>(service.listarTodosDeUmUsuario(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/{estado}")
    public ResponseEntity<List<TodoDTO>> listarPorUsuarioEEstado(@PathVariable long userId, @PathVariable Estado estado) {
        return new ResponseEntity<List<TodoDTO>>(service.listarTodosDeUmUsuarioComEstado(userId, estado), HttpStatus.OK);
    }

    @PutMapping("/{todoId}")
    public ResponseEntity<TodoDTO> alterar(@RequestBody TodoUpdateDTO todo) throws Exception{
        return new ResponseEntity<TodoDTO>(service.alterar(todo), HttpStatus.OK);
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<TodoDTO> RemoverTodo(@PathVariable Long todoId) throws Exception {
        TodoDTO todo = service.remover(todoId);
        return new ResponseEntity<TodoDTO>(todo, HttpStatus.OK);
    }

    @PatchMapping("/{todoId}")
    public ResponseEntity<TodoDTO> concluir(@PathVariable long todoId) throws Exception {
        TodoDTO todoConcluido = service.concluir(todoId);
        return new ResponseEntity<TodoDTO>(todoConcluido, HttpStatus.OK);
    }

}
