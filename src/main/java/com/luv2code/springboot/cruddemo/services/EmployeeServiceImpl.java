package com.luv2code.springboot.cruddemo.services;

import com.luv2code.springboot.cruddemo.entities.Employee;
import com.luv2code.springboot.cruddemo.repositories.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(Long Id) {
        return employeeDAO.findById(Id);
    }

    @Override
    @Transactional
    public Employee saveOrUpdate(Employee employee) {
        return employeeDAO.saveOrUpdate(employee);
    }

    @Override
    @Transactional
    public void deleteById(Long Id) {
        employeeDAO.deleteById(Id);
    }
}
