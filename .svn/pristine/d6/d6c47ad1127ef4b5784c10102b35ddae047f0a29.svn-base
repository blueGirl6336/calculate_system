package com.cesystem.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cesystem.dao.NoticeDao;
import com.cesystem.pojo.Notice;

@Repository
public class NoticeDaoImpl extends BaseDaoImpl implements NoticeDao {

	@Override
	public void putNotice(String title, String content, Timestamp time,
			String type, int jumpId) {
		
		Notice notice = new Notice(title, content, time, type, jumpId, "800001");
		this.add(notice);
		
	}

	@Override
	public List<Notice> getAllUseful() {
		String hql = "FROM Notice WHERE status = '800001' order by time desc";
		List<Notice> notices = this.getHibernateTemplate().find(hql);
		
		return notices;
	}
	
	

	@Override
	public boolean modifyStatus(int id,String status) {
		
		Notice notice = this.getNoticeById(id);
		
		if(notice == null)
			return false;
		
		notice.setStatus(status);
		this.update(notice);
		
		return true;
	}

	@Override
	public Notice getNoticeById(int id) {
		
		Notice notice = new Notice();
		
		notice = this.getOneById(id,notice);
		
		return notice;
	}

}
