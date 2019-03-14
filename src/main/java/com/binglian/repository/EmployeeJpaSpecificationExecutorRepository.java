package com.binglian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.binglian.domain.Employee;

/**
 * Ҳ�ǿ��Զ�̳�
 * @author binglian
 *
 */
public interface EmployeeJpaSpecificationExecutorRepository 
		extends JpaRepository<Employee, Integer>,JpaSpecificationExecutor<Employee>{

}
