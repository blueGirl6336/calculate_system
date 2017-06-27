package com.cesystem.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cesystem.pojo.AuditScore;
import com.cesystem.pojo.ScoreApplication;
import com.cesystem.pojo.Student;
import com.cesystem.service.AuditScoreService;
import com.cesystem.service.ScoreApplicationService;
import com.cesystem.service.StudentService;
import com.cesystem.util.ResponseMapUtil;

@Controller
@RequestMapping(value = "/auditScore")
public class AuditScoreController {

	@Autowired
	private AuditScoreService auditScoreService;
	@Autowired
	private ScoreApplicationService scoreApplicationService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private HttpServletRequest request;

	// 添加加分申请审核情况，学生会对学生的加分申请审核后执行此操作
	@RequestMapping(value = "/addAuditScore")
	@ResponseBody
	public Map<String, Object> addAuditScore(@RequestParam int saId,
			@RequestParam String userName, @RequestParam boolean isAgree,
			String remark) {

		AuditScore auditScore = new AuditScore();

		ScoreApplication scoreApplication = scoreApplicationService.searchScoreApplicationBySaId(saId);

		auditScore.setScoreApplication(scoreApplication);
		auditScore.setStudent(studentService.searchByUserName(userName));
		auditScore.setIsAgree(isAgree);
		auditScore.setRemark(remark);

		auditScoreService.addAuditScore(auditScore);

		return ResponseMapUtil.responseSuccess(null);

	}

	// 查看加分申请
	@RequestMapping(value = "/searchScoreApplication")
	@ResponseBody
	public Map<String, Object> searchScoreApplication() {

		HttpSession session = request.getSession();
		int studentId = (Integer) session.getAttribute("studentId");
		
		Student student = studentService.getStudentById(studentId);
		List<ScoreApplication> scoreApplicationList = scoreApplicationService
				.searchScoreApplicationByApartmentId(student.getApartment()
						.getApartmentId());

		return ResponseMapUtil.responseSuccess(scoreApplicationList);

	}
}
