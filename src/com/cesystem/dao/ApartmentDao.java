package com.cesystem.dao;

import java.util.List;

import com.cesystem.pojo.Apartment;

public interface ApartmentDao extends BaseDao {
	
	/**
	 * 获取所有部门
	 * @return
	 */
	public List<Apartment>getAll();
	
	/**
	 * 通过id获取部门
	 * @param apartmentId
	 * @return
	 */
	public Apartment getById(int apartmentId);
	
	/**
	 *通过部门名字获取部门
	 * @param name
	 * @return
	 */
	public Apartment getByName(String name);
		


}
