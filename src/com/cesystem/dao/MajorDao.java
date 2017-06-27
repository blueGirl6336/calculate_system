package com.cesystem.dao;

import java.util.List;

import com.cesystem.pojo.Classes;

public interface MajorDao extends BaseDao{

	public List<Classes> getAllMajorClasses(int majorId);
	
	Classes getMajorByMajorName(String majorName);
}
