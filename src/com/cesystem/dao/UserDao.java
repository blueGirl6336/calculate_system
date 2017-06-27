package com.cesystem.dao;

import com.cesystem.pojo.Users;

public interface UserDao extends BaseDao {
	
	/**
	 * 登录
	 * @param userName
	 * @param password
	 * @return
	 */
	public Users login(String userName,String password);
	/**
	 * 注册
	 * @param userName
	 * @param password
	 * @return
	 */
	public boolean regist(String userName,String password);
	/**
	 * 通过用户名获取用户
	 * @param userName
	 * @return
	 */
	public Users getUserByUserName(String userName);
	
	public Users getUserByUserId(int userId);

}
