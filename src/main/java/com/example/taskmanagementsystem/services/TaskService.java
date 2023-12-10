package com.example.taskmanagementsystem.services;

import com.example.taskmanagementsystem.DTO.TaskDTO;
import com.example.taskmanagementsystem.models.task.Task;
import com.example.taskmanagementsystem.repositories.EmployeeRepository;
import com.example.taskmanagementsystem.repositories.PriorityRepository;
import com.example.taskmanagementsystem.repositories.StatusRepository;
import com.example.taskmanagementsystem.repositories.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    private PriorityRepository priorityRepository;
    @Autowired
    private EmployeeRepository employeeRepository;


    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }
    public Optional<Task> getTaskById(Long id){
        return taskRepository.findById(id);
    }
    public Task createTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.setHeader(taskDTO.getHeader());
        task.setDescription(taskDTO.getDescription());
        task.setStatus(statusRepository.findById(taskDTO.getStatusId()).orElse(null));
        task.setPriority(priorityRepository.findById(taskDTO.getPriorityId()).orElse(null));
        task.setEmployee(employeeRepository.findById(taskDTO.getEmployeeId()).orElse(null));
        return taskRepository.save(task);
    }
    public void deleteTaskById(Long id){
        taskRepository.deleteById(id);
    }
    public void editTaskById(Long id, TaskDTO taskDTO){
        Task task = taskRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Task not found with id: " + id));
        task.setHeader(taskDTO.getHeader());
        task.setDescription(taskDTO.getDescription());
        task.setStatus(statusRepository.findById(taskDTO.getStatusId()).orElse(null));
        task.setPriority(priorityRepository.findById(taskDTO.getPriorityId()).orElse(null));
        task.setEmployee(employeeRepository.findById(taskDTO.getEmployeeId()).orElse(null));
        taskRepository.save(task);
    }
    public List<Task> getAllTasksByEmployeeId(Long id){
        return taskRepository.findTasksByEmployee_Id(id);
    }
}
