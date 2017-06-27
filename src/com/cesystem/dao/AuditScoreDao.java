package com.cesystem.dao;

import java.util.List;

import com.cesystem.pojo.AuditScore;

public interface AuditScoreDao extends BaseDao {
	List<AuditScore> searchAuditScoreByUserName(String userName);
	List<AuditScore> searchAllAuditScore();
}
