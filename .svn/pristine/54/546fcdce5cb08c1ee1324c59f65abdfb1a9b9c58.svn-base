package com.cesystem.web;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cesystem.pojo.ChooseClass;
import com.cesystem.service.ChooseClassService;
import com.cesystem.service.StudentService;
import com.cesystem.util.ResponseMapUtil;

@Controller
@RequestMapping(value = "/chooseClass")
public class ChooseClassController {

	@Autowired
	private ChooseClassService chooseClassService;
	@Autowired
	private StudentService studentService;

	// 添加学生课程成绩，此处需要前台处理excel后传入一个List
	@RequestMapping(value = "/addChooseClass")
	@ResponseBody
	public Map<String, Object> addChooseClass(
			@RequestParam("attachs") MultipartFile[] attachs,
			HttpServletRequest httpServletRequest) throws IOException {

		String realPath = httpServletRequest.getSession().getServletContext()
				.getRealPath("/resources/upload");
		System.out.println(realPath);
		for (MultipartFile attach : attachs) {
			if (attach.isEmpty())
				continue;
			File file = new File(realPath + "/" + attach.getOriginalFilename());
			FileUtils.copyInputStreamToFile(attach.getInputStream(), file);
		}

		chooseClassService.addChooseClassByExcel(realPath + "/"
				+ attachs[0].getOriginalFilename());

		return ResponseMapUtil.responseSuccess(null);
	}

	// 修改学生课程成绩
	@RequestMapping(value = "/modifyChooseClass")
	@ResponseBody
	public Map<String, Object> modifyChooseClass(@RequestParam String userName,
			@RequestParam int courseId, @RequestParam double score) {

		ChooseClass chooseClass = chooseClassService
				.searchChooseClassByUserNameAndCourseId(userName, courseId);

		chooseClass.setScore(score);

		chooseClassService.modifyChooseClass(chooseClass);

		return ResponseMapUtil.responseSuccess(null);

	}

	// 删除学生课程成绩
	@RequestMapping(value = "/deleteChooseClass")
	@ResponseBody
	public Map<String, Object> deleteChooseClass(@RequestParam int ccId) {

		ChooseClass chooseClass = chooseClassService
				.searchChooseClassById(ccId);

		chooseClassService.deleteChooseClass(chooseClass);

		return ResponseMapUtil.responseSuccess(null);

	}

	@RequestMapping(value = "/searchByMajorNameAndGradeNumber")
	@ResponseBody
	public Map<String, Object> searchByMajorNameAndGradeNumber(
			@RequestParam String majorName, @RequestParam int gradeNumber) {
		try {
			majorName = new String(majorName.getBytes("8859_1"), "utf8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<ChooseClass> studentList = chooseClassService
				.searchByMajorNameAndGradeNumber(majorName, gradeNumber);

		if ("".equals(studentList)) {
			return ResponseMapUtil.responseError(null);
		} else {
			return ResponseMapUtil.responseSuccess(studentList);
		}
	}

	@RequestMapping(value = "/searchMainByMajorNameAndGradeNumber")
	@ResponseBody
	public Map<String, Object> searchMainByMajorNameAndGradeNumber(
			@RequestParam String majorName, @RequestParam int gradeNumber) {
		try {
			majorName = new String(majorName.getBytes("8859_1"), "utf8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<ChooseClass> studentList = chooseClassService
				.searchMainByMajorNameAndGradeNumber(majorName, gradeNumber);

		if ("".equals(studentList)) {
			return ResponseMapUtil.responseError(null);
		} else {
			return ResponseMapUtil.responseSuccess(studentList);
		}
	}

}
