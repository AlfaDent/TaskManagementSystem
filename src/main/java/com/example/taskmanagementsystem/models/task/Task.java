package com.example.taskmanagementsystem.models.task;

import com.example.taskmanagementsystem.models.employee.Employee;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
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
//    @JsonBackReference("tasksToDo")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Employee author;
}
