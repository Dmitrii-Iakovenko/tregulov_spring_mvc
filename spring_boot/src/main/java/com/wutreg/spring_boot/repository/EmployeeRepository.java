package com.wutreg.spring_boot.repository;


import com.wutreg.spring_boot.entity.Employee;

import java.util.List;

public interface EmployeeRepository {

    List<Employee> getAll();

    Employee saveEmployee(Employee employee);

    Employee getEmployee(long id);

    void deleteById(long id);
}
