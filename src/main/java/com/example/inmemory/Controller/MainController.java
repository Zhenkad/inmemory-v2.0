package com.example.inmemory.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.inmemory.entity.ToDo;
import com.example.inmemory.entity.Users;
import com.example.inmemory.repository.ToDoRepository;
import com.example.inmemory.repository.UserRepository;

@Controller
public class MainController {
    private final ToDoRepository repository;
    private final UserRepository userRepository;

    public MainController(ToDoRepository repository, UserRepository userRepository){
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String login(Model model){
        model.addAttribute("todos", repository.findAll());
        repository.findAll();
        return "index";
    }

    @GetMapping("/verify")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @GetMapping("/addUser")
    public String addUser(Model model){
        model.addAttribute("user", new Users());
        return "user";
    }

    @PostMapping("/addUser")
    public String addUser(Users users){
        userRepository.save(users);
        return "redirect:/";

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
