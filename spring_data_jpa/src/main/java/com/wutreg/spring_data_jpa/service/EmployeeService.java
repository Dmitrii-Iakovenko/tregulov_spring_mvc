package com.wutreg.spring_data_jpa.service;


import com.wutreg.spring_data_jpa.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee saveEmployee(Employee employee);

    Employee getEmployee(long id);

    void deleteById(long id);

    List<Employee> findAllByName(String name);
}
