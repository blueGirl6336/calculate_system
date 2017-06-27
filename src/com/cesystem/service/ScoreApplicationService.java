package com.cesystem.service;

import java.util.List;

import com.cesystem.pojo.ScoreApplication;
import com.cesystem.temp.ScoreApplicationTemp;

public interface ScoreApplicationService {

    void addScoreApplication(ScoreApplication scoreApplication);
    
    void modifyScoreApplication(ScoreApplication scoreApplication);
    
    void deleteScoreApplication(ScoreApplication scoreApplication);
    
    List<ScoreApplication> searchScoreApplicationByUserName(String userName);

    List<ScoreApplication> searchScoreApplicationByApartmentId(int apartmentId);
    
    List<ScoreApplication> searchAllScoreApplication();
    
    ScoreApplication searchScoreApplicationBySaId(int saId);
    
    public boolean makeScoreApplication(int studentId, int itemId, String type, String news, int objectId);
    
    public List<ScoreApplicationTemp> getScoreApplication(int studnetId);
	
}
