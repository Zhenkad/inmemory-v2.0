package com.example.inmemory.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
