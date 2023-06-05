package com.example.inmemory.Controller;

import com.example.inmemory.entity.Users;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.inmemory.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserRepository userrepository;

    public UserController(UserRepository userRepository){
        this.userrepository = userRepository;
    }

    @RequestMapping(value = "/user", method = { RequestMethod.POST, RequestMethod.PUT })
    public ResponseEntity<?> save(@RequestBody @Valid Users entity, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(userrepository.save(entity));
    }
}
