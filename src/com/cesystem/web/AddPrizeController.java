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

import com.cesystem.pojo.AddPrize;
import com.cesystem.pojo.Apartment;
import com.cesystem.pojo.Student;
import com.cesystem.service.AddPrizeService;
import com.cesystem.service.StudentService;
import com.cesystem.util.ResponseMapUtil;

@Controller
@RequestMapping(value = "/addPrize")
public class AddPrizeController {

	@Autowired
	private AddPrizeService addPrizeService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private HttpServletRequest request;

	// 添加奖项申请审核
	@RequestMapping(value = "/addAddPrize")
	@ResponseBody
	public Map<String, Object> addPrize(@RequestParam String prizeName,
			@RequestParam String prizeNeed, @RequestParam String prizeDetail,
			@RequestParam String addDetail) {

		try {
			prizeName = new String(prizeName.getBytes("8859_1"), "utf8");
			prizeNeed = new String(prizeNeed.getBytes("8859_1"), "utf8");
			prizeDetail = new String(prizeDetail.getBytes("8859_1"), "utf8");
			addDetail = new String(addDetail.getBytes("8859_1"), "utf8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HttpSession session = request.getSession();
		int studentId = (Integer) session.getAttribute("studentId");

		Student student = studentService.getStudentById(studentId);

		AddPrize addPrize = new AddPrize();
		Apartment apartment = student.getApartment();

		addPrize.setApartment(apartment);
		addPrize.setPrizeName(prizeName);
		addPrize.setPrizeNeed(prizeNeed);
		addPrize.setPrizeDetail(prizeDetail);
		addPrize.setAddDetail(addDetail);
		addPrize.setStatus("600001");

		addPrizeService.addAddPrize(addPrize);

		return ResponseMapUtil.responseSuccess(null);

	}

	// 查看奖项申请审核情况
	@RequestMapping(value = "/searchAddPrize")
	@ResponseBody
	public Map<String, Object> searchAddPrize() {

		HttpSession session = request.getSession();
		int studentId = (Integer) session.getAttribute("studentId");

		Student student = studentService.getStudentById(studentId);

		List<AddPrize> addPrizeList = addPrizeService
				.searchAddPrizeByApartmentId(student.getApartment()
						.getApartmentId());

		return ResponseMapUtil.responseSuccess(addPrizeList);
	}

	/**
	 * 获取所有奖项申请
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getAll")
	@ResponseBody
	public Map<String, Object> getAll() {
		return ResponseMapUtil.responseSuccess(addPrizeService.getAll());
	}

	/**
	 * 审核
	 * 
	 * @param apsId
	 * @param status
	 * @return
	 */
	@RequestMapping(value = "/changeStatus")
	@ResponseBody
	public Map<String, Object> changeStatus(@RequestParam int apsId,
			@RequestParam String status) {
		boolean flag = addPrizeService.changeStatus(apsId, status);
		if (flag) {
			return ResponseMapUtil.responseSuccessMess("审核成功");

		} else {
			return ResponseMapUtil.responseError("审核失败，该信息已审核过或者不存在");

		}

	}

}
