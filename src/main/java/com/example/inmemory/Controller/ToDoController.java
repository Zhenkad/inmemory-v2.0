package com.example.inmemory.Controller;

import com.example.inmemory.entity.ToDo;
import com.example.inmemory.repository.ToDoRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ToDoController {

    private ToDoRepository repository;

    public ToDoController(ToDoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/todos")
    public ResponseEntity<Iterable<ToDo>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @RequestMapping(value = "/todo", method = { RequestMethod.POST, RequestMethod.PUT })
    public ResponseEntity<?> save(@RequestBody @Valid ToDo entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(entity));
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity<ToDo> findById(@PathVariable String id) {
        Optional<ToDo> toDoOpt = repository.findById(id);
        if (toDoOpt.isPresent()){
            return ResponseEntity.ok(toDoOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/todo")
    public ResponseEntity<?> delete(@RequestBody String id) {
        Optional<ToDo> toDoOpt = repository.findById(id);
        if (toDoOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        repository.delete(toDoOpt.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}