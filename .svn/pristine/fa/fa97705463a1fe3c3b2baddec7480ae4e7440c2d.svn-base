package com.cesystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesystem.dao.AddPrizeDao;
import com.cesystem.pojo.AddPrize;
import com.cesystem.pojo.Prize;
import com.cesystem.service.AddPrizeService;
import com.cesystem.service.NoticeService;

@Service
public class AddPrizeServiceImpl implements AddPrizeService {

	@Autowired
	AddPrizeDao addPrizeDao;
	@Autowired
	NoticeService noticeService;
	
	//申请添加加分项
	@Override
	public void addAddPrize(AddPrize addPrize) {
		this.addPrizeDao.add(addPrize);
	}

	//修改申请添加加分项信息
	@Override
	public void modifyAddPrize(AddPrize addPrize) {
		addPrizeDao.update(addPrize);
	}

	//删除申请添加加分项信息
	@Override
	public void deleteAddPrize(AddPrize addPrize) {
		addPrizeDao.delete(addPrize);
	}

	//根据部门查询
	@Override
	public List<AddPrize> searchAddPrizeByApartmentId(int apartmentId) {
		return addPrizeDao.searchAddPrizeByApartmentId(apartmentId);
	}
	
	//获取所有奖项
	@Override
	public List<AddPrize> getAll() {
		return addPrizeDao.getAll();
	}

	@Override
	public boolean changeStatus(int adpId,String status) {
		AddPrize addPrize = new AddPrize();
		addPrize =addPrizeDao.getOneById(adpId, addPrize);
		
		if(addPrize == null){
			return false;
		}
		
		if(!addPrize.getStatus().equals("600001")) {
			return false;
		}
		
		addPrize.setStatus(status);
		addPrizeDao.update(addPrize);
		
		if(status.equals("600002")) {
			
			Prize prize = new Prize();
			prize.setApartment(addPrize.getApartment());
			prize.setPrizeDetail(addPrize.getPrizeDetail());
			prize.setPrizeName(addPrize.getPrizeName());
			prize.setPrizeNeed(addPrize.getPrizeNeed());
			addPrizeDao.add(prize);
			String title = "新增奖项："+addPrize.getPrizeName();
			String content = "奖项名称："+addPrize.getPrizeName()+"\n奖项介绍："+addPrize.getPrizeDetail()+"\n获奖需要："+addPrize.getPrizeNeed();
			noticeService.addNormalNotice(title, content);
		}
		
		return true;
		
		
		
	}
	
	
}
