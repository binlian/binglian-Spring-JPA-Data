package com.imooc.repository;


import org.hibernate.action.internal.EntityIncrementVersionProcess;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.binglian.domain.Employee;
import com.binglian.repository.EmployeeRepository;
import com.binglian.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

public class EmployeeCrudRepositoryTest {


    private ApplicationContext ctx = null;

    private EmployeeService employeeService=null;
    
    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeService= ctx.getBean(EmployeeService.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }

    
    @Test
    public void  testSave(){
    	
    	List<Employee> employees=new ArrayList<Employee>();
    	
    	Employee employee=null;
    	for(int i=0;i<100;i++){
    		employee=new Employee();
    		employee.setAge(100-i);
    		employee.setName("test"+i);
    		employees.add(employee);
    	}
    	
    	employeeService.save(employees);
    }
}
