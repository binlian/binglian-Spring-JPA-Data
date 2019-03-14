package com.binglian.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.binglian.domain.Employee;

public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer>{

}
