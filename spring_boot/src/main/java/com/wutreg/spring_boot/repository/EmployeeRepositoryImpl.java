package com.wutreg.spring_boot.repository;

import com.wutreg.spring_boot.entity.Employee;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getAll() {
        return entityManager
            .unwrap(Session.class)
            .createQuery("from Employee", Employee.class)
            .getResultList();
    }

    @Override
    public void saveEmployee(Employee employee) {
        entityManager
            .unwrap(Session.class)
            .saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(long id) {
        return entityManager
            .unwrap(Session.class)
            .get(Employee.class, id);
    }

    @Override
    public void deleteById(long id) {
        entityManager
            .unwrap(Session.class)
            .createQuery("delete from Employee where id = :employeeId")
            .setParameter("employeeId", id)
            .executeUpdate();
    }
}
