package com.cesystem.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesystem.dao.PeerEvaluationDao;
import com.cesystem.dao.StudentDao;
import com.cesystem.dao.UserDao;
import com.cesystem.pojo.PeerEvaluation;
import com.cesystem.pojo.Student;
import com.cesystem.pojo.Users;
import com.cesystem.service.PeerEvaluationService;
import com.cesystem.temp.PeerEvaluationTemp;

@Service
public class PeerEvaluationServiceImpl implements PeerEvaluationService {

private int excellentNumber;
private int goodNumber;
private int moderNumber;
private int commonNumber;
private Users users;
private Student student;
private PeerEvaluationTemp peerEvaluationTemp;
private List<Student> studentList;
private List<PeerEvaluation> peerEvaluationList;
private List<PeerEvaluationTemp> peerEvaluationListTemp;

@Autowired
private PeerEvaluationDao peerEvaluationDao;
@Autowired
private StudentDao studentDao;
@Autowired
private UserDao userDao;
	
	@Override
	public List<PeerEvaluationTemp> getPeerEvaluation(int studentId) {
		// TODO Auto-generated method stub
		
		peerEvaluationListTemp = new ArrayList<PeerEvaluationTemp>();
		peerEvaluationTemp = new PeerEvaluationTemp();
		student = studentDao.getStudentById(studentId);
		users = userDao.getUserByUserId(student.getUsers().getUserId());
		System.out.println(student.getClasses().getClassNumber());
		studentList = studentDao.getStudentByClassNumber(student.getClasses().getClassNumber());
		if(null != studentList)
		{
			for(Student studentItem : studentList)
			{
				excellentNumber = 0;
				goodNumber = 0;
				moderNumber = 0;
				commonNumber = 0;
				peerEvaluationList = peerEvaluationDao.getPeerEvaluationByObjectId(studentItem.getStudentId());
				
				if(null != peerEvaluationList)
				{
					for(PeerEvaluation peerEvaluationItem : peerEvaluationList)
					{
						if(peerEvaluationItem.getLevel().equals("500001"))
						{
							excellentNumber ++;
						}
						else if(peerEvaluationItem.getLevel().equals("500002"))
						{
							goodNumber ++;
						}
						else if(peerEvaluationItem.getLevel().equals("500003"))
						{
							moderNumber ++;
						}
						else if(peerEvaluationItem.getLevel().equals("500004"))
						{
							commonNumber ++;
						}
					}
					peerEvaluationTemp = new PeerEvaluationTemp();
					peerEvaluationTemp.setStudentId(studentItem.getStudentId());
					peerEvaluationTemp.setStudentName(studentItem.getStudentName());
					peerEvaluationTemp.setStudentNumber(studentItem.getUsers().getUserName());
					peerEvaluationTemp.setExcellent(excellentNumber);
					peerEvaluationTemp.setGood(goodNumber);
					peerEvaluationTemp.setModer(moderNumber);
					peerEvaluationTemp.setCommon(commonNumber);
					peerEvaluationTemp.setResultScore((excellentNumber * 40 + goodNumber * 35 + moderNumber * 30 + commonNumber * 25) / studentList.size());
					peerEvaluationListTemp.add(peerEvaluationTemp);
				}
			}
		}
		
//		if(null == peerEvaluationListTemp || 0 == peerEvaluationListTemp.size())
//			peerEvaluationListTemp = null;
		
		return peerEvaluationListTemp;
	}

