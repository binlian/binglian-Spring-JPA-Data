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
import com.binglian.repository.EmployeePagingAndSortingReposity;
import com.binglian.repository.EmployeeRepository;
import com.binglian.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

public class EmployeePagingSortingRepositoryTest {


    private ApplicationContext ctx = null;

    private EmployeePagingAndSortingReposity employeePagingAndSortingReposity=null;
    
    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeePagingAndSortingReposity= ctx.getBean(EmployeePagingAndSortingReposity.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }

    
    
    @Test
    public void testPage(){
    	
    	//根据id正序排序
    	Sort.Order order=new Sort.Order(Sort.Direction.DESC,"id");
    	Sort sort=new Sort(order);
    	
    	//page：index是0开始的,不是从1开始的
    	Pageable pageable=new PageRequest(0, 5);
    	Page<Employee> page=employeePagingAndSortingReposity.findAll(pageable);
    
    	System.out.println("查询的总页数"+page.getTotalPages());
    	System.out.println("查询的总记录数"+page.getTotalElements());
    	System.out.println("查询的当前第几页"+page.getNumber());
    	System.out.println("查询的当前页面的集合"+page.getContent());
    	System.out.println("查询的当前页面的记录数"+page.getNumberOfElements());
    	
    }
   
}
