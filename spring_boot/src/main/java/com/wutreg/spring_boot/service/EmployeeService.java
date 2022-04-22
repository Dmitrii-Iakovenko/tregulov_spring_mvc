package com.wutreg.spring_boot.service;

import com.wutreg.spring_boot.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAll();

    Employee saveEmployee(Employee employee);

    Employee getEmployee(long id);

    void deleteById(long id);
}
