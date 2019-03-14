package com.imooc.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.binglian.domain.Employee;
import com.binglian.repository.EmployeeJpaRepository;
import com.binglian.repository.EmployeeJpaSpecificationExecutorRepository;

public class EmployeeJpaSpecificationExecutorRepositoryTest {

	private ApplicationContext ctx = null;

    private EmployeeJpaSpecificationExecutorRepository employeeJpaSpecificationExecutorRepository=null;
    
    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeJpaSpecificationExecutorRepository= ctx.getBean(EmployeeJpaSpecificationExecutorRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }

    
    /**
     * 分页
     * 排序
     * 查询条件
     */
    @Test
    public void testQuery(){
    	//根据id正序排序
    	Sort.Order order=new Sort.Order(Sort.Direction.DESC,"id");
    	Sort sort=new Sort(order);
    
    	
    	
    	//page：index是0开始的,不是从1开始的
    	Pageable pageable=new PageRequest(0, 5);
    	
    	
    	/**
    	 * root:就是我们要查询的类型(Employee)
    	 * query:添加查询天剑
    	 * cb:构建Predicate
    	 */
    	Specification<Employee> specification=new Specification<Employee>() {

			@Override
			public Predicate toPredicate(Root<Employee> root,
						CriteriaQuery<?> query, 
						CriteriaBuilder cb) {

				Path path=root.get("age");
				
				
				return cb.gt(path, 50);//age大于20;
			}
		
    	};
    	
    	Page<Employee> page=employeeJpaSpecificationExecutorRepository.findAll(specification,pageable);
    	
//    	Page<Employee> page=employeeJpaSpecificationExecutorRepository.findAll(pageable);
    
    	System.out.println("查询的总页数"+page.getTotalPages());
    	System.out.println("查询的总记录数"+page.getTotalElements());
    	System.out.println("查询的当前第几页"+page.getNumber());
    	System.out.println("查询的当前页面的集合"+page.getContent());
    	System.out.println("查询的当前页面的记录数"+page.getNumberOfElements());
    	
    }
}
