package com.luv2code.springboot.cruddemo.repositories;

import com.luv2code.springboot.cruddemo.entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    EntityManager entityManager;


    @Autowired
    public EmployeeDAOImpl(EntityManager em){
        entityManager = em;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery <Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    public Employee findById(Long Id) {
        return entityManager.find(Employee.class, Id);
    }
}
