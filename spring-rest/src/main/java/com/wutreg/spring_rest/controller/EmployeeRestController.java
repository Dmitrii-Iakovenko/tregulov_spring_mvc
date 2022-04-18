package com.wutreg.spring_rest.controller;

import com.wutreg.spring_rest.entity.Employee;
import com.wutreg.spring_rest.exception.EmployeeNotFoundException;
import com.wutreg.spring_rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            String errorMessage = "There is no employee with Id = " + id + " in Database";
            throw new EmployeeNotFoundException(errorMessage);
        }
        return employee;
    }

    @PostMapping("employees")
    public Employee add(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }
}
