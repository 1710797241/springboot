package com.jiao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiao.dao.ClassDao;
import com.jiao.service.ClassService;
@Service
public class ClassServiceImpl implements ClassService{
	@Autowired
	private ClassDao classDao;
	@Override
	public List<Class> getAll() {
		return classDao.getAll();
	}


}
