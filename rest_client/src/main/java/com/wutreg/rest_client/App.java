package com.wutreg.rest_client;

import com.wutreg.rest_client.config.AppConfig;
import com.wutreg.rest_client.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Communication communication = context.getBean("communication", Communication.class);


        System.out.println("********* Get All *********");
        communication
                .getAllEmployees()
                .forEach(System.out::println);

        System.out.println("********* Get By Id *************");
        System.out.println(communication.getByIdEmployee(6));


        System.out.println("********* Add ***********");
        Employee employee = new Employee("Света", "Соколова",
                "HR", 800);
        employee = communication.saveOrUpdateEmployee(employee);
        System.out.println(employee);

        System.out.println("********* Update ***********");
        employee.setDepartment("IT");
        employee.setSalary(1200);
        communication.saveOrUpdateEmployee(employee);

        System.out.println("********* Delete ***********");
        communication.deleteEmployee(employee.getId());

    }
}
