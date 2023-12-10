package com.example.taskmanagementsystem.models;

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
    @OneToOne
    private Employee employee;

    public Task(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", header='" + header + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", priority=" + priority +
                ", employee=" + employee +
                '}';
    }
}
