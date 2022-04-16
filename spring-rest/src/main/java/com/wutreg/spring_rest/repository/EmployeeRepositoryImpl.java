package com.wutreg.spring_rest.repository;

import com.wutreg.spring_rest.entity.Employee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public EmployeeRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Employee", Employee.class)
//                .createQuery("select Employee from Employee", Employee.class)
                .getResultList();
    }

    @Override
    public void saveEmployee(Employee employee) {
        sessionFactory
                .getCurrentSession()
                .saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(long id) {
        return sessionFactory
                .getCurrentSession()
                .get(Employee.class, id);
    }

    @Override
    public void deleteById(long id) {
        sessionFactory
                .getCurrentSession()
                .createQuery("delete from Employee where id = :employeeId")
                .setParameter("employeeId", id)
                .executeUpdate();
    }


}
