package com.cesystem.dao;

import java.util.List;

import com.cesystem.pojo.Prize;

public interface PrizeDao extends BaseDao {
	
	public List<Prize>getAll();
	public Prize getPrizeById(int prizeId);

	

}
