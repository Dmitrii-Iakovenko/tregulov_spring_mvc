package com.wutreg.spring_data_jpa.service;

import com.wutreg.spring_data_jpa.entity.Employee;
import com.wutreg.spring_data_jpa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository
            .findAll();
    }

    @Override
    public Employee getEmployee(long id) {
        return employeeRepository
            .findById(id)
            .orElseThrow();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository
            .save(employee);
    }


    @Override
    public void deleteById(long id) {
        employeeRepository
            .deleteById(id);
    }

    @Override
    public List<Employee> findAllByName(String name) {
        return employeeRepository
            .findAllByName(name);
    }
}
