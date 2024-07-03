package com.luv2code.springboot.cruddemo.rest;


import com.luv2code.springboot.cruddemo.entities.Employee;
import com.luv2code.springboot.cruddemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeRestController {

    EmployeeService service;

    @Autowired
    public void setService(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return service.findAll();
    }

    @GetMapping("/{employeeId}")
    @Transactional
    public Employee getEmployeeById(@PathVariable("employeeId") Long Id){

        return service.findById(Id);
    }
}
