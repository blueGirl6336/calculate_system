package com.cesystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesystem.dao.PrizeApplicationDao;
import com.cesystem.dao.StudentDao;
import com.cesystem.pojo.PrizeApplication;
import com.cesystem.pojo.ScoreApplication;
import com.cesystem.pojo.Student;
import com.cesystem.service.PrizeApplicationService;
import com.cesystem.temp.PrizeApplicationTemp;
import com.cesystem.temp.ScoreApplicationTemp;

@Service
public class PrizeApplicationServiceImpl implements PrizeApplicationService {

	@Autowired
	private PrizeApplicationDao prizeApplicationDao;
	@Autowired
	private StudentDao studentDao;

	//录入分数申请信息
	@Override
	public void addPrizeApplication(PrizeApplication prizeApplication) {
		prizeApplicationDao.add(prizeApplication);
	}

	//修改分数申请信息
	@Override
	public void modifyPrizeApplication(PrizeApplication prizeApplication) {
		prizeApplicationDao.update(prizeApplication);
	}

	//删除分数申请信息
	@Override
	public void deletePrizeApplication(PrizeApplication prizeApplication) {
		prizeApplicationDao.delete(prizeApplication);
	}

	//根据学号查找分数申请信息
	@Override
	public List<PrizeApplication> searchPrizeApplicationByUserName(String userName) {
		List<PrizeApplication> prizeApplicationList = prizeApplicationDao.searchPrizeApplicationByUserName(userName);
		return prizeApplicationList;
	}

	//根据学生会成员的部门查找
	@Override
	public List<PrizeApplication> searchPrizeApplicationByApartmentId(
			int apartmentId) {
		List<PrizeApplication> prizeApplicationList = prizeApplicationDao.searchPrizeApplicationByApartmentId(apartmentId);
		return prizeApplicationList;
	}
	
	//查找所有分数申请信息
	@Override
	public List<PrizeApplication> searchAllPrizeApplication() {
		List<PrizeApplication> prizeApplicationList = prizeApplicationDao.searchAllPrizeApplication();
				return prizeApplicationList;
	}

	@Override
	public PrizeApplication searchPrizeApplicationByPaId(int paId) {
		PrizeApplication prizeApplication = prizeApplicationDao.searchPrizeApplicationByPaId(paId);
		return prizeApplication;
	}

	@Override
	public List<PrizeApplicationTemp> getPrizeApplication(int studentId) {
		// TODO Auto-generated method stub
		Student student = studentDao.getStudentById(studentId);
		List<PrizeApplication> listPrizeApplication = prizeApplicationDao.getPrizeApplication
				(student.getUsers().getUserName());
		
		List<PrizeApplicationTemp> list = new ArrayList<PrizeApplicationTemp>();
		
		PrizeApplicationTemp temp = null;
		
		if(null != listPrizeApplication && 0 != listPrizeApplication.size())
		{
			for(PrizeApplication item : listPrizeApplication)
			{
				temp = new PrizeApplicationTemp();
				temp.setApplicationDetail(item.getApplicationDetail());
				temp.setPaId(item.getPaId());
				temp.setPrize(item.getPrize());
				temp.setStatus(item.getStatus());
				temp.setStudentByApplicantId(item.getStudentByApplicantId());
				temp.setStudentByObjectId(item.getStudentByObjectId());
				temp.setTimes(item.getTime());
				temp.setType(item.getType());
				list.add(temp);
			}
		}
		
		return list;
	}


	
}