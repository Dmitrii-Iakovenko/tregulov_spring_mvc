package com.wutreg.spring_boot.controller;

import com.wutreg.spring_boot.entity.Employee;
import com.wutreg.spring_boot.service.EmployeeService;
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
        return employeeService.getAll();
    }

//    @GetMapping("{id}")
//    public Employee getById(@PathVariable long id) {
//        Employee employee = employeeService.getEmployee(id);
//        if (employee == null) {
//            String errorMessage = "There is no employee with Id = " + id + " in Database";
//            throw new EmployeeNotFoundException(errorMessage);
//        }
//        return employee;
//    }
//
//    @PostMapping
//    public Employee add(@RequestBody Employee employee) {
//        employeeService.saveEmployee(employee);
//        return employee;
//    }
//
//    @PutMapping
//    public Employee update(@RequestBody Employee employee) {
//        employeeService.saveEmployee(employee);
//        return employee;
//    }
//
//    @DeleteMapping("{id}")
//    public String delete(@PathVariable long id) {
//        Employee employee = getById(id);
//
////        Employee employee = employeeService.getEmployee(id);
////        if (employee == null) {
////            String errorMessage = "There is no employee with Id = " + id + " in Database";
////            throw new EmployeeNotFoundException(errorMessage);
////        }
//
//        employeeService.deleteById(id);
//        return "Employee with ID = " + id + " was deleted.";
//    }
}
