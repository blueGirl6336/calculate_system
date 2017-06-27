package com.cesystem.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cesystem.dao.WinScoreDao;
import com.cesystem.pojo.WinScore;

@Repository
public class WinScoreDaoImpl extends BaseDaoImpl implements WinScoreDao {

	@Override
	public List<WinScore> getWinScoreByStudentId(int studentId) {
		// TODO Auto-generated method stub
		List<WinScore> winScoreList = new ArrayList<WinScore>();
		String hql = "from " + "WinScore" + " where student.studentId=? and isCurrent=1";
		winScoreList = (List<WinScore>) this.getHibernateTemplate().find(hql, studentId);
		
		return winScoreList;
	}

	@Override
	public WinScore searchWinScoreById(int wsId) {
		String hql = "from WinScore as w where w.wsId =" + wsId + " and isCurrent=1";
		List<WinScore> winScoreList = (List<WinScore>) this.getHibernateTemplate().find(hql);
		return winScoreList.get(0);
	}
	
	@Override
	public List<WinScore> searchWinScoreByUserName(String userName) {
		String hql = "from WinScore as w where w.student.users.userName =" + userName + " and isCurrent=1";
		List<WinScore> winScoreList = (List<WinScore>) this.getHibernateTemplate().find(hql);
		return winScoreList;
	}
	
	@Override
	public List<WinScore> searchWinScoreByApartmentId(int apartmentId) {
		String hql = "from WinScore as w where w.isCurrent=1 and" + " w.scoreItems.siId in (select siId from ScoreItems as s where s.apartment.apartmentId = " + apartmentId + ")";
		List<WinScore> winScoreList = (List<WinScore>) this.getHibernateTemplate().find(hql);
		return winScoreList;
	}
	
	@Override
	public WinScore searchByScoreApplicationId(int saId) {
		String hql = "from WinScore as w where w.scoreApplication.saId =?" + " and isCurrent=1";
		List<WinScore> winScoreList = (List<WinScore>) this.getHibernateTemplate().find(hql, saId);
		return winScoreList.get(0);
	}
	
	@Override
	public List<WinScore> searchAllWinScore() {
		String hql = "from WinScore where isCurrent=1";
		List<WinScore> winScoreList = (List<WinScore>) this.getHibernateTemplate().find(hql);
		return winScoreList;
	}
}
