package com.wutreg.spring_rest.service;

import com.wutreg.spring_rest.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployee(long id);

    void deleteById(long id);
}
