package com.jiao.dao;

import java.util.List;

import com.jiao.domain.Student;
public interface StuDao {
	
	public List<Student> getAll();
	
	public List<Student> getStudentById(Integer id);
	
	public List<Student> getStudentByName(Student stu);
	
	public Integer modifyById(Student stu);
	
	public Integer addStudent(Student stu);
	
	public Integer deleteById(Integer id);
}
