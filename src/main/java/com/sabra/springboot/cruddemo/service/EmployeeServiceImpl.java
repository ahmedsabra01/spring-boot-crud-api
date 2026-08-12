package com.sabra.springboot.cruddemo.service;

import com.sabra.springboot.cruddemo.dao.EmployeeRepository;
import com.sabra.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
        employeeRepository = theEmployeeRepository;
    }


    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee theEmployee = null;
        if (result.isPresent()){
            theEmployee = result.get();
        }else{
            throw new RuntimeException("can't find Employee with id -"+ id);
        }
        return theEmployee;
    }

    @Override
    // @Transactional no need to use this annotation because jpaRepository handel this functionality
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    //@Transactional
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
