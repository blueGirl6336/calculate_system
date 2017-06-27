package com.cesystem.dao;

import java.util.List;

import com.cesystem.pojo.AddScore;

public interface AddScoreDao extends BaseDao {

	List<AddScore> searchAddScoreByApartmentId(int apartmentId);
	
	List<AddScore> getAll();

}