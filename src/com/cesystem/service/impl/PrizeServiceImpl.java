package com.cesystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesystem.dao.PrizeDao;
import com.cesystem.pojo.Prize;
import com.cesystem.service.PrizeService;


@Service
public class PrizeServiceImpl implements PrizeService {

	@Autowired
	private PrizeDao prizeDao;
	@Override
	public List<Prize> getAll() {
		// TODO Auto-generated method stub
		
		return prizeDao.getAll();
	}

	@Override
	public boolean addPrize(String prizeName, String prizeDetail,String prizeNeed) {
		// TODO Auto-generated method stub
		Prize prize = new Prize();
		prize.setPrizeDetail(prizeDetail);
		prize.setPrizeName(prizeName);
		prize.setPrizeNeed(prizeNeed);
		
		prizeDao.add(prize);
		
		return true;
	}

	@Override
	public boolean deletePrize(int prizeId) {
		// TODO Auto-generated method stub
		Prize prize = prizeDao.getPrizeById(prizeId);
		if(prize == null)
			return false;
		prizeDao.delete(prize);
		
		return true;
	}

	@Override
	public Prize getById(int prizeId) {
		return prizeDao.getPrizeById(prizeId);
	}

}
