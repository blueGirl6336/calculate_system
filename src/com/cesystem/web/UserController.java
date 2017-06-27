package com.cesystem.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cesystem.dao.StudentDao;
import com.cesystem.pojo.Student;
import com.cesystem.pojo.Users;
import com.cesystem.service.UserService;
import com.cesystem.util.ResponseMapUtil;

@Controller
@RequestMapping(value = "/users")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private HttpServletRequest request;
	
	
	/**
	 * ��¼�ӿ�
	 * @param userName
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView login(@RequestParam String userName,
			@RequestParam String password) {

		ModelAndView mv = new ModelAndView();
		Users users = userService.login(userName, password);
		if (users == null)
		{
			mv.setViewName("login");
			return mv;
		}
		else {
			if(users.getUserRole().equals("100002")){
				
				mv.setViewName("main.htm");
				
			}else if(users.getUserRole().equals("100001")){
				Student student = studentDao.getStudentByUserId(users.getUserId());
				
				HttpSession session = request.getSession();
				session.setAttribute("studentId", student.getStudentId());
				
				int apartmentId = student.getApartment().getApartmentId();
				if(4 == apartmentId)
				{
					mv.setViewName("rank2");
				}
				else
				{
					mv.setViewName("rank");
				}
			}
			return mv;
		}
	}
	
	/**
	 * ע��ӿ�
	 * @param userName
	 * @param password
	 * @param studentName
	 * @param classId
	 * @return
	 */
	@RequestMapping(value = "/regist")
	@ResponseBody
	public Map<String, Object> regist(@RequestParam String userName,
			@RequestParam String password, @RequestParam String studentName,
			@RequestParam int classId) {
		int flag = userService.regist(userName, password, classId, studentName);
		if(flag == 0)
			return ResponseMapUtil.responseSuccessMess("ע��ɹ�");
		else if(flag == 1)
			return ResponseMapUtil.responseError("ע��ʧ��,��ѧ����ע��");
		else if(flag == 2)
			return ResponseMapUtil.responseError("ע��ʧ�ܣ��˰༶������");
		else
			return ResponseMapUtil.responseError("ע��ʧ��");

 
	}

}
