package com.example.taskmanagementsystem.models.task;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TaskPriority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Override
    public String toString() {
        return "TaskPriority{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
