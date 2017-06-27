package com.cesystem.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cesystem.pojo.ScoreApplication;
import com.cesystem.pojo.Student;
import com.cesystem.service.ScoreApplicationService;
import com.cesystem.service.StudentService;
import com.cesystem.temp.ScoreApplicationTemp;

@Controller
@RequestMapping(value = "/scoreApplication")
public class ScoreApplicationController {

	@Autowired
	private ScoreApplicationService scoreApplicationService;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private StudentService studentService;
	
	private int studentId;
	
	/**
	 * 简单说明一下itemId
	 * @param itemId ：	对于新增项目来说：
	 * 						对于加分项来说，这个id对应的是ScoreItem的id
	 * 						对于奖项来说，这个id对应的是prize的id
	 * 					对于更新项来说：
	 * 						对于加分项来说，这个id对应的是winScore的id
	 * 						对于奖项来说，这个id对应的是winPrize的id
	 * 
	 * @param type	  ：  总共有四种type
	 * 					分别是saveScore、updateScore、savePrize和updatePrize
	 * @return
	 */
	@RequestMapping(value = "/makeScoreApplication")
	@ResponseBody
	public boolean makeScoreApplication(@RequestParam int itemId, @RequestParam String type, 
			@RequestParam String news, @RequestParam int objectId)
	{
		HttpSession session = request.getSession();
		studentId = (Integer) session.getAttribute("studentId");
		
		System.out.println("itemId:" + itemId);
		System.out.println("type:" + type);
		System.out.println("news:" + news);
		System.out.println("objectId:" + objectId);
		
		boolean isSuccess = false;
		isSuccess = scoreApplicationService.makeScoreApplication(studentId, itemId, type, news, objectId);
		
		return isSuccess;
	}
	
	@RequestMapping(value = "/getScoreApplication")
	@ResponseBody
	public List<ScoreApplicationTemp> getScoreApplication()
	{
		HttpSession session = request.getSession();
		studentId = (Integer) session.getAttribute("studentId");
		
		List<ScoreApplicationTemp> list = null;
		
		list = scoreApplicationService.getScoreApplication(studentId);
		
		return list;
	}
	
}
