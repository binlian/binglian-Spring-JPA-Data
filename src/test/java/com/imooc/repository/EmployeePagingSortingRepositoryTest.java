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
    	
    	//����id��������
    	Sort.Order order=new Sort.Order(Sort.Direction.DESC,"id");
    	Sort sort=new Sort(order);
    	
    	//page��index��0��ʼ��,���Ǵ�1��ʼ��
    	Pageable pageable=new PageRequest(0, 5);
    	Page<Employee> page=employeePagingAndSortingReposity.findAll(pageable);
    
    	System.out.println("��ѯ����ҳ��"+page.getTotalPages());
    	System.out.println("��ѯ���ܼ�¼��"+page.getTotalElements());
    	System.out.println("��ѯ�ĵ�ǰ�ڼ�ҳ"+page.getNumber());
    	System.out.println("��ѯ�ĵ�ǰҳ��ļ���"+page.getContent());
    	System.out.println("��ѯ�ĵ�ǰҳ��ļ�¼��"+page.getNumberOfElements());
    	
    }
   
}
