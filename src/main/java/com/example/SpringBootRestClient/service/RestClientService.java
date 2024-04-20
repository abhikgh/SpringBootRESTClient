package com.example.SpringBootRestClient.service;

import com.example.SpringBootRestClient.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class RestClientService {

    @Autowired
    private RestClient restClient;

    public Employee getEmployeeById(Integer employeeId) {
        return restClient
                .get()
                .uri("/getEmployeeById/" + employeeId)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(Employee.class);
    }

    public List<Employee> getAllEmployees() {
        return restClient
                .get()
                .uri("/getEmployees")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(new ParameterizedTypeReference<>(){});
    }

}
