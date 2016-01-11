package action;

import com.util.trans.TransMsg;

import entity.UserInfo;
import biz.UserInfoService;

public class UserInfoAction {
	private UserInfoService userInfoService;
	private TransMsg transMsg;
	// 拿到用户名和用户密码
	private String userName;
	private String userPassword;

	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public void getUserInfo() {
		UserInfo userInfo = userInfoService.checkLogin(userName, userPassword);
	}
}
