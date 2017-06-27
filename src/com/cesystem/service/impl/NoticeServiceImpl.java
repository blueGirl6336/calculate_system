package com.cesystem.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesystem.dao.NoticeDao;
import com.cesystem.pojo.Notice;
import com.cesystem.service.NoticeService;
import com.cesystem.temp.NoticeTemp;
import com.cesystem.util.TimeUseUtil;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	NoticeDao noticeDao;
	
	@Override
	public List<Notice> getAllUseful() {
		
		return noticeDao.getAllUseful();
	}

	@Override
	public void addNormalNotice(String title, String content) {
		
		noticeDao.putNotice(title, content, TimeUseUtil.nowTime(), "700001", 0);
		
	}

	@Override
	public boolean cancelNotice(int id) {
		
		return noticeDao.modifyStatus(id, "800002");
		
	}

	@Override
	public Notice getLatestNotice() {
		List<Notice> notices = this.getAllUseful();
		
		if(notices != null && notices.size() != 0)
			return notices.get(0);
		else {
			return null;
		}
	}

	@Override
	public List<NoticeTemp> getAll() {
		List<Notice> listNotice = noticeDao.getAllUseful();
		List<NoticeTemp> list = new ArrayList<NoticeTemp>();
		NoticeTemp noticeTemp = new NoticeTemp();
		
		if(null != listNotice && 0 != listNotice.size())
		{
			for(Notice item : listNotice)
			{
				noticeTemp = new NoticeTemp();
				noticeTemp.setContent(item.getContent());
				noticeTemp.setId(item.getId());
				noticeTemp.setJumpId(item.getJumpId());
				noticeTemp.setStatus(item.getStatus());
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");//定义日期类型格式
				String timeStr = format.format(item.getTime());//转换为字符串
				noticeTemp.setTime(timeStr);
				noticeTemp.setTitle(item.getTitle());
				noticeTemp.setType(item.getType());
				list.add(noticeTemp);
			}
		}
		
		return list;
	}

}
