package com.cesystem.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cesystem.dao.PeerEvaluationDao;
import com.cesystem.pojo.PeerEvaluation;

@Repository
public class PeerEvaluationDaoImpl extends BaseDaoImpl implements PeerEvaluationDao {

	@Override
	public List<PeerEvaluation> getPeerEvaluation(String classId) {
		// TODO Auto-generated method stub
		List<PeerEvaluation> list = new ArrayList<PeerEvaluation>();
		String hql = "from " + "PeerEvaluation" + " where objectId=?";
		String[]param = new String[]{classId};
		list = (List<PeerEvaluation>) this.getHibernateTemplate().find(hql, param);
		
		return list;
	}

	@Override
	public List<PeerEvaluation> getPeerEvaluationByObjectId(int objectId) {
		// TODO Auto-generated method stub
		List<PeerEvaluation> list = new ArrayList<PeerEvaluation>();
		String hql = "from " + "PeerEvaluation" + " where studentByObjectId.studentId=? and isCurrent=1";
		list = (List<PeerEvaluation>) this.getHibernateTemplate().find(hql, objectId);
		
		return list;
	}

	@Override
	public List<PeerEvaluation> getPeerEvaluationByStudentId(int studentId) {
		String hql = "from PeerEvaluation as p where p.studentByStudentId.studentId=" + studentId + " and p.isCurrent=1";
		List<PeerEvaluation> list = (List<PeerEvaluation>) this.getHibernateTemplate().find(hql);
		
		return list;
	}
}
