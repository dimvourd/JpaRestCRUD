package com.luv2code.springboot.cruddemo.rest;


import com.luv2code.springboot.cruddemo.entities.Employee;
import com.luv2code.springboot.cruddemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Employee getEmployeeById(@PathVariable("employeeId") Long Id){
        return service.findById(Id);
    }

    @DeleteMapping("/{employeeId}")
    public String deleteById(@PathVariable("employeeId") Long Id){
        if(service.findById(Id) != null) {
            service.deleteById(Id);
            return String.format("Employee with the ID: %d deleted.", Id);
        }
        else return String.format("Employee with the ID: %d does not exist.", Id);
    }

    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee updatedEmployee) {
        Employee outdated = service.findById(updatedEmployee.getId());

        return service.saveOrUpdate(updatedEmployee);
    }

    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee employee){
        return service.saveOrUpdate(employee);
    }
}
