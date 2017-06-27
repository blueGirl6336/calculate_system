package com.cesystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesystem.dao.AuditPrizeDao;
import com.cesystem.dao.PrizeApplicationDao;
import com.cesystem.dao.WinPrizeDao;
import com.cesystem.pojo.AuditPrize;
import com.cesystem.pojo.PrizeApplication;
import com.cesystem.pojo.WinPrize;
import com.cesystem.service.AuditPrizeService;

@Service
public class AuditPrizeServiceImpl implements AuditPrizeService {

	@Autowired
	private AuditPrizeDao auditPrizeDao;
	@Autowired
	private PrizeApplicationDao prizeApplicationDao;
	@Autowired
	private WinPrizeDao winPrizeDao;

	//录入奖项申请审核信息
	@Override
	public void addAuditPrize(AuditPrize auditPrize) {
		
		WinPrize winPrize;
		PrizeApplication prizeApplication;

		auditPrizeDao.add(auditPrize);
		if(auditPrize.getIsAgree() == true) {
			prizeApplication = auditPrize.getPrizeApplication();
			if("400003".equals(prizeApplication.getType()) ) {
				prizeApplication.setStatus("200002");
				prizeApplicationDao.update(prizeApplication);
				winPrize = new WinPrize();
				winPrize.setStudent(auditPrize.getStudent());
				winPrize.setPrize(prizeApplication.getPrize());
				winPrize.setTime(prizeApplication.getTime());
				winPrizeDao.add(winPrize);
			}
			else if ("400005".equals(prizeApplication.getType())) {
				prizeApplication.setStatus("200002");
				prizeApplicationDao.update(prizeApplication);
				winPrize = winPrizeDao.searchByPrizeApplicationId(prizeApplication.getPaId());
				winPrizeDao.delete(winPrize);
			}
		}
		else if (auditPrize.getIsAgree() == false){
			auditPrize.getPrizeApplication().setStatus("200003");
			prizeApplicationDao.update(auditPrize.getPrizeApplication());
		}
	}

	//修改奖项申请审核信息
	@Override
	public void modifyAuditPrize(AuditPrize auditPrize) {
		auditPrizeDao.update(auditPrize);
	}

	//删除奖项申请审核信息
	@Override
	public void deleteAuditPrize(AuditPrize auditPrize) {
		auditPrizeDao.delete(auditPrize);
	}

	//根据学号查找奖项申请审核信息
	@Override
	public List<AuditPrize> searchAuditPrizeByUserName(String userName) {
		List<AuditPrize> auditPrizeList = auditPrizeDao.searchAuditPrizeByUserName(userName);
		return auditPrizeList;
	}

	//查找所有奖项申请审核信息
	@Override
	public List<AuditPrize> searchAllAuditPrize() {
		List<AuditPrize> auditPrizeList = auditPrizeDao.searchAllAuditPrize();
				return auditPrizeList;
	}

	
}
