package com.wutreg.spring_data_jpa.controller;

import com.wutreg.spring_data_jpa.entity.Employee;
import com.wutreg.spring_data_jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.findAll();
    }

    @GetMapping("{id}")
    public Employee getById(@PathVariable long id) {
        return employeeService.getEmployee(id);
    }

    @PostMapping
    public Employee add(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping
    public Employee update(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable long id) {
        employeeService.deleteById(id);
        return "Employee with ID = " + id + " was deleted.";
    }

    @GetMapping("name/{name}")
    public List<Employee> findAllByName(@PathVariable String name) {
        return employeeService
            .findAllByName(name);
    }
}
