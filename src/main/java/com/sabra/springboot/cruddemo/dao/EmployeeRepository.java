package com.sabra.springboot.cruddemo.dao;

import com.sabra.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    // no need to write any code
}
