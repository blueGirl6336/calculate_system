package com.cesystem.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cesystem.service.StatisticalReportsService;
import com.cesystem.util.ResponseMapUtil;

@Controller
@RequestMapping(value = "/statisticalReports")
public class StatisticalReportsController {

	@Autowired
	private StatisticalReportsService statisticalReportsService;

	// 导出成绩报表
	@RequestMapping(value = "/getScoreStatisticalReports")
	@ResponseBody
	public Map<String, Object> getScoreStatisticalReports(
			HttpServletRequest httpServletRequest) {

		String path = httpServletRequest.getSession().getServletContext()
				.getRealPath("/resources/download");
		String url = statisticalReportsService.getScoreStatisticalReports(path);

		return ResponseMapUtil.responseSuccess(url);

	}

	// 导出学生加分项报表
	@RequestMapping(value = "/getStudentScoreItemsStatisticalReports")
	@ResponseBody
	public Map<String, Object> getStudentScoreItemsStatisticalReports(
			HttpServletRequest httpServletRequest) {

		String path = httpServletRequest.getSession().getServletContext()
				.getRealPath("/resources/download");
		String url = statisticalReportsService
				.getStudentScoreItemsStatisticalReports(path);

		return ResponseMapUtil.responseSuccess(url);

	}

	// 导出学生奖项报表
	@RequestMapping(value = "/getStudentPrizeStatisticalReports")
	@ResponseBody
	public Map<String, Object> getStudentPrizeStatisticalReports(
			HttpServletRequest httpServletRequest) {

		String path = httpServletRequest.getSession().getServletContext()
				.getRealPath("/resources/download");
		String url = statisticalReportsService
				.getStudentPrizeStatisticalReports(path);

		return ResponseMapUtil.responseSuccess(url);

	}

	// 导出学生被评报表
	@RequestMapping(value = "/getPeerEvaluationStatisticalReports")
	@ResponseBody
	public Map<String, Object> getPeerEvaluationStatisticalReports(
			@RequestParam String classNumber,
			HttpServletRequest httpServletRequest) {
		String path = httpServletRequest.getSession().getServletContext()
				.getRealPath("/resources/download");
		String url = statisticalReportsService
				.getPeerEvaluationStatisticalReports(classNumber, path);

		return ResponseMapUtil.responseSuccess(url);
	}
	

	// 导出学生对学生的互评报表
	@RequestMapping(value = "/getPerPeerEvaluationStatisticalReports")
	@ResponseBody
	public Map<String, Object> getPerPeerEvaluationStatisticalReports(
			@RequestParam String classNumber,
			HttpServletRequest httpServletRequest) {
		String path = httpServletRequest.getSession().getServletContext()
				.getRealPath("/resources/download");
		String url = statisticalReportsService
				.getPerPeerEvaluationStatisticalReports(classNumber, path);

		return ResponseMapUtil.responseSuccess(url);
	}
}
