package com.cesystem.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesystem.dao.PrizeApplicationDao;
import com.cesystem.dao.PrizeDao;
import com.cesystem.dao.ScoreApplicationDao;
import com.cesystem.dao.ScoreItemsDao;
import com.cesystem.dao.StudentDao;
import com.cesystem.dao.WinPrizeDao;
import com.cesystem.dao.WinScoreDao;
import com.cesystem.pojo.Prize;
import com.cesystem.pojo.PrizeApplication;
import com.cesystem.pojo.ScoreApplication;
import com.cesystem.pojo.ScoreItems;
import com.cesystem.pojo.Student;
import com.cesystem.pojo.WinPrize;
import com.cesystem.pojo.WinScore;
import com.cesystem.service.ScoreApplicationService;
import com.cesystem.temp.ScoreApplicationTemp;

@Service
public class ScoreApplicationServiceImpl implements ScoreApplicationService {

	@Autowired
	private ScoreApplicationDao scoreApplicationDao;
	@Autowired
	private ScoreItemsDao scoreItemsDao;
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private WinScoreDao winScoreDao;
	@Autowired
	private PrizeDao prizeDao;
	@Autowired
	private PrizeApplicationDao prizeApplicationDao;
	@Autowired
	private WinPrizeDao winPrizeDao;

	//录入分数申请信息
	@Override
	public void addScoreApplication(ScoreApplication scoreApplication) {
		scoreApplicationDao.add(scoreApplication);
	}

	//修改分数申请信息
	@Override
	public void modifyScoreApplication(ScoreApplication scoreApplication) {
		scoreApplicationDao.update(scoreApplication);
	}

	//删除分数申请信息
	@Override
	public void deleteScoreApplication(ScoreApplication scoreApplication) {
		scoreApplicationDao.delete(scoreApplication);
	}

	//根据学号查找分数申请信息
	@Override
	public List<ScoreApplication> searchScoreApplicationByUserName(String userName) {
		List<ScoreApplication> scoreApplicationList = scoreApplicationDao.searchScoreApplicationByUserName(userName);
		
		return scoreApplicationList;
	}

	//根据学生会成员的部门查找
	@Override
	public List<ScoreApplication> searchScoreApplicationByApartmentId(int apartmentId) {
		List<ScoreApplication> scoreApplicationList = scoreApplicationDao.searchScoreApplicationByApartmentId(apartmentId);
		return scoreApplicationList;
	}
	
	//查找所有分数申请信息
	@Override
	public List<ScoreApplication> searchAllScoreApplication() {
		List<ScoreApplication> scoreApplicationList = scoreApplicationDao.searchAllScoreApplication();
				return scoreApplicationList;
	}

