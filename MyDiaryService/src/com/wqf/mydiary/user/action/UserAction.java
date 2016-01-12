package com.wqf.mydiary.user.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.wqf.mydiary.user.biz.UserService;
import com.wqf.mydiary.user.entity.UserInfo;
import com.wqf.mydiary.util.TransMsg;
import com.wqf.mydiary.util.TransMsgUtil;

public class UserAction extends ActionSupport {
	private UserService userService;
	private List<UserInfo> userList;
	private TransMsg transMsg;
	private String username;
	private String password;

	public TransMsg getTransMsg() {
		return transMsg;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setTransMsg(TransMsg transMsg) {
		this.transMsg = transMsg;
	}

	public List<UserInfo> getUserList() {
		return userList;
	}

	public void setUserList(List<UserInfo> userList) {
		this.userList = userList;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 获取所有用户信息
	 * 
	 * @return
	 */
	public String getAllUserInfo() {
		userList = userService.getAllUserList();
		// 将list放入transMsg中
		if (userList != null) {
			transMsg = TransMsgUtil.setTransMsg(1, "List", userList);
		}
		return "success";
	}

	/**
	 * 用户登陆
	 * 
	 * @return
	 */
	public String checkLogin() {
		UserInfo userInfo = userService.checkLogin(username, password);
		if (userInfo != null) {
			transMsg = TransMsgUtil.setTransMsg(1, userInfo.getId() + "");
		}
		return "success";
	}
}
