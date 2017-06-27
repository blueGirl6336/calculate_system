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

import com.cesystem.pojo.AuditPrize;
import com.cesystem.pojo.PrizeApplication;
import com.cesystem.pojo.Student;
import com.cesystem.service.AuditPrizeService;
import com.cesystem.service.PrizeApplicationService;
import com.cesystem.service.StudentService;
import com.cesystem.util.ResponseMapUtil;

@Controller
@RequestMapping(value = "/auditPrize")
public class AuditPrizeController {

	@Autowired
	private AuditPrizeService auditPrizeService;
	@Autowired
	private PrizeApplicationService prizeApplicationService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private HttpServletRequest request;

	// 添加奖项申请审核情况，学生会对学生的奖项申请审核后执行此操作
	@RequestMapping(value = "/addAuditPrize")
	@ResponseBody
	public Map<String, Object> addAuditPrize(@RequestParam int paId,
			@RequestParam String userName, @RequestParam boolean isAgree,
			String remark) {

		AuditPrize auditPrize = new AuditPrize();

		PrizeApplication prizeApplication = prizeApplicationService
				.searchPrizeApplicationByPaId(paId);

		auditPrize.setPrizeApplication(prizeApplication);
		auditPrize.setStudent(studentService.searchByUserName(userName));
		auditPrize.setIsAgree(isAgree);
		auditPrize.setRemark(remark);

		auditPrizeService.addAuditPrize(auditPrize);

		return ResponseMapUtil.responseSuccess(null);

	}

	// 查看奖项申请
	@RequestMapping(value = "/searchPrizeApplication")
	@ResponseBody
	public Map<String, Object> searchPrizeApplication() {

		HttpSession session = request.getSession();
		int studentId = (Integer) session.getAttribute("studentId");
		
		Student student = studentService.getStudentById(studentId);
		List<PrizeApplication> prizeApplicationList = prizeApplicationService
				.searchPrizeApplicationByApartmentId(student.getApartment()
						.getApartmentId());

		return ResponseMapUtil.responseSuccess(prizeApplicationList);

	}

}
