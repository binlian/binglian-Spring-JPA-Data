package com.binglian.repository;

import org.springframework.data.repository.CrudRepository;

import com.binglian.domain.Employee;

public interface EmployeeCrudRespority extends CrudRepository<Employee, Integer>{

}
