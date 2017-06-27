package com.cesystem.dao;

import java.sql.Timestamp;
import java.util.List;

import com.cesystem.pojo.Notice;

public interface NoticeDao extends BaseDao {
	
	/**
	 * 添加公告
	 * @param title
	 * @param content
	 * @param time
	 * @param type
	 * @param jumpId
	 */
	public void putNotice(String title,String content,Timestamp time,String type,int jumpId);
	
	
	/**
	 * 获取所有可读notice
	 * @return
	 */
	public List<Notice> getAllUseful();
	
	
	/**
	 * 更改公告状态
	 * @param id
	 * @return
	 */
	public boolean modifyStatus(int id,String status);
	
	/**
	 * 获取单个公告
	 * @param id
	 * @return
	 */
	public Notice getNoticeById(int id);

}
