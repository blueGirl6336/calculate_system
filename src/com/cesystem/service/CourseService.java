package com.cesystem.service;

import java.util.List;

import com.cesystem.pojo.Course;

public interface CourseService {

	Course searchByCourseName(String courseName);

	List<Course> getAllCourse();
}
