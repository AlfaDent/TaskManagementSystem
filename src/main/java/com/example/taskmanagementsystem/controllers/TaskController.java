package com.example.taskmanagementsystem.controllers;

import com.example.taskmanagementsystem.DTO.TaskDTO;
import com.example.taskmanagementsystem.models.Task;
import com.example.taskmanagementsystem.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController(value = "/")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping(value = "/tasks")
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }
    @GetMapping(value = "/task/{id}")
    public Optional<Task> getTaskById(@PathVariable Long id){
        return taskService.getTaskById(id);
    }
    @PostMapping(value = "/task")
    public ResponseEntity<Task> createTask(@RequestBody TaskDTO taskDTO){
        Task task = taskService.createTask(taskDTO);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }
    @DeleteMapping(value = "/task/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTaskById(id);
    }
    @PutMapping(value = "/task/{id}")
    public void editTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO){
        taskService.editTaskById(id, taskDTO);
    }
}
