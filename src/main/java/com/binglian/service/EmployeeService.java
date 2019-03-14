package com.binglian.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binglian.domain.Employee;
import com.binglian.repository.EmployeeCrudRespority;
import com.binglian.repository.EmployeeRepository;

import java.util.List;

import javax.transaction.Transactional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeCrudRespority employeeCrudRespority;
    
    @Transactional
    public void update(Integer id, Integer age) {
        employeeRepository.update(id, age);
    }
    
    
    @Transactional
    public void save(List<Employee> employees){
    	employeeCrudRespority.save(employees);
    }
    
}
