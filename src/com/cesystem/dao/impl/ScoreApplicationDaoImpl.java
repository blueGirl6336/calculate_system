package com.cesystem.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cesystem.dao.ScoreApplicationDao;
import com.cesystem.pojo.PrizeApplication;
import com.cesystem.pojo.ScoreApplication;

@Repository
public class ScoreApplicationDaoImpl extends BaseDaoImpl implements ScoreApplicationDao {

	@Override
	public List<ScoreApplication> searchScoreApplicationByUserName(String userName) {
		String hql = "from ScoreApplication as s where s.studentByObjectId.users.userName =" + userName + "or s.studentByApplicantId.users.userName = " + userName;
		List<ScoreApplication> scoreApplicationList = (List<ScoreApplication>) this.getHibernateTemplate().find(hql);
		return scoreApplicationList;
	}

	@Override
	public List<ScoreApplication> searchScoreApplicationByApartmentId(
			int apartmentId) {
		String hql = "from ScoreApplication as s where s.scoreItems.siId in (select siId from ScoreItems as si where si.apartment.apartmentId = " + apartmentId + ")";
		List<ScoreApplication> scoreApplicationList = (List<ScoreApplication>) this.getHibernateTemplate().find(hql);
		return scoreApplicationList;
	}
	
	@Override
	public List<ScoreApplication> searchAllScoreApplication() {
		String hql = "from ScoreApplication";
		List<ScoreApplication> scoreApplicationList = (List<ScoreApplication>) this.getHibernateTemplate().find(hql);
		return scoreApplicationList;
	}

	@Override
	public int getLastId() {
		// TODO Auto-generated method stub
		System.out.println("--------------");
		String hql = "from ScoreApplication order by saId DESC";
		System.out.println("**************************");
		List<ScoreApplication> scoreApplicationList = (List<ScoreApplication>)this.getHibernateTemplate().find(hql);
		
		int lastId = scoreApplicationList.get(0).getSaId();
		System.out.println(lastId);
		return lastId;
	}

	@Override
	public ScoreApplication searchScoreApplicationBySaId(int saId) {
		String hql = "from ScoreApplication as s where s.saId = " + saId;
		List<ScoreApplication> scoreApplicationList = (List<ScoreApplication>) this.getHibernateTemplate().find(hql);
		if (scoreApplicationList.size()!=0 && scoreApplicationList != null)
		    return scoreApplicationList.get(0);
		else
			return null;
	}

	@Override
	public List<ScoreApplication> getScoreApplication(String name) {
		// TODO Auto-generated method stub
		String hql = "from ScoreApplication as s where"
				+ " s.studentByApplicantId.users.userName = ?";
		List<ScoreApplication> scoreApplicationList = (List<ScoreApplication>) this.getHibernateTemplate().find(hql, name);
		System.out.println(name);
		return scoreApplicationList;
	}

}
