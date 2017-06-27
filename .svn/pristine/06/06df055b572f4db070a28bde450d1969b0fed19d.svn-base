package com.cesystem.service;

import java.util.List;

import com.cesystem.pojo.Notice;
import com.cesystem.temp.NoticeTemp;

public interface NoticeService {
	
	/**
	 * 获取所有可读公告
	 * @return
	 */
	public List<Notice> getAllUseful();
	
	
	/**
	 * 添加公告
	 * @param title
	 * @param content
	 * @param time
	 * @param type
	 * @param jumpId
	 * @return
	 */
	public void addNormalNotice(String title,String content);
	
	
	/**
	 * 取消公告
	 * @param id
	 * @return
	 */
	public boolean cancelNotice(int id);
	
	
	/**
	 * 获取最新的公告
	 * @return
	 */
	public Notice getLatestNotice();

	public List<NoticeTemp> getAll();
}
