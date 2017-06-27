package com.cesystem.service;

import java.util.List;

import com.cesystem.pojo.Prize;

public interface PrizeService {
	
	/**
	 * ��ȡ���н���
	 * @return
	 */
	public List<Prize> getAll();
	
	/**
	 * ��ӽ���
	 * @param prizeName
	 * @param prizeDetail
	 * @return
	 */
	public boolean addPrize(String prizeName,String prizeDetail,String prizeNeed);

	/**
	 * ɾ����
	 * @param prizeId
	 * @return
	 */
	public boolean deletePrize(int prizeId);
	
	Prize getById(int prizeId);

}
