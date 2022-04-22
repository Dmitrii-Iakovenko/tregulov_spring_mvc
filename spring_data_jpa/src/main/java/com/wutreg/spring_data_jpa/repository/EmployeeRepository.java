package com.wutreg.spring_data_jpa.repository;


import com.wutreg.spring_data_jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findAllByName(String name);

//    @Query(value = "SELECT * FROM table_name where id=?1 order by column_name"
//        , nativeQuery = true)
//    List<Object> getSmth(long id);
}
