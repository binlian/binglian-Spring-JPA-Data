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
     * ��ҳ
     * ����
     * ��ѯ����
     */
    @Test
    public void testQuery(){
    	//����id��������
    	Sort.Order order=new Sort.Order(Sort.Direction.DESC,"id");
    	Sort sort=new Sort(order);
    
    	
    	
    	//page��index��0��ʼ��,���Ǵ�1��ʼ��
    	Pageable pageable=new PageRequest(0, 5);
    	
    	
    	/**
    	 * root:��������Ҫ��ѯ������(Employee)
    	 * query:��Ӳ�ѯ�콣
    	 * cb:����Predicate
    	 */
    	Specification<Employee> specification=new Specification<Employee>() {

			@Override
			public Predicate toPredicate(Root<Employee> root,
						CriteriaQuery<?> query, 
						CriteriaBuilder cb) {

				Path path=root.get("age");
				
				
				return cb.gt(path, 50);//age����20;
			}
		
    	};
    	
    	Page<Employee> page=employeeJpaSpecificationExecutorRepository.findAll(specification,pageable);
    	
//    	Page<Employee> page=employeeJpaSpecificationExecutorRepository.findAll(pageable);
    
    	System.out.println("��ѯ����ҳ��"+page.getTotalPages());
    	System.out.println("��ѯ���ܼ�¼��"+page.getTotalElements());
    	System.out.println("��ѯ�ĵ�ǰ�ڼ�ҳ"+page.getNumber());
    	System.out.println("��ѯ�ĵ�ǰҳ��ļ���"+page.getContent());
    	System.out.println("��ѯ�ĵ�ǰҳ��ļ�¼��"+page.getNumberOfElements());
    	
    }
}
