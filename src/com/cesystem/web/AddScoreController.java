package com.cesystem.web;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cesystem.pojo.AddScore;
import com.cesystem.pojo.Apartment;
import com.cesystem.pojo.Student;
import com.cesystem.service.AddScoreService;
import com.cesystem.service.StudentService;
import com.cesystem.util.ResponseMapUtil;

@Controller
@RequestMapping(value = "/addScore")
public class AddScoreController {

	@Autowired
	private AddScoreService addScoreService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private HttpServletRequest request;

	// 添加加分项申请审核
	@RequestMapping(value = "/addAddScore")
	@ResponseBody
	public Map<String, Object> addScore(@RequestParam String score,
			@RequestParam String scoreType, @RequestParam String scoreName,
			@RequestParam String addDetail) {

		try {
			score = new String(score.getBytes("8859_1"), "utf8");
			scoreType = new String(scoreType.getBytes("8859_1"), "utf8");
			scoreName = new String(scoreName.getBytes("8859_1"), "utf8");
			addDetail = new String(addDetail.getBytes("8859_1"), "utf8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HttpSession session = request.getSession();
		int studentId = (Integer) session.getAttribute("studentId");
		
		Student student = studentService.getStudentById(studentId);
		AddScore addScore = new AddScore();
		Apartment apartment = student.getApartment();

		addScore.setApartment(apartment);
		addScore.setScore(score);
		addScore.setScoreType(scoreType);
		addScore.setScoreName(scoreName);
		addScore.setAddDetail(addDetail);
		addScore.setStatus("600001");

		addScoreService.addAddScore(addScore);

		return ResponseMapUtil.responseSuccess(null);

	}

	// 查看加分项申请审核情况
	@RequestMapping(value = "/searchAddScore")
	@ResponseBody
	public Map<String, Object> searchAddScore() {

		HttpSession session = request.getSession();
		int studentId = (Integer) session.getAttribute("studentId");

		Student student = studentService.getStudentById(studentId);
		List<AddScore> addScoreList = addScoreService
				.searchAddScoreByApartmentId(student.getApartment()
						.getApartmentId());

		return ResponseMapUtil.responseSuccess(addScoreList);
	}

	/**
	 * 获取所有加分项申请
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getAll")
	@ResponseBody
	public Map<String, Object> getAll() {
		return ResponseMapUtil.responseSuccess(addScoreService.getAll());
	}

	/**
	 * 审核
	 * 
	 * @param adsId
	 * @param status
	 * @return
	 */
	@RequestMapping(value = "/changeStatus")
	@ResponseBody
	public Map<String, Object> changeStatus(@RequestParam int adsId,
			@RequestParam String status) {

		boolean flag = addScoreService.changeStatus(adsId, status);

		if (flag) {
			return ResponseMapUtil.responseSuccessMess("审核成功");

		} else {
			return ResponseMapUtil.responseError("审核失败，该信息已审核过或者不存在");
		}

	}

}
