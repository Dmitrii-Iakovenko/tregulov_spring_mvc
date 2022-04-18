package com.wutreg.rest_client;

import com.wutreg.rest_client.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communication {

    private final RestTemplate restTemplate;
    private static final String URL = "http://localhost:8080/api/v1/employees";

    @Autowired
    public Communication(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Employee> getAllEmployees() {
        ResponseEntity<List<Employee>> responseEntity =
                restTemplate.exchange(URL, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Employee>>() {});
        return responseEntity.getBody();
    }

    public Employee getByIdEmployee(long id) {
        return restTemplate.getForObject(URL + "/" + id, Employee.class);
    }

    public Employee saveOrUpdateEmployee(Employee employee) {
        long id = employee.getId();
        if (id == 0) {
            ResponseEntity<Employee> responseEntity =
                    restTemplate.postForEntity(URL, employee, Employee.class);
            employee = responseEntity.getBody();
            System.out.println("New employee was added to DB");
        } else {
            restTemplate.put(URL, employee);
            System.out.println("Employee with ID " + id + " was updated");
        }
        return employee;
    }

    public void deleteEmployee(long id) {
        restTemplate.delete(URL + "/" + id);
        System.out.println("Employee with ID " + id + " was deleted from DB");
    }
}
