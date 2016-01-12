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
		String sSql = "from UserInfo where " + "username = '" + username + "' "
				+ "and password = '" + password + "'";
		List<UserInfo> userList = userDao.getUserSql(sSql);
		if (userList == null || userList.size() <= 0) {
			return null;
		} else {
			return userList.get(0);
		}
	}

	/**
	 * 添加新用户
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public String insertNewUser(String username, String password) {
		try {
			// 先判断用户名是否已存在
			String querySql = "from UserInfo where username = '" + username
					+ "'";
			List<UserInfo> list = userDao.getUserSql(querySql);
			if (list != null && list.size() > 0) {
				throw new Exception("手机号已存在");
			}
			/* 插入新用户信息 */
			String insertSql = "insert into user_info "
					+ "(username,password) " + "values ('" + username + "','"
					+ password + "')";
			boolean insertOk = userDao.exeSql(insertSql);
			if (!insertOk) {
				throw new Exception("插入信息失败，检查输入信息！");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "success";
	}
}
