package com.cesystem.dao;

import java.util.List;

import com.cesystem.pojo.PrizeApplication;
import com.cesystem.pojo.ScoreApplication;

public interface PrizeApplicationDao extends BaseDao {
	List<PrizeApplication> searchPrizeApplicationByUserName(String userName);

	List<PrizeApplication> searchPrizeApplicationByApartmentId(
			int apartmentId);

	List<PrizeApplication> searchAllPrizeApplication();
	PrizeApplication searchPrizeApplicationByPaId(int paId);
	
	public List<PrizeApplication> getPrizeApplication(String name);
}
