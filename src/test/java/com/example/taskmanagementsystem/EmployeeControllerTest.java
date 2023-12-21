package com.example.taskmanagementsystem;

import com.example.taskmanagementsystem.DTO.EmployeeDTO;
import com.example.taskmanagementsystem.controllers.EmployeeController;
import com.example.taskmanagementsystem.models.employee.Employee;
import com.example.taskmanagementsystem.services.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    // Пример теста для getAllEmployees
    @Test
    public void testGetAllEmployees() throws Exception {
        when(employeeService.getAllEmployees()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
    }
    @Test
    public void testGetEmployeeById() throws Exception {
        Long id = 1L;
        Employee employee = new Employee(); // Инициализируйте поля
        when(employeeService.getEmployeeById(id)).thenReturn(Optional.of(employee));
        mockMvc.perform(get("/employee/" + id))
                .andExpect(status().isOk());
        // Дополнительные проверки содержимого ответа
    }

    // Тест для createEmployee
    @Test
    public void testCreateEmployee() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO(); // Инициализируйте поля
        Employee employee = new Employee(); // Инициализируйте поля
        when(employeeService.createEmployee(any(EmployeeDTO.class))).thenReturn(employee);
        mockMvc.perform(post("/employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(employeeDTO)))
                .andExpect(status().isCreated());
    }

    // Тест для deleteEmployee
    @Test
    public void testDeleteEmployee() throws Exception {
        Long id = 1L;
        doNothing().when(employeeService).deleteEmployeeById(id);
        mockMvc.perform(delete("/employee/" + id))
                .andExpect(status().isOk());
    }

    // Тест для editEmployee
    @Test
    public void testEditEmployee() throws Exception {
        Long id = 1L;
        EmployeeDTO employeeDTO = new EmployeeDTO(); // Инициализируйте поля
        doNothing().when(employeeService).editEmployeeById(eq(id), any(EmployeeDTO.class));
        mockMvc.perform(put("/employee/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(employeeDTO)))
                .andExpect(status().isOk());
    }

    // Тест для getTasksByEmployeeId
    @Test
    public void testGetTasksByEmployeeId() throws Exception {
        Long id = 1L;
        when(employeeService.getAllTasksByEmployeeId(id)).thenReturn(Collections.emptyList());
        mockMvc.perform(get("/employee/" + id + "/tasks"))
                .andExpect(status().isOk());
        // Дополнительные проверки содержимого ответа
    }

    // Тест для setTaskToEmployee
    @Test
    public void testSetTaskToEmployee() throws Exception {
        Long id = 1L;
        Long taskId = 2L;
        Long employeeId = 2L;
        doNothing().when(employeeService).setTask(taskId, id, employeeId);
        mockMvc.perform(post("/employee/" + id + "/give_task")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"taskId\": " + taskId + ", \"employeeId\": " + employeeId + "}"))
                .andExpect(status().isOk());
    }
    // Аналогичные тесты для других методов
}
