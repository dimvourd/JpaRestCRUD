package com.luv2code.springboot.cruddemo.repositories;

import com.luv2code.springboot.cruddemo.entities.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(Long Id);

}
