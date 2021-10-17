package com.xen.spring.rest.controller;


import com.xen.spring.rest.entity.Employee;
import com.xen.spring.rest.exception_handling.EmployeeIncorrectData;
import com.xen.spring.rest.exception_handling.NoSuchEmployeeException;
import com.xen.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        if (service.getEmployee(id) == null)
            throw new NoSuchEmployeeException("There is no employee with id " + id + " in database");
        return service.getEmployee(id);
    }


    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        service.saveEmployee(employee);
        return employee;
    }

}
