package com.example.employeemanagementsystem.services;

import com.example.taskmanagementsystem.DTO.EmployeeDTO;
import com.example.taskmanagementsystem.models.Employee;
import com.example.taskmanagementsystem.repositories.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    public Optional<Employee> getemployeeById(Long id){
        return employeeRepository.findById(id);
    }
    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();

        return employeeRepository.save(employee);
    }
    public void deleteEmployeeById(Long id){
        employeeRepository.deleteById(id);
    }
    public void editEmployeeById(Long id, EmployeeDTO employeeDTO){
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("employee not found with id: " + id));

        employeeRepository.save(employee);
    }
}
