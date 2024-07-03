package com.luv2code.springboot.cruddemo.repositories;

import com.luv2code.springboot.cruddemo.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
