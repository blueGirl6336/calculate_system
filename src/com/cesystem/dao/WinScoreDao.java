package com.cesystem.dao;

import java.util.List;

import com.cesystem.pojo.WinScore;


public interface WinScoreDao extends BaseDao {

	public List<WinScore> getWinScoreByStudentId(int studentId);

    WinScore searchWinScoreById(int wsId);

	List<WinScore> searchWinScoreByUserName(String userName);

	List<WinScore> searchWinScoreByApartmentId(int apartmentId);
	
	WinScore searchByScoreApplicationId(int saId);

	List<WinScore> searchAllWinScore();
}
