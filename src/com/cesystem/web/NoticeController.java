package com.cesystem.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cesystem.service.NoticeService;
import com.cesystem.util.ResponseMapUtil;


@Controller
@RequestMapping(value = "/notice")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	/**
	 * 获取所有有用的公告
	 * @return
	 */
	@RequestMapping(value = "/getAllUseful")
	@ResponseBody
	public Map<String, Object> getAllUseful(){
		return ResponseMapUtil.responseSuccess(noticeService.getAll());
	}
	
	
	/**
	 * 添加公告
	 * @param title
	 * @param content
	 * @return
	 */
	@RequestMapping(value = "/add")
	@ResponseBody
	public Map<String, Object> addNotice(@RequestParam String title, @RequestParam String content){
		noticeService.addNormalNotice(title, content);
		return ResponseMapUtil.responseSuccessMess("发布成功");
	}
	
	/**
	 * 取消公告
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/cancel")
	@ResponseBody
	public Map<String, Object> cancelNotice(@RequestParam int id){
		boolean flag = noticeService.cancelNotice(id);
		
		if(flag){
			return ResponseMapUtil.responseSuccessMess("取消成功");
		} else {
			return ResponseMapUtil.responseError("取消失败");
		}
	}
	/**
	 * 获取最新
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getLatest")
	@ResponseBody
	public Map<String, Object> getLatestNotice(){
		return ResponseMapUtil.responseSuccess(noticeService.getLatestNotice());
	}
}
