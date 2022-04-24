package com.example.spring_data_rest.repository;


import com.example.spring_data_rest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


//    @Query(value = "SELECT * FROM table_name where id=?1 order by column_name"
//        , nativeQuery = true)
//    List<Object> getSmth(long id);
}
