package com.example.inmemory.repository;

import com.example.inmemory.entity.Users;

import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<Users, String>{
    
}
