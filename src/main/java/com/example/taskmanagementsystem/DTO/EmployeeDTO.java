package com.example.taskmanagementsystem.DTO;

import com.example.taskmanagementsystem.models.Employee;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO extends Employee {
    private String name;
    private String lastname;
    private String email;
}
