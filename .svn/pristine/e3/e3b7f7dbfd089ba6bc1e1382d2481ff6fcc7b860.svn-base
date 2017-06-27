package com.cesystem.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cesystem.dao.AuditPrizeDao;
import com.cesystem.pojo.AuditPrize;

@Repository
public class AuditPrizeDaoImpl extends BaseDaoImpl implements AuditPrizeDao {

	@Override
	public List<AuditPrize> searchAuditPrizeByUserName(String userName) {
		String hql = "from AuditPrize as a where a.studentByObjectId.users.userName =" + userName + "or a.studentByApplicantId.users.userName = " + userName;
		List<AuditPrize> auditPrizeList = (List<AuditPrize>) this.getHibernateTemplate().find(hql);
		return auditPrizeList;
	}

	@Override
	public List<AuditPrize> searchAllAuditPrize() {
		String hql = "from AuditPrize";
		List<AuditPrize> auditPrizeList = (List<AuditPrize>) this.getHibernateTemplate().find(hql);
		return auditPrizeList;
	}

}
