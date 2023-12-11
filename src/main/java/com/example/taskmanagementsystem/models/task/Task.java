package com.example.taskmanagementsystem.models.task;

import com.example.taskmanagementsystem.models.employee.Employee;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String header;
    private String description;
    @ManyToOne
    //@NotNull
    private TaskStatus status;
    @ManyToOne
    //@NotNull
    private TaskPriority priority;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonBackReference
    private Employee employee;

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", header='" + header + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", priority=" + priority +
                ", employee=" + employee.getId() +
                employee.getName() +
                employee.getLastname() +
                employee.getEmail() +
                '}';
    }
}
