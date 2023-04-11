package com.example.inmemory.repository;

import com.example.inmemory.entity.ToDo;
import org.springframework.data.repository.CrudRepository;


public interface ToDoRepository extends CrudRepository<ToDo, String>{
    
}
