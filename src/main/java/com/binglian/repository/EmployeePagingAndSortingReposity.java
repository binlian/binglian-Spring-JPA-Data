package com.binglian.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.binglian.domain.Employee;

public interface EmployeePagingAndSortingReposity extends PagingAndSortingRepository<Employee, Integer>{

}
