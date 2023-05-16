package com.example.inmemory.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.inmemory.entity.ToDo;
import com.example.inmemory.repository.ToDoRepository;

@Controller
public class MainController {
    private final ToDoRepository repository;

    public MainController(ToDoRepository repository){
        this.repository = repository;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("todos", repository.findAll());
        repository.findAll();
        return "index";
    }

    @GetMapping("/addTodo")
    public String addTodo(Model model){
        model.addAttribute("todo", new ToDo());
        return "todo";
    }

    @PostMapping("/addTodo")
    public String addTodo(ToDo toDo){
        repository.save(toDo);
        return "redirect:/";

    }

}
