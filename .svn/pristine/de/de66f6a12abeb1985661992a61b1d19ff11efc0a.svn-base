package com.cesystem.service;

import java.util.List;

import com.cesystem.pojo.WinPrize;
import com.cesystem.temp.WinPrizeTemp;

public interface WinPrizeService {

	public List<WinPrizeTemp> getWinPrize(int studentId);

    void addWinPrize(WinPrize winPrize);
    
    void addWinPrizeByExcel(String path);

	void modifyWinPrize(WinPrize winPrize);

	void deleteWinPrize(WinPrize winPrize);

	WinPrize searchWinPrizeById(int wpId);

	List<WinPrize> searchWinPrizeByUserName(String userName);

	List<WinPrize> searchWinPrizeByApartmentId(int apartmentId);

	List<WinPrize> searchAllWinPrize();
}
