package com.cesystem.web;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cesystem.pojo.Classes;
import com.cesystem.pojo.Major;
import com.cesystem.pojo.Rank;
import com.cesystem.pojo.Student;
import com.cesystem.service.ClassesService;
import com.cesystem.service.FileService;
import com.cesystem.service.StudentService;
import com.cesystem.temp.MajorRankTemp;
import com.cesystem.temp.StudentScoreTemp;
import com.cesystem.temp.StudentSimpleInf;
import com.cesystem.util.ResponseMapUtil;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	@Autowired
	private ClassesService classesService;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private FileService fileService;

	private int studentId;
	private Student student;
	private List<Rank> listRank;
	
	@RequestMapping(value = "/rank")
	@ResponseBody
	public List<Rank> getAllClassRank()
	{
		HttpSession session = request.getSession();
		studentId = (Integer) session.getAttribute("studentId");
		
		student = studentService.getStudentById(studentId);
		String classNumber = student.getClasses().getClassNumber();
		listRank = studentService.getClassRank(classNumber);
		if(null != listRank)
			System.out.println(listRank);
		
		return listRank;
	}
	
	@RequestMapping(value = "/majorRank")
	@ResponseBody
	public List<MajorRankTemp> getAllMajorRank()
	{
		HttpSession session = request.getSession();
		studentId = (Integer) session.getAttribute("studentId");
		Major major = classesService.getMajor(studentId);
		
		List<MajorRankTemp> listStudent = studentService.getMajorRank(major);
		return listStudent;
	}
	
	@RequestMapping(value = "/course")
	@ResponseBody
	public List<String> getAllCourse()
	{
		HttpSession session = request.getSession();
		studentId = (Integer) session.getAttribute("studentId");
		
		List<String> list;
		Student student = new Student();
		student = studentService.getStudentById(studentId);
		list = studentService.getAllCourse(student.getClasses().getClassNumber());
		
		return list;
	}
	
	@RequestMapping(value = "/studentScore")
	@ResponseBody
	public StudentScoreTemp getStudentScore()
	{
		HttpSession session = request.getSession();
		studentId = (Integer) session.getAttribute("studentId");
		
		StudentScoreTemp studentScoreTemp = studentService.getStudentScoreTempById(studentId);
		
		return studentScoreTemp;
	}
	
	@RequestMapping(value = "/allClassScore")
	@ResponseBody
	public List<StudentScoreTemp> getClassScore()
	{
		HttpSession session = request.getSession();
		studentId = (Integer) session.getAttribute("studentId");
		
		List<StudentScoreTemp> studentScoreTempList = new ArrayList<StudentScoreTemp>();
		
		List<Student> studentList = studentService.getAllClassStudent(studentId);
		
		if(null != studentList && 0 != studentList.size())
		{
			for(Student item : studentList)
			{
				studentScoreTempList.add(studentService.getStudentScoreTempById(item.getStudentId()));
			}
		}
		
		return studentScoreTempList;
	}
	
	@RequestMapping(value = "/allMajorScore")
	@ResponseBody
	public List<StudentScoreTemp> getMajorScore()
	{
		HttpSession session = request.getSession();
		studentId = (Integer) session.getAttribute("studentId");
		
		List<StudentScoreTemp> studentScoreTempList = new ArrayList<StudentScoreTemp>();
		
		List<Student> studentList = studentService.getMajorStudent(studentId);
		
		if(null != studentList && 0 != studentList.size())
		{
			for(Student item : studentList)
			{
				studentScoreTempList.add(studentService.getStudentScoreTempById(item.getStudentId()));
			}
		}
		
		return studentScoreTempList;
	}
	
	@RequestMapping(value = "/login")
	@ResponseBody
	public ModelAndView studentLogin()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		
		return mv;
	}
	@RequestMapping(value = "/getAll")
	@ResponseBody
	public Map<String,Object> getAllStudent(){
		Classes classes;
		List<Student> sList= studentService.getAllStudent();
		return ResponseMapUtil.responseSuccess(sList);
	}
	
	@RequestMapping(value = "/allocat")
	@ResponseBody
	public Map<String,Object> allocat(@RequestParam int studentId,@RequestParam int apartment){
		studentService.changeApartment(studentId, apartment);
		return ResponseMapUtil.responseSuccessMess("�޸ĳɹ�");
		
	}
	
	/**
	 * 通过学号查学生
	 * @param username
	 * @return
	 */
	@RequestMapping(value = "/getByUserName")
	@ResponseBody
	public Map<String, Object> getStudentByUserName(@RequestParam String username) {
		StudentSimpleInf student = studentService.searchByUserName2(username);
		
		if(student != null){
			return ResponseMapUtil.responseSuccess(student);
		}else{
			return ResponseMapUtil.responseError("未找到该学生");
		}
	}
	
	/**
	 * 通过姓名查找学生
	 * @param studentName
	 * @return
	 */
	@RequestMapping(value = "/getByStudentName")
	@ResponseBody
	public Map<String, Object> getStudentByStudentName(@RequestParam String studentName) {
		List<StudentSimpleInf> students = studentService.searchByName(studentName);
		if(students.size() == 0){
			return ResponseMapUtil.responseError("学生不存在");
		}else{
			return ResponseMapUtil.responseSuccess(students);
		}
	}
	
	
	@RequestMapping(value = "/uploadFile")
	@ResponseBody
	public Map<String, Object> manageFile(@RequestParam("file") MultipartFile file){
		CommonsMultipartFile cf= (CommonsMultipartFile)file; 
        DiskFileItem fi = (DiskFileItem)cf.getFileItem(); 
        File f = fi.getStoreLocation();
		return ResponseMapUtil.responseSuccess(fileService.manageFile(f));
		
	}

	
	/**
	 * 批量注册学生
	 * @param sList
	 * @return
	 */
	@RequestMapping(value = "/registStudents")
	@ResponseBody
	public Map<String, Object> registStudents(@RequestBody List<StudentSimpleInf> sList){
		
		String result = studentService.studentRegister(sList);
		if("".equals(result)) {
			return ResponseMapUtil.responseSuccessMess("批量注册成功");
		} else {
			return ResponseMapUtil.responseError(result);
		}
		
		
	}

	
}
