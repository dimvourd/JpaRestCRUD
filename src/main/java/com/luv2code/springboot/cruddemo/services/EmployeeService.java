package com.luv2code.springboot.cruddemo.services;

import com.luv2code.springboot.cruddemo.entities.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(Long Id);
}
