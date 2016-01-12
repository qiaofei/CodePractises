package com.wqf.mydiary.user.biz;

import java.util.List;

import com.wqf.mydiary.user.dao.UserDao;
import com.wqf.mydiary.user.entity.UserInfo;

public class UserService {
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public List<UserInfo> getAllUserList() {
		String sSql = "from UserInfo";
		List<UserInfo> userList = userDao.getAllUsers(sSql);
		return userList;
	}

	/**
	 * 用户登陆
	 */
	public UserInfo checkLogin(String username, String password) {
		/*
		 * String sSql = "from UserInfo where "+"username = '" + username + "' "
		 * + "and password = '" + password + "'";
		 */
		String sSql = "from UserInfo where " + "username = '" + username
				+ "' " + "and password = '" + password + "'";
		List<UserInfo> userList = userDao.getUserSql(sSql);
		if (userList == null || userList.size() <= 0) {
			return null;
		} else {
			return userList.get(0);
		}
	}
}
