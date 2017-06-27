package com.cesystem.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cesystem.pojo.Apartment;
import com.cesystem.service.ApartmentService;
import com.cesystem.util.ResponseMapUtil;

@Controller
@RequestMapping(value = "/apartment")
public class ApartmentController {
	@Autowired
	ApartmentService apartmentService;
	
	/**
	 *获取所有部门
	 * @return
	 */
	@RequestMapping(value = "/getAll")
	@ResponseBody
	public Map<String, Object> getAll() {

		List<Apartment> alist = apartmentService.getAll();

		if (alist == null)
			return ResponseMapUtil.responseError("�޲�����Ϣ");
		else
			return ResponseMapUtil.responseSuccess(alist);

	}
	
	/**
	 * 添加部门
	 * @param apartmentName
	 * @return
	 */
	@RequestMapping(value = "/add")
	@ResponseBody
	public Map<String,Object> addApartment(@RequestParam String apartmentName){
		
		int flag = apartmentService.addApartment(apartmentName);
		if(flag ==1){ 
			return ResponseMapUtil.responseError("�����Ѵ���");
		}else{
			return ResponseMapUtil.responseSuccessMess("��ӳɹ�");
		}
		
	}
	
	/**
	 * 删除部门
	 * @param apartmentId
	 * @return
	 */
	@RequestMapping(value = "/delete")
	@ResponseBody
	public Map<String,Object> deleteApartment(@RequestParam int apartmentId){
		boolean flag = apartmentService.deleteApartment(apartmentId);
		if(flag)
			return ResponseMapUtil.responseSuccessMess("ɾ��ɹ�");
		else
			return ResponseMapUtil.responseError("ɾ��ʧ��");
	}
	
	/**
	 * 分配部门
	 * @param apartmentId
	 * @param studentId
	 * @return
	 */
	@RequestMapping(value = "/distribute")
	@ResponseBody
	public Map<String, Object> distributeApartment(@RequestParam int apartmentId,@RequestParam int studentId){
		boolean flag = apartmentService.distributeApartment(apartmentId, studentId);
		if(flag){
			return ResponseMapUtil.responseSuccessMess("修改成功");
		} else {
			return ResponseMapUtil.responseError("修改失败");
		}
	}
}
