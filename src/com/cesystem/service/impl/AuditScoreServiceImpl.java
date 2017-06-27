package com.cesystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesystem.dao.AuditScoreDao;
import com.cesystem.dao.ScoreApplicationDao;
import com.cesystem.dao.WinScoreDao;
import com.cesystem.pojo.AuditScore;
import com.cesystem.pojo.ScoreApplication;
import com.cesystem.pojo.WinScore;
import com.cesystem.service.AuditScoreService;

@Service
public class AuditScoreServiceImpl implements AuditScoreService {

	@Autowired
	private AuditScoreDao auditScoreDao;
	@Autowired
	private ScoreApplicationDao scoreApplicationDao;
	@Autowired
	private WinScoreDao winScoreDao;

	//录入分数申请信息
	@Override
	public void addAuditScore(AuditScore auditScore) {
		WinScore winScore;
		ScoreApplication scoreApplication;

		auditScoreDao.add(auditScore);
		if(auditScore.getIsAgree() == true) {
			scoreApplication = auditScore.getScoreApplication();
			if("400004".equals(scoreApplication.getType())) {
				scoreApplication.setStatus("200002");
				scoreApplicationDao.update(scoreApplication);
				winScore = new WinScore();
				winScore.setStudent(auditScore.getStudent());
				winScore.setScoreItems(scoreApplication.getScoreItems());
				winScore.setTime(scoreApplication.getTime());
				winScoreDao.add(winScore);
			}
			else if ("400006".equals(scoreApplication.getType()) ) {
				scoreApplication.setStatus("200002");
				scoreApplicationDao.update(scoreApplication);
				winScore = winScoreDao.searchByScoreApplicationId(scoreApplication.getSaId());
				winScoreDao.delete(winScore);
			}
		}
		else if (auditScore.getIsAgree() == false){
			auditScore.getScoreApplication().setStatus("200003");
			scoreApplicationDao.update(auditScore.getScoreApplication());
		}
	}

	//修改分数申请信息
	@Override
	public void modifyAuditScore(AuditScore auditScore) {
		auditScoreDao.update(auditScore);
	}

	//删除分数申请信息
	@Override
	public void deleteAuditScore(AuditScore auditScore) {
		auditScoreDao.delete(auditScore);
	}

	//根据学号查找分数申请信息
	@Override
	public List<AuditScore> searchAuditScoreByUserName(String userName) {
		List<AuditScore> auditScoreList = auditScoreDao.searchAuditScoreByUserName(userName);
		return auditScoreList;
	}

	//查找所有分数申请信息
	@Override
	public List<AuditScore> searchAllAuditScore() {
		List<AuditScore> auditScoreList = auditScoreDao.searchAllAuditScore();
				return auditScoreList;
	}

	
}
