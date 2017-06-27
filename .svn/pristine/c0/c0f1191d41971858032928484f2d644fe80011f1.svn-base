package com.cesystem.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cesystem.pojo.Classes;
import com.cesystem.service.ClassesService;
import com.cesystem.util.ResponseMapUtil;

@Controller
@RequestMapping(value = "/classes")
public class ClassesController {

	@Autowired
	ClassesService classesService;
	
	@RequestMapping(value = "/getAllClass")
	@ResponseBody
	public Map<String, Object> getAllClass() {
		
		List<Classes> classesList = classesService.getAllClass();
		
		if("".equals(classesList) || classesList == null) {
			return ResponseMapUtil.responseError(null);
		} else {
			return ResponseMapUtil.responseSuccess(classesList);
		}
	}
}
