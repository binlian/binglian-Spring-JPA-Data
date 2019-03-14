package com.imooc.repository;


import org.hibernate.action.internal.EntityIncrementVersionProcess;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.binglian.domain.Employee;
import com.binglian.repository.EmployeeJpaRepository;
import com.binglian.repository.EmployeePagingAndSortingReposity;
import com.binglian.repository.EmployeeRepository;
import com.binglian.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

public class EmployeeJpaRepositoryTest {


    private ApplicationContext ctx = null;

    private EmployeeJpaRepository employeeJpaRepository=null;
    
    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeJpaRepository= ctx.getBean(EmployeeJpaRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }

    
    
    @Test
    public void testFind(){
    	Employee employee=employeeJpaRepository.findOne(99);
    	
    	System.out.println("employee:"+employee);
    	
    	System.out.println("emloyee(10)"+employeeJpaRepository.exists(10));
    	System.out.println("emloyee(102)"+employeeJpaRepository.exists(102));
    }
   
}
