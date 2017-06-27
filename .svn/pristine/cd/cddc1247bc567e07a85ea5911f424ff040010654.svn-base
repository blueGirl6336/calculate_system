package com.cesystem.service;

import java.util.List;

import com.cesystem.pojo.Apartment;

public interface ApartmentService {
	/**
	 *获取所有部门
	 * @return
	 */
	public List<Apartment> getAll();
	/**
	 * 添加部门
	 * @param apartmentName
	 * @return
	 */
	public int addApartment(String apartmentName);
	
	/**
	 * 删除部门
	 * @param apartmentId
	 * @return
	 */
	public boolean deleteApartment(int apartmentId);
	
	/**
	 * 分配部门
	 * @param apartmentId
	 * @param studentId
	 * @return
	 */
	public boolean distributeApartment(int apartmentId,int studentId);

}
