package com.wutreg.spring_boot.service;

import com.wutreg.spring_boot.entity.Employee;
import com.wutreg.spring_boot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional
    public List<Employee> getAll() {
        return employeeRepository.getAll();
    }

//    @Override
//    @Transactional
//    public void saveEmployee(Employee employee) {
//        employeeRepository.saveEmployee(employee);
//    }
//
//    @Override
//    @Transactional
//    public Employee getEmployee(long id) {
//        return employeeRepository.getEmployee(id);
//    }
//
//    @Override
//    @Transactional
//    public void deleteById(long id) {
//        employeeRepository.deleteById(id);
//    }
}
