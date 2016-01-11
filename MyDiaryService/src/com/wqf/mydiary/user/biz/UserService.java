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
}
