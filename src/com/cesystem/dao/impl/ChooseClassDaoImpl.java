package com.cesystem.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cesystem.dao.ChooseClassDao;
import com.cesystem.pojo.ChooseClass;

@Repository
public class ChooseClassDaoImpl extends BaseDaoImpl implements ChooseClassDao {

	@Override
	public List<ChooseClass> searchChooseClassByUserName(String userName) {
		String hql = "from ChooseClass as c where c.student.users.userName = ? AND c.isCurrent = 1";
		List<ChooseClass> chooseClassList = (List<ChooseClass>) this.getHibernateTemplate().find(hql,userName);
		return chooseClassList;
	}

	@Override
	public List<ChooseClass> searchAllChooseClass() {
		String hql = "from ChooseClass where isCurrent = 1";
		List<ChooseClass> chooseClassList = (List<ChooseClass>) this.getHibernateTemplate().find(hql);
		return chooseClassList;
	}

	@Override
	public ChooseClass searchChooseClassById(int ccId) {
		String hql = "from ChooseClass as c where c.ccId =" + ccId + " and c.isCurrent = 1";
		ChooseClass chooseClass = (ChooseClass) this.getHibernateTemplate().find(hql);
		return chooseClass;
	}

	@Override
	public List<ChooseClass> searchChooseClassByStudentId(int studentId) {
		String hql = "from ChooseClass as c where c.isCurrent = 1 AND c.student.studentId = " + studentId;
		List<ChooseClass> chooseClassList = (List<ChooseClass>) this.getHibernateTemplate().find(hql);
		return chooseClassList;
	}

	@Override
	public List<ChooseClass> searchMainChooseClassByStudentId(int studentId) {
		String hql = "from ChooseClass as c where c.isCurrent = 1 AND c.student.studentId = " + studentId + 
				" and (c.course.type = 110001 or c.course.type = 110002)";
		List<ChooseClass> chooseClassList = (List<ChooseClass>) this.getHibernateTemplate().find(hql);
		return chooseClassList;
	}

	@Override
	public ChooseClass searchByStudentIdAndCourseId(Integer studentId,
			Integer courseId) {
		String hql = "from ChooseClass as c where c.student.studentId = " + studentId + 
				" and c.course.courseId = " + courseId;
		List<ChooseClass> chooseClassList = (List<ChooseClass>) this.getHibernateTemplate().find(hql);
		if (chooseClassList == null)
			return null;
		else
		    return chooseClassList.get(0);
	}

	

}
