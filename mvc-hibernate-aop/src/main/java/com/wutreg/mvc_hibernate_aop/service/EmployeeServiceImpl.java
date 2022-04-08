package com.wutreg.mvc_hibernate_aop.service;

import com.wutreg.mvc_hibernate_aop.dao.EmployeeDAO;
import com.wutreg.mvc_hibernate_aop.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getEmployee(long id) {
        return employeeDAO.getEmployee(id);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        employeeDAO.deleteById(id);
    }
}
