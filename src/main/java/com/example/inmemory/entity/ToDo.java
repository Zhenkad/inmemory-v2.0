package com.example.inmemory.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Inmemory")
public class ToDo {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    @NotNull
    private String description;
    private LocalDateTime created;
    private LocalDateTime updated;
    private boolean completed;
    
    @PrePersist
    public void onCreate(){
        this.created = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate(){
        this.updated = LocalDateTime.now();
    }
}