	@Override
	public boolean addPeerEvaluation(String[] stringExc, String[] stringGood,
			String[] stringMod, String[] stringCom, int studentId) {
		// TODO Auto-generated method stub
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		PeerEvaluation peerEvalution = new PeerEvaluation();
		Student studentObject;
		
		if(null != stringExc && 0 != stringExc.length)
		{
			for(String item : stringExc)
			{
				date = new Date();
				users = userDao.getUserByUserName(item);
				//如果不存在该用户
				if(null == users)
				{
					System.out.println(item + "优不存在该用户");
					continue;
				}
				studentObject = studentDao.getStudentByUserId(users.getUserId());
				student = studentDao.getStudentById(studentId);
				//如果不存在该学生
				if(null == student || null == studentObject)
				{
					System.out.println(item + "优不存在该学生");
					continue;
				}
				peerEvalution = new PeerEvaluation();
				peerEvalution.setStudentByStudentId(student);
				peerEvalution.setStudentByObjectId(studentObject);
				peerEvalution.setLevel("500001");
				peerEvalution.setIsCurrent(true);
				peerEvalution.setTime(sdf.format(date));
				peerEvaluationDao.add(peerEvalution);
			}
		}
		if(null != stringGood && 0 != stringGood.length)
		{
			for(String item : stringGood)
			{
				date = new Date();
				users = userDao.getUserByUserName(item);
				//如果不存在该用户
				if(null == users)
				{
					System.out.println(item + "良不存在该用户");
					continue;
				}
				studentObject = studentDao.getStudentByUserId(users.getUserId());
				student = studentDao.getStudentById(studentId);
				//如果不存在该学生
				if(null == student || null == studentObject)
				{
					System.out.println(item + "良不存在该学生");
					continue;
				}
				peerEvalution = new PeerEvaluation();
				peerEvalution.setStudentByStudentId(student);
				peerEvalution.setStudentByObjectId(studentObject);
				peerEvalution.setLevel("500002");
				peerEvalution.setIsCurrent(true);
				peerEvalution.setTime(sdf.format(date));
				peerEvaluationDao.add(peerEvalution);
			}
		}
		if(null != stringMod && 0 != stringMod.length)
		{
			for(String item : stringMod)
			{
				date = new Date();
				users = userDao.getUserByUserName(item);
				//如果不存在该用户
				if(null == users)
				{
					System.out.println(item + "中不存在该用户");
					continue;
				}
				studentObject = studentDao.getStudentByUserId(users.getUserId());
				student = studentDao.getStudentById(studentId);
				//如果不存在该学生
				if(null == student || null == studentObject)
				{
					System.out.println(item + "中不存在该学生");
					continue;
				}
				peerEvalution = new PeerEvaluation();
				peerEvalution.setStudentByStudentId(student);
				peerEvalution.setStudentByObjectId(studentObject);
				peerEvalution.setLevel("500003");
				peerEvalution.setIsCurrent(true);
				peerEvalution.setTime(sdf.format(date));
				peerEvaluationDao.add(peerEvalution);
			}
		}
		if(null != stringCom && 0 != stringCom.length)
		{
			for(String item : stringCom)
			{
				date = new Date();
				users = userDao.getUserByUserName(item);
				//如果不存在该用户
				if(null == users)
				{
					System.out.println(item + "一般不存在该用户");
					continue;
				}
				studentObject = studentDao.getStudentByUserId(users.getUserId());
				student = studentDao.getStudentById(studentId);
				//如果不存在该学生
				if(null == student || null == studentObject)
				{
					System.out.println(item + "一般不存在该学生");
					continue;
				}
				peerEvalution = new PeerEvaluation();
				peerEvalution.setStudentByStudentId(student);
				peerEvalution.setStudentByObjectId(studentObject);
				peerEvalution.setLevel("500004");
				peerEvalution.setIsCurrent(true);
				peerEvalution.setTime(sdf.format(date));
				peerEvaluationDao.add(peerEvalution);
			}
		}
		
		return true;
	}

	@Override
	public List<PeerEvaluationTemp> getPeerEvaluationByClassNumber(
			String classNumber) {
		int excellentNumber;
		int goodNumber;
		int moderNumber;
		int commonNumber;
		
		PeerEvaluationTemp peerEvaluationTemp;
		
		List<Student> studentList = studentDao.getStudentByClassNumber(classNumber);
        List<PeerEvaluation> peerEvaluationList;
		List<PeerEvaluationTemp> peerEvaluationListTemp = new ArrayList<PeerEvaluationTemp>();
		
		if(null != studentList)
		{
			for(Student studentItem : studentList)
			{
				excellentNumber = 0;
				goodNumber = 0;
				moderNumber = 0;
				commonNumber = 0;
				peerEvaluationList = peerEvaluationDao.getPeerEvaluationByObjectId(studentItem.getStudentId());
				
				if(null != peerEvaluationList)
				{
					for(PeerEvaluation peerEvaluationItem : peerEvaluationList)
					{
						if(peerEvaluationItem.getLevel().equals("500001"))
						{
							excellentNumber ++;
						}
						else if(peerEvaluationItem.getLevel().equals("500002"))
						{
							goodNumber ++;
						}
						else if(peerEvaluationItem.getLevel().equals("500003"))
						{
							moderNumber ++;
						}
						else if(peerEvaluationItem.getLevel().equals("500004"))
						{
							commonNumber ++;
						}
					}
					peerEvaluationTemp = new PeerEvaluationTemp();
					
					peerEvaluationTemp.setStudentId(studentItem.getStudentId());
					peerEvaluationTemp.setStudentName(studentItem.getStudentName());
					peerEvaluationTemp.setStudentNumber(studentItem.getUsers().getUserName());
					peerEvaluationTemp.setExcellent(excellentNumber);
					peerEvaluationTemp.setGood(goodNumber);
					peerEvaluationTemp.setModer(moderNumber);
					peerEvaluationTemp.setCommon(commonNumber);
					peerEvaluationTemp.setResultScore((excellentNumber * 40 + goodNumber * 35 + moderNumber * 30 + commonNumber * 25) / studentList.size());
					
					peerEvaluationListTemp.add(peerEvaluationTemp);
				}
			}
		}
		
		return peerEvaluationListTemp;
	}

}
