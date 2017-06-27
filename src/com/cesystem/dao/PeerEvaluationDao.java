package com.cesystem.dao;

import java.util.List;

import com.cesystem.pojo.PeerEvaluation;

public interface PeerEvaluationDao extends BaseDao{

	public List<PeerEvaluation> getPeerEvaluation(String classId);
	public List<PeerEvaluation> getPeerEvaluationByObjectId(int objectId);
	public List<PeerEvaluation> getPeerEvaluationByStudentId(int studentId);
}
