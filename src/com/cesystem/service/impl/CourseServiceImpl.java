package com.cesystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesystem.dao.CourseDao;
import com.cesystem.pojo.Course;
import com.cesystem.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseDao courseDao;

	@Override
	public Course searchByCourseName(String courseName) {
		return this.courseDao.searchByCourseName(courseName);
	}

	@Override
	public List<Course> getAllCourse() {
		return courseDao.getAllCourse();
	}
	
	

}
