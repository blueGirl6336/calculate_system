package com.cesystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesystem.dao.ApartmentDao;
import com.cesystem.dao.ClassesDao;
import com.cesystem.dao.StudentDao;
import com.cesystem.dao.UserDao;
import com.cesystem.pojo.Apartment;
import com.cesystem.pojo.Classes;
import com.cesystem.pojo.Users;
import com.cesystem.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private ClassesDao classesDao;
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private ApartmentDao apartmentDao;

	@Override
	public Users login(String userName, String password) {
		// TODO Auto-generated method stub
		return userDao.login(userName, password);
	}
	
	
	
	@Override
	public int regist(String userName, String password, int classId,
			String studentName) {
		// TODO Auto-generated method stub
		try{
			if(userDao.getUserByUserName(userName)!=null)
				return 1;
			
//			Classes classes = classesDao.getClassesById(classId);
//			if(classes==null)
//				return 2;	
			
//			Users user = new Users(userName, "100001", password);
//			userDao.add(user);
			
//			Student student = new Student(apartment,user, classes, studentName, 0.0, 0, 0.0,
//					0.0);
//			studentDao.add(student);
			
		}catch(org.springframework.transaction.UnexpectedRollbackException e){
			return 3;
		}catch(org.springframework.dao.DataIntegrityViolationException c){
			return 3;
		}
		return 0;
	}

}
