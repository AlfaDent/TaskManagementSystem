package com.example.taskmanagementsystem.services;

import com.example.taskmanagementsystem.DTO.EmployeeDTO;
import com.example.taskmanagementsystem.models.employee.Employee;
import com.example.taskmanagementsystem.models.task.Task;
import com.example.taskmanagementsystem.repositories.EmployeeRepository;
import com.example.taskmanagementsystem.repositories.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private TaskRepository taskRepository;
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    public Optional<Employee> getEmployeeById(Long id){
        return employeeRepository.findById(id);
    }
    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setLastname(employeeDTO.getLastname());
        employee.setEmail(employeeDTO.getEmail());
        return employeeRepository.save(employee);
    }
    public void deleteEmployeeById(Long id){
        employeeRepository.deleteById(id);
    }
    public void editEmployeeById(Long id, EmployeeDTO employeeDTO){
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("employee not found with id: " + id));
        employee.setName(employeeDTO.getName());
        employee.setLastname(employee.getLastname());
        employee.setEmail(employeeDTO.getEmail());
        employeeRepository.save(employee);
    }
    public List<Task> getAllTasksByEmployeeId(Long id){
        return taskRepository.findTasksByEmployee_Id(id);
    }
    public void setTask(Long taskId, Long authorId,  Long employeeToGiveId){
        Employee employee = employeeRepository.findById(employeeToGiveId).orElseThrow(() -> new EntityNotFoundException("employee not found with id: " + employeeToGiveId));
        Employee author = employeeRepository.findById(authorId).orElseThrow(() -> new EntityNotFoundException("employee not found with id: " + authorId));
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new EntityNotFoundException("task not found with id: " + taskId));
        task.setAuthor(author);
        task.setEmployee(employee);
        taskRepository.save(task);
    }
}
