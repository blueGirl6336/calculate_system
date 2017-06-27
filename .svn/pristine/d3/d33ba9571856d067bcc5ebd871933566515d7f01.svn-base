package com.cesystem.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cesystem.dao.UserDao;
import com.cesystem.pojo.Users;

@Repository
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	@Override
	public Users login(String userName, String password) {
		// TODO Auto-generated method stub
		List<Users> userList = null;
		String hql = "from Users as u where u.userName=? and u.password=?";
		String[] param = new String[]{userName,password};
		userList = this.getHibernateTemplate().find(hql, param);
		if(userList.size()==0) {
			return null;
		} else {
			return userList.get(0);
		}
	}

	@Override
	public boolean regist(String userName, String password) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public Users getUserByUserName(String userName) {
		// TODO Auto-generated method stub\
		List<Users> userList = null;
		String hql = "from Users as u where u.userName=?";
		userList = this.getHibernateTemplate().find(hql, userName);
		if(userList.size()==0) {
			return null;
		} else {
			return userList.get(0);
		}
	}

	@Override
	public Users getUserByUserId(int userId) {
		// TODO Auto-generated method stub
		List<Users> userList = null;
		String hql = "from Users as u where u.userId=?";
		userList = this.getHibernateTemplate().find(hql, userId);
		if(userList.size()==0) {
			return null;
		} else {
			return userList.get(0);
		}
	}

}
