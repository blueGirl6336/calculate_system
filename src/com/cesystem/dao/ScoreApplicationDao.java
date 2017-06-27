package com.cesystem.dao;

import java.util.List;

import com.cesystem.pojo.ScoreApplication;

public interface ScoreApplicationDao extends BaseDao {
	List<ScoreApplication> searchScoreApplicationByUserName(String userName);
	List<ScoreApplication> searchScoreApplicationByApartmentId(int apartmentId);
	List<ScoreApplication> searchAllScoreApplication();
	ScoreApplication searchScoreApplicationBySaId(int saId);
	
	public int getLastId();
	
	public List<ScoreApplication> getScoreApplication(String name);
}
