package com.jiao.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jiao.dao.StuDao;
import com.jiao.domain.Student;
import com.jiao.service.StuService;
@Service
public class StuServiceImpl implements StuService{
	
	@Autowired
	private StuDao stuDao;
	
	@Override
	public List<Student> getAll() {
		 List<Student> allStudent = stuDao.getAll();
		return allStudent;
	}
	
	@Override
	public Integer modifyById(Student stu) {
		Integer count = stuDao.modifyById(stu);
		return count;
	}

	

	@Override
	public Integer addStudent(Student stu) {
		return stuDao.addStudent(stu);
	}

	@Override
	public Integer deleteById(Integer id) {
		return stuDao.deleteById(id);
	}
	
	@Override
	public List<Student> getStudentById(Integer id) {
		return stuDao.getStudentById(id);
	}

	@Override
	public List<Student> getStudentByName(Student stu) {
		return stuDao.getStudentByName(stu);
	}



	


	

}
