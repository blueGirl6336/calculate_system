package com.cesystem.dao;

import java.util.List;

import com.cesystem.pojo.Classes;

public interface ClassesDao extends BaseDao {
	/**
	 * ͨ��Id��ȡclasses
	 * @param classId
	 * @return
	 */
	public Classes getClassesById(int classId);
	
	
	/**
	 * ͨ���꼶��רҵ��ȡ�༶
	 * @param majorId
	 * @param gradeId
	 * @return
	 */
	public List<Classes> getClassesListByMAndG(int majorId,int gradeId);
	
	/**
	 * 通过班号获取班级
	 * @param classNumber
	 * @return
	 */
	public Classes getClassesByNumber(String classNumber);
	
	public List<Classes> getAllClass();

}
