package com.cesystem.web;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cesystem.pojo.ScoreItems;
import com.cesystem.pojo.Student;
import com.cesystem.pojo.WinScore;
import com.cesystem.service.StudentService;
import com.cesystem.service.WinScoreService;
import com.cesystem.util.ResponseMapUtil;

@Controller
@RequestMapping(value = "/winScore")
public class WinScoreController {

	@Autowired
	private WinScoreService winScoreService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private HttpServletRequest request;

	// 手动录入加分信息
	@RequestMapping(value = "/addWinScore")
	@ResponseBody
	public Map<String, Object> addWinScore(@RequestParam String userName,
			@RequestParam int siId, @RequestParam boolean isCurrent) {

		WinScore winScore = new WinScore();

		Student student = studentService.searchByUserName(userName);
		ScoreItems scoreItems = new ScoreItems();
		scoreItems.setSiId(siId);

		winScore.setStudent(student);
		winScore.setScoreItems(scoreItems);
		winScore.setIsCurrent(isCurrent);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = new java.util.Date();
		String time = sdf.format(date);
		winScore.setTime(time);

		winScoreService.addWinScore(winScore);

		return ResponseMapUtil.responseSuccess(null);

	}

	// 通过Excel录入加分信息
	@RequestMapping(value = "/addWinScoreByExcel")
	@ResponseBody
	public Map<String, Object> addWinScoreByExcel(
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

		this.winScoreService.addWinScoreByExcel(realPath + "/"
				+ attachs[0].getOriginalFilename());
		return ResponseMapUtil.responseSuccess(null);

	}

	// 修改加分项信息
	@RequestMapping(value = "/modifyWinScore")
	@ResponseBody
	public Map<String, Object> modifyWinScore(@RequestParam String userName,
			@RequestParam int siId, @RequestParam boolean isCurrent,
			@RequestParam int wsId) {

		WinScore winScore = winScoreService.searchWinScoreById(wsId);

		Student student = studentService.searchByUserName(userName);
		ScoreItems scoreItems = new ScoreItems();
		scoreItems.setSiId(siId);

		winScore.setStudent(student);
		winScore.setScoreItems(scoreItems);
		winScore.setIsCurrent(isCurrent);

		winScoreService.modifyWinScore(winScore);

		return ResponseMapUtil.responseSuccess(null);

	}

	// 删除加分项信息
	@RequestMapping(value = "/deleteWinScore")
	@ResponseBody
	public Map<String, Object> deleteWinScore(@RequestParam int id) {

		WinScore winScore = winScoreService.searchWinScoreById(id);

		winScoreService.deleteWinScore(winScore);

		return ResponseMapUtil.responseSuccess(null);

	}

	// 根据部门查询加分信息
	@RequestMapping(value = "/searchWinScore")
	@ResponseBody
	public Map<String, Object> searchWinScore() {

		HttpSession session = request.getSession();
		int studentId = (Integer) session.getAttribute("studentId");

		Student student = studentService.getStudentById(studentId);
		List<WinScore> winScoreList = winScoreService
				.searchWinScoreByApartmentId(student.getApartment()
						.getApartmentId());

		return ResponseMapUtil.responseSuccess(winScoreList);

	}
}
