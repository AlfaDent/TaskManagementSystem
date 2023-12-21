package com.example.taskmanagementsystem.controllers;

import com.example.taskmanagementsystem.DTO.EmployeeDTO;
import com.example.taskmanagementsystem.models.employee.Employee;
import com.example.taskmanagementsystem.models.task.Task;
import com.example.taskmanagementsystem.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    @GetMapping(value = "/employee/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }
    @PostMapping(value = "/employee",consumes = {"*/*"})
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDTO employeeDTO){
        Employee employee = employeeService.createEmployee(employeeDTO);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }
    @DeleteMapping(value = "/employee/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployeeById(id);
    }
    @PutMapping(value = "/employee/{id}")
    public void editEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO){
        employeeService.editEmployeeById(id, employeeDTO);
    }
    @GetMapping(value = "/employee/{id}/tasks")
    public List<Task> getTasksByEmployeeId(@PathVariable Long id){
        return employeeService.getAllTasksByEmployeeId(id);
    }
    @PostMapping(value = "/employee/{id}/give_task")
    public void setTaskToEmployee(@PathVariable Long id, @RequestBody Long taskId, @RequestBody Long employeeId){
        employeeService.setTask(taskId, id,employeeId);
    }
}
