package com.cesystem.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cesystem.dao.ClassesDao;
import com.cesystem.pojo.Classes;
import com.cesystem.pojo.Major;
import com.cesystem.pojo.Users;
@Repository
public class ClassesDaoImpl extends BaseDaoImpl implements ClassesDao {

	@Override
	public Classes getClassesById(int classId) {
		// TODO Auto-generated method stub
		Classes classes = new Classes();
		classes = (Classes) this.getById(classes, classId);
		return classes;
	}

	@Override
	public List<Classes> getClassesListByMAndG(int majorId, int gradeId) {
		// TODO Auto-generated method stub
		List<Classes> classList = null;
		String hql = "from Classes as c where c.majorId=? and c.gradeId=?";
		String[]param = new String[]{Integer.toString(majorId),Integer.toString(gradeId)};
		classList = this.getHibernateTemplate().find(hql, param);
		if(classList.size()==0) {
			return null;
		} else {
			return classList;
		}
	}

	@Override
	public Classes getClassesByNumber(String classNumber) {
		
		List<Classes> classList = null;
		String hql = "from Classes as c where c.classNumber=?";
		classList = this.getHibernateTemplate().find(hql, classNumber);
		if(classList.size()==0) {
			return null;
		} else {
			Classes classes = classList.get(0);
			return classes;
		}
	}

	@Override
	public List<Classes> getAllClass() {
		List<Classes> classList = null;
		String hql = "from Classes ";
		classList = this.getHibernateTemplate().find(hql);
		
		return classList;
	}

}
