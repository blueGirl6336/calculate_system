package com.cesystem.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cesystem.dao.CourseDao;
import com.cesystem.pojo.Course;

@Repository
public class CourseDaoImpl extends BaseDaoImpl implements CourseDao {

	@Override
	public Course searchByCourseName(String courseName) {
		String hql = "from Course as c where c.courseName =" + courseName;

		List<Course> course = (List<Course>) this.getHibernateTemplate().find(hql);
		
		if (course.size()!=0 && course != null) {
			return course.get(0);
		}
		else
			return null;

	}
	

	@Override
	public Course searchByCourseNumber(String courseNumber) {
		String hql = "from Course as c where c.courseNumber = '" + courseNumber + "'";

		List<Course> course = (List<Course>) this.getHibernateTemplate().find(hql);
		
		if (course.size()!=0 && course != null) {
			return course.get(0);
		}
		else
			return null;
	}


	@Override
	public List<Course> getAllCourse() {
		String hql = "from Course";

		List<Course> course = (List<Course>) this.getHibernateTemplate().find(hql);
		
		return course;
	}

	@Override
	public boolean findSameCourse(String courseNumber, String courseName,
			Double point, String type) {
		String hql = "from Course as c where c.courseName = '" + courseName + "' and c.courseNumber = '" + courseNumber
				+ "' and c.point = ? and c.type = ?";

		List<Course> course = (List<Course>) this.getHibernateTemplate().find(hql, point, type);
		
		if (course.size()!=0 && course != null) {
			return true;
		}
		else
			return false;
	}

}
