package com.binglian.dao;

import java.util.List;

import com.binglian.domain.Student;

/**
 * StudentDAO���ʽӿ�
 */
public interface StudentDAO {

	 /**
     * ��ѯ����ѧ��
     * @return ����ѧ��
     */
    public List<Student> query();

    /**
     * ���һ��ѧ��
     * @param student ����ӵ�ѧ��
     */
    public void save(Student student);

}
