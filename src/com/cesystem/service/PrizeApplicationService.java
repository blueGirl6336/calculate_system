package com.cesystem.service;

import java.util.List;

import com.cesystem.pojo.PrizeApplication;
import com.cesystem.temp.PrizeApplicationTemp;

public interface PrizeApplicationService {

    void addPrizeApplication(PrizeApplication prizeApplication);
    
    void modifyPrizeApplication(PrizeApplication prizeApplication);
    
    void deletePrizeApplication(PrizeApplication prizeApplication);
    
    List<PrizeApplication> searchPrizeApplicationByUserName(String userName);
    
    List<PrizeApplication> searchPrizeApplicationByApartmentId(int apartmentId);
    
    List<PrizeApplication> searchAllPrizeApplication();

    PrizeApplication searchPrizeApplicationByPaId(int paId);
    
    public List<PrizeApplicationTemp> getPrizeApplication(int studentId);
}
