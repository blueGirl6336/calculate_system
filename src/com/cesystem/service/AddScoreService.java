package com.cesystem.service;

import java.util.List;

import com.cesystem.pojo.AddScore;

public interface AddScoreService {

    void addAddScore(AddScore addScore);
    
    void modifyAddScore(AddScore addScore);
    
    void deleteAddScore(AddScore addScore);

	List<AddScore> searchAddScoreByApartmentId(int apartmentId);
	
	List<AddScore> getAll();
	
	/**
	 * 修改状态
	 * @param adsId
	 * @param status
	 */
	public boolean changeStatus(int adsId,String status);

}
