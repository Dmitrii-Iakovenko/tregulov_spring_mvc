package com.wutreg.spring_rest.controller;

import com.wutreg.spring_rest.entity.Employee;
import com.wutreg.spring_rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("employees")
    public List<Employee> getAll() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("employees/{id}")
    public Employee getById(@PathVariable long id) {
        return employeeService.getEmployee(id);
    }
}
