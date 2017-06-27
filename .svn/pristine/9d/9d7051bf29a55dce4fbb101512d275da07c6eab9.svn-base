package com.cesystem.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cesystem.pojo.Prize;
import com.cesystem.service.PrizeService;
import com.cesystem.util.ResponseMapUtil;

@Controller
@RequestMapping(value = "/prize")
public class PrizeController {

	@Autowired
	PrizeService prizeService;

	/**
	 * 获取所有奖项
	 * @return
	 */
	@RequestMapping(value = "/getAll")
	@ResponseBody
	public Map<String, Object> getAll() {
		List<Prize> pList = prizeService.getAll();
		return ResponseMapUtil.responseSuccess(pList);
	}
	
	
	/**、
	 * 添加奖项
	 * @param prizeName
	 * @param prizeDetail
	 * @param prizeNeed
	 * @return
	 */
	@RequestMapping(value = "/add")
	@ResponseBody
	public Map<String, Object> addPrize(@RequestParam String prizeName,
			@RequestParam String prizeDetail, @RequestParam String prizeNeed) {
		
		boolean flag = prizeService.addPrize(prizeName, prizeDetail, prizeNeed);
		
		if(flag){
			return ResponseMapUtil.responseSuccessMess("添加成功");
		}else {
			return ResponseMapUtil.responseError("添加失败");
		}
	}
	
	
	/**
	 * 删除奖项
	 * @param prizeId
	 * @return
	 */
	@RequestMapping(value = "/delete")
	@ResponseBody
	public Map<String, Object> deletePrize(@RequestParam int prizeId) {
		
		boolean flag = prizeService.deletePrize(prizeId);
		
		if(flag){
			return ResponseMapUtil.responseSuccessMess("删除成功");
		}else {
			return ResponseMapUtil.responseError("删除失败");
		}
	}

}
