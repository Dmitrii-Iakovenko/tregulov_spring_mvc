package com.wutreg.mvc_hibernate_aop.dao;

import com.wutreg.mvc_hibernate_aop.entity.Employee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getAllEmployees() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Employee", Employee.class)
                .getResultList();
    }
}
