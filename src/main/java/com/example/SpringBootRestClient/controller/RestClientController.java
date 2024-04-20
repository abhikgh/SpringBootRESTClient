package com.example.SpringBootRestClient.controller;

import com.example.SpringBootRestClient.model.Employee;
import com.example.SpringBootRestClient.service.RestClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rcl")
public class RestClientController {

    @Autowired
    private RestClientService restClientService;

    //http://localhost:8686/rcl/getEmployeeById/11351
    @GetMapping(value = "/getEmployeeById/{employeeId}")
    public Employee getEmployeeById(@PathVariable("employeeId") Integer employeeId){
        return restClientService.getEmployeeById(employeeId);
    }

    //http://localhost:8686/rcl/getAllEmployees
    @GetMapping(value = "/getAllEmployees")
    public List<Employee> getAllEmployees(){
        return restClientService.getAllEmployees();
    }
}
