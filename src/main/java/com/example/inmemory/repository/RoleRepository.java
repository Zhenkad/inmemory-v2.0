package com.example.inmemory.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.inmemory.entity.Roles;

public interface RoleRepository extends CrudRepository<Roles, String>{
    
}
