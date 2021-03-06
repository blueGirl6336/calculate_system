package com.cesystem.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cesystem.dao.AuditScoreDao;
import com.cesystem.pojo.AuditScore;

@Repository
public class AuditScoreDaoImpl extends BaseDaoImpl implements AuditScoreDao {

	@Override
	public List<AuditScore> searchAuditScoreByUserName(String userName) {
		String hql = "from AuditScore as a where a.studentByObjectId.users.userName =" + userName + "or a.studentByApplicantId.users.userName = " + userName;
		List<AuditScore> auditScoreList = (List<AuditScore>) this.getHibernateTemplate().find(hql);
		return auditScoreList;
	}

	@Override
	public List<AuditScore> searchAllAuditScore() {
		String hql = "from AuditScore";
		List<AuditScore> auditScoreList = (List<AuditScore>) this.getHibernateTemplate().find(hql);
		return auditScoreList;
	}

}
