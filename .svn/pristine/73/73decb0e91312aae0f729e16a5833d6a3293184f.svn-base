package com.cesystem.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cesystem.service.testService;

@Controller 
@RequestMapping(value = "/op")
public class testController {
	@Autowired
	private testService testss;
	
	
	@RequestMapping(value = "/test")
	@ResponseBody
	public String test(@RequestParam int a){
		
		testss.testAdd();
		return "testsuccess"+a;
		
	}
	@RequestMapping(value = "/test2")
	@ResponseBody
	public Map<String,Object> test2(){
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("data","testest");
		result.put("success", true);
		return result;
		
	}

}
