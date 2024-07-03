package com.luv2code.springboot.cruddemo.services;

import com.luv2code.springboot.cruddemo.entities.Employee;
import com.luv2code.springboot.cruddemo.repositories.EmployeeDAO;
import com.luv2code.springboot.cruddemo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeDAO employeeDAO;
    EmployeeRepository repository;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Autowired
    public void setRepository(EmployeeRepository repository) {
        this.repository = repository;
    }

//    @Override
//    public List<Employee> findAll() {
//        return employeeDAO.findAll();
//    }
    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }
//    @Override
//    public Employee findById(Long Id) {
//        return employeeDAO.findById(Id);
//    }
    @Override
    public Employee findById(Long Id) {
        Optional<Employee> result = repository.findById(Id);
        if(result.isPresent())
            return result.get();
        else
            throw new RuntimeException("The employee with the Id: %d does not exist".formatted(Id));
    }

//    @Override
//    @Transactional
//    public Employee saveOrUpdate(Employee employee) {
//        return employeeDAO.saveOrUpdate(employee);
//    }

    @Override
    public Employee saveOrUpdate(Employee employee) {
        return repository.save(employee);
    }

//    @Override
//    @Transactional
//    public void deleteById(Long Id) {
//        employeeDAO.deleteById(Id);
//    }
    @Override
    public void deleteById(Long Id) {
        repository.deleteById(Id);
    }

}
