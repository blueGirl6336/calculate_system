package com.cesystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesystem.dao.AddScoreDao;
import com.cesystem.pojo.AddScore;
import com.cesystem.pojo.ScoreItems;
import com.cesystem.service.AddScoreService;
import com.cesystem.service.NoticeService;

@Service
public class AddScoreServiceImpl implements AddScoreService {

	@Autowired
	AddScoreDao addScoreDao;
	@Autowired
	NoticeService noticeService;
	//申请添加加分项
	@Override
	public void addAddScore(AddScore addScore) {
		this.addScoreDao.add(addScore);
	}

	//修改申请添加加分项信息
	@Override
	public void modifyAddScore(AddScore addScore) {
		addScoreDao.update(addScore);
	}

	//删除申请添加加分项信息
	@Override
	public void deleteAddScore(AddScore addScore) {
		addScoreDao.delete(addScore);
	}

	//根据部门查询
	@Override
	public List<AddScore> searchAddScoreByApartmentId(int apartmentId) {
		return addScoreDao.searchAddScoreByApartmentId(apartmentId);
	}

	//获取所有加分想
	@Override
	public List<AddScore> getAll() {
		return addScoreDao.getAll();
	}

	@Override
	public boolean changeStatus(int adsId, String status) {
		AddScore addScore = new AddScore();
		addScore = addScoreDao.getOneById(adsId, addScore);
		if(addScore == null) {
			
			return false;
		}
		
		if(!addScore.getStatus().equals("600001")) {
			return false;
		}
		
		if(status.equals("600002")) {
			ScoreItems scoreItems = new ScoreItems();
			scoreItems.setApartment(addScore.getApartment());
			scoreItems.setItemName(addScore.getScoreName());
			scoreItems.setScore(Double.parseDouble(addScore.getScore()));
			scoreItems.setScoreType(addScore.getScoreType());
			addScoreDao.add(scoreItems);
			String typeString = "";
			if(addScore.getScoreType() .equals("300001")){
				typeString = "日常行为分";
			} else {
				typeString = "个性发展分";

			}
			String title = "新增加分项："+addScore.getScoreName();
			String content = "加分项名称："+addScore.getScoreName()+"\n所加分数："+addScore.getScore()+"\n分数种类："+typeString;
			noticeService.addNormalNotice(title, content);
		}
		
		addScore.setStatus(status);
		addScoreDao.update(addScore);
		return true;
	}
	
	
}
