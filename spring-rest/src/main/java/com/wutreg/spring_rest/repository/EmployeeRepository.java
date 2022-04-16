package com.wutreg.spring_rest.repository;

import com.wutreg.spring_rest.entity.Employee;

import java.util.List;

public interface EmployeeRepository {

    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployee(long id);

    void deleteById(long id);
}
