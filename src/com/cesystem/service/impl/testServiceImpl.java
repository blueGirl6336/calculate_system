package com.cesystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesystem.dao.BaseDao;
import com.cesystem.pojo.Users;
import com.cesystem.service.testService;
@Service
public class testServiceImpl implements testService {
	@Autowired
	private BaseDao baseDao;
	
	public boolean testAdd(){
		
		Users users = new Users();
		users.setPassword("ssss");
		users.setUserName("aaa111");
//		String hql = "from Users";
//		System.out.println(baseDao.count(hql));
		Users userr =baseDao.getOneById(1, users);
		baseDao.add(users);
		System.out.println(userr.getUserName());
		return true;
		
	}

}
