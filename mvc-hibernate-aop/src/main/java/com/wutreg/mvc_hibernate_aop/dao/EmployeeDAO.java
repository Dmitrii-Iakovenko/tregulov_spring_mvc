package com.wutreg.mvc_hibernate_aop.dao;

import com.wutreg.mvc_hibernate_aop.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployee(long id);

    void deleteById(long id);
}
