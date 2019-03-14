package com.binglian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.binglian.domain.Employee;

/**
 * 也是可以多继承
 * @author binglian
 *
 */
public interface EmployeeJpaSpecificationExecutorRepository 
		extends JpaRepository<Employee, Integer>,JpaSpecificationExecutor<Employee>{

}
