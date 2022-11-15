package com.oryx.restapi.impl;

import java.util.List;

import com.oryx.restapi.exception.ResourceNotFoundException;
import com.oryx.restapi.model.Employee;
import com.oryx.restapi.repository.EmployeeRepository;
import com.oryx.restapi.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void deleteEmployee(Long id) {
        // check if employee exists in the database or not
        employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
        
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        // check if employee exists in the database or not
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.setLastName());
        existingEmployee.setEmail(employee.getEmail());

        // save updated employee object
        employeeRepository.save(existingEmployee);

        return existingEmployee;
    }
}
