package com.example.taskmanagementsystem.models.employee;

import com.example.taskmanagementsystem.models.task.Task;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class EmployeeTasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<Task> taskId;
}
