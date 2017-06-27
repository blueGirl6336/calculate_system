package com.cesystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesystem.dao.ClassesDao;
import com.cesystem.dao.StudentDao;
import com.cesystem.pojo.Classes;
import com.cesystem.pojo.Major;
import com.cesystem.pojo.Student;
import com.cesystem.service.ClassesService;

@Service
public class ClassesServiceImpl implements ClassesService {

	@Autowired
	private ClassesDao classesDao;
	@Autowired
	private StudentDao studentDao;
	
	@Override
	public Major getMajor(int studentId) {
		// TODO Auto-generated method stub
		Major major = new Major();
		Student student = studentDao.getStudentById(studentId);
		Classes classes = classesDao.getClassesByNumber(student.getClasses().getClassNumber());
		major = classes.getMajor();
		
		return major;
	}

	@Override
	public List<Classes> getAllClass() {
		return classesDao.getAllClass();
	}

}
