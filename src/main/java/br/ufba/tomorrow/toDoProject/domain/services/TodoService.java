package br.ufba.tomorrow.toDoProject.domain.services;

import br.ufba.tomorrow.toDoProject.api.dto.TodoCreateDTO;
import br.ufba.tomorrow.toDoProject.api.dto.TodoDTO;
import br.ufba.tomorrow.toDoProject.api.dto.TodoUpdateDTO;
import br.ufba.tomorrow.toDoProject.domain.entities.Estado;
import br.ufba.tomorrow.toDoProject.domain.entities.Todo;
import br.ufba.tomorrow.toDoProject.domain.entities.Usuario;
import br.ufba.tomorrow.toDoProject.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {
    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public TodoDTO criar (TodoCreateDTO todo) {
        return new TodoDTO(repository.save(new Todo(todo)));
    }

    public List<TodoDTO> listarTodosDeUmUsuario(long userId) {
        return repository.findByUsuario(new Usuario(userId))
                .stream()
                .map(TodoDTO::new)
                .collect(Collectors.toList());
    }
    public List<TodoDTO> listarTodosDeUmUsuarioComEstado(long userId, Estado estado) {
        return repository.findByUsuarioAndEstado(new Usuario(userId), estado)
                .stream()
                .map(TodoDTO::new)
                .collect(Collectors.toList());
    }
    public TodoDTO alterar(TodoUpdateDTO dto) throws Exception {
        Todo existe = repository.findById(dto.getId());
        if (existe != null) {
            Todo inserir = new Todo(dto);
            inserir.setUsuario(existe.getUsuario());
            return new TodoDTO(repository.save(inserir));
        }
        else throw new Exception("Objeto não encontrado com id: " + dto.getId());
    }

    public TodoDTO remover(long todoId) throws Exception {
        Todo todo = repository.findById(todoId);
        if (todo != null) {
            repository.delete(todo);
            return new TodoDTO(todo);
        }
        else throw new Exception("Todo não encontrada com id: " + todoId);
    }

    public TodoDTO concluir(long todoId) throws Exception {
        Todo todo = repository.findById(todoId);
        if (todo != null) {
            todo.setConclusao(LocalDate.now());
            todo.setEstado(Estado.CONCLUIDO);
            Todo todoConcluido = repository.save(todo);
            return new TodoDTO(todoConcluido);
        }
        else throw new Exception("Todo não encontrada com id: " + todoId);
    }
}
