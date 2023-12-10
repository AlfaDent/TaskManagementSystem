package com.example.taskmanagementsystem.models.employee;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class EmployeeTasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinTable(name = "task")
    private Long taskId;
    @JoinTable(name = "employee")
    private Long employeeId;

}
