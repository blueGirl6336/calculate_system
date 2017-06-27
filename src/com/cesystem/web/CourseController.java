package com.cesystem.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cesystem.pojo.Course;
import com.cesystem.service.CourseService;
import com.cesystem.util.ResponseMapUtil;

@Controller
@RequestMapping(value = "/course")
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@RequestMapping(value = "/getAllCourse")
	@ResponseBody
	public Map<String, Object> getAllCourse() {
		
		List<Course> courseList = courseService.getAllCourse();
		
		if("".equals(courseList) || courseList == null) {
			return ResponseMapUtil.responseError(null);
		} else {
			return ResponseMapUtil.responseSuccess(courseList);
		}
	}
}