	@Override
	public boolean makeScoreApplication(int studentId, int itemId, String type, 
			String news, int objectId) {
		// TODO Auto-generated method stub
		
		boolean isSuccess = false;
		ScoreApplication scoreApplication = new ScoreApplication();
		PrizeApplication prizeApplication = new PrizeApplication();
		
		if("saveScore".equals(type))
		{
			ScoreItems scoreItems = new ScoreItems();
			scoreItems = scoreItemsDao.getOneById(itemId, scoreItems);
			Student studentApply = new Student();
			if(0 == objectId)
				objectId = studentId;
			studentApply = studentDao.getOneById(objectId, studentApply);
			Student studentObject = new Student();
			studentObject = studentDao.getOneById(studentId, studentObject);
			Date date = new Date(System.currentTimeMillis());
			scoreApplication.setScoreItems(scoreItems);
			scoreApplication.setStudentByApplicantId(studentApply);
			scoreApplication.setStudentByObjectId(studentObject);
			scoreApplication.setType("400006");		//加分申诉
			scoreApplication.setStatus("900001");	//待审核
			scoreApplication.setApplicationDetail(news);
			scoreApplication.setTime(date.toString());
			
			scoreApplicationDao.add(scoreApplication);
			isSuccess = true;
		}
		else if("updateScore".equals(type))
		{
			WinScore winScore = new WinScore();
			winScore = winScoreDao.getOneById(itemId, winScore);
			
			ScoreItems scoreItems = new ScoreItems();
			scoreItems = winScore.getScoreItems();
			Student studentApply = new Student();
			studentApply = studentDao.getOneById(studentId, studentApply);
			Student studentObject = new Student();
			if(0 == objectId)
				objectId = studentId;
			studentObject = studentDao.getOneById(objectId, studentObject);
			System.out.println(studentId);
			System.out.println(objectId);
			Date date = new Date(System.currentTimeMillis());
			scoreApplication.setScoreItems(scoreItems);
			scoreApplication.setStudentByApplicantId(studentApply);
			scoreApplication.setStudentByObjectId(studentObject);
			scoreApplication.setType("400006");		//加分申诉
			scoreApplication.setStatus("900001");	//待审核
			scoreApplication.setApplicationDetail(news);
			scoreApplication.setTime(date.toString());
			
			scoreApplicationDao.add(scoreApplication);
			
			//更新winScore里面指向scoreApplication的外键
			winScore.setScoreApplication(scoreApplication);
			winScoreDao.update(winScore);
			
			isSuccess = true;
		}
		else if("savePrize".equals(type))
		{
			Prize prize = new Prize();
			prize = prizeDao.getOneById(itemId, prize);
			Student studentApply = new Student();
			studentApply = studentDao.getOneById(studentId, studentApply);
			Student studentObject = new Student();
			if(0 == objectId)
				objectId = studentId;
			studentObject = studentDao.getOneById(objectId, studentObject);
			Date date = new Date(System.currentTimeMillis());
			
			prizeApplication.setApplicationDetail(news);
			prizeApplication.setPrize(prize);
			prizeApplication.setStatus("900001"); 		//待审核
			prizeApplication.setType("400005");			//奖项申诉
			prizeApplication.setStudentByApplicantId(studentApply);
			prizeApplication.setStudentByObjectId(studentObject);
			prizeApplication.setTime(date.toString());
			
			prizeApplicationDao.add(prizeApplication);
			
			isSuccess = true;
		}
		else if("updatePrize".equals(type))
		{
			WinPrize winPrize = new WinPrize();
			winPrize = winScoreDao.getOneById(itemId, winPrize);
			
			Prize prize = new Prize();
			prize = winPrize.getPrize();
			Student studentApply = new Student();
			studentApply = studentDao.getOneById(studentId, studentApply);
			Student studentObject = new Student();
			if(0 == objectId)
				objectId = studentId;
			studentObject = studentDao.getOneById(objectId, studentObject);
			Date date = new Date(System.currentTimeMillis());
			
			prizeApplication.setApplicationDetail(news);
			prizeApplication.setPrize(prize);
			prizeApplication.setStatus("900001"); 		//待审核
			prizeApplication.setType("400005");			//奖项申诉
			prizeApplication.setStudentByApplicantId(studentApply);
			prizeApplication.setStudentByObjectId(studentObject);
			prizeApplication.setTime(date.toString());
			
			prizeApplicationDao.add(prizeApplication);
			
			//更新winScore里面指向scoreApplication的外键
			winPrize.setPrizeApplication(prizeApplication);
			winPrizeDao.add(winPrize);
			isSuccess = true;
		}
		
		return isSuccess;
	}

	@Override
	public ScoreApplication searchScoreApplicationBySaId(int saId) {
		ScoreApplication scoreApplication = scoreApplicationDao.searchScoreApplicationBySaId(saId);
		return scoreApplication;
	}

	@Override
	public List<ScoreApplicationTemp> getScoreApplication(int studentId) {
		// TODO Auto-generated method stub
		Student student = studentDao.getStudentById(studentId);
		List<ScoreApplication> scoreApplicationList = scoreApplicationDao.
				getScoreApplication(student.getUsers().getUserName());
		
		List<ScoreApplicationTemp> list = new ArrayList<ScoreApplicationTemp>();
		
		ScoreApplicationTemp temp = null;
		
		if(null != scoreApplicationList && 0 != scoreApplicationList.size())
		{
			for(ScoreApplication item : scoreApplicationList)
			{
				temp = new ScoreApplicationTemp();
				temp.setApplicationDetail(item.getApplicationDetail());
				temp.setSaId(item.getSaId());
				temp.setScoreItems(item.getScoreItems());
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
