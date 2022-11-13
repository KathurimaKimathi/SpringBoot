package com.oryx.restapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.oryx.restapi.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    

}
