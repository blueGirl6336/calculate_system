package com.cesystem.dao;

import java.util.List;

import com.cesystem.pojo.AuditPrize;

public interface AuditPrizeDao extends BaseDao {
	List<AuditPrize> searchAuditPrizeByUserName(String userName);
	List<AuditPrize> searchAllAuditPrize();
}
