package com.example.taskmanagementsystem.models.employee;

import com.example.taskmanagementsystem.models.task.Task;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    @Column(unique = true)
    private String email;
    private String password;
    @OneToMany( fetch = FetchType.EAGER)
    private List<Task> tasks = new ArrayList<>();

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", tasks=" + tasks.stream()
                .map(Task::getHeader)
                .collect(Collectors.joining(", ")) +
                '}';
    }
}
