package com.cesystem.dao;

import java.util.List;

import com.cesystem.pojo.Course;

public interface CourseDao extends BaseDao {
	
	Course searchByCourseName(String courseName);
	
	Course searchByCourseNumber(String courseNumber);
	
	List<Course> getAllCourse();
	
	boolean findSameCourse(String courseNumber, String courseName, Double point, String type);

}
