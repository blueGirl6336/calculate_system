package com.cesystem.service;

import java.util.List;

import com.cesystem.pojo.WinScore;

public interface WinScoreService {

    void addWinScore(WinScore winScore);
    
    void addWinScoreByExcel(String path);
    
    void modifyWinScore(WinScore winScore);
    
    void deleteWinScore(WinScore winScore);
    
    WinScore searchWinScoreById(int wsId);
    
    List<WinScore> searchWinScoreByUserName(String userName);

	List<WinScore> searchWinScoreByApartmentId(int apartmentId);
	
    List<WinScore> searchAllWinScore();
    
	
}
