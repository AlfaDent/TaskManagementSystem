package com.example.taskmanagementsystem.DTO;

import com.example.taskmanagementsystem.models.task.Task;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TaskDTO extends Task {
    private String header;
    private String description;
    private Long statusId;
    private Long priorityId;
    private Long employeeId;

}
