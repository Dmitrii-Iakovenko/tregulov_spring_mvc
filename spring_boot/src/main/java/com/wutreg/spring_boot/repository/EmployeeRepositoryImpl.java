package com.wutreg.spring_boot.repository;

import com.wutreg.spring_boot.entity.Employee;
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
            .createQuery("from Employee", Employee.class)
            .getResultList();
    }

    @Override
    public Employee getEmployee(long id) {
        return entityManager
            .find(Employee.class, id);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return entityManager
            .merge(employee);
    }

    @Override
    public void deleteById(long id) {
        entityManager
            .createQuery("delete from Employee where id = :employeeId")
            .setParameter("employeeId", id)
            .executeUpdate();
    }
}
