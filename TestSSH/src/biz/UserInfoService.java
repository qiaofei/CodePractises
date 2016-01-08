package biz;

import java.util.List;
import dao.UserInfoDao;
import entity.UserInfo;

public class UserInfoService {
	private UserInfoDao userInfoDao;

	public UserInfo checkLogin(String userName, String userPassword) {
		String sSql = "from DriverInfo where " + "contactTel = '" + userName
				+ "' " + "and password = '" + userPassword + "'";
		// LogUtil.logInfo(UserInfoService.class, sSql);
		List<UserInfo> list = userInfoDao.getUserInfoBySql(sSql);
		if (list == null || list.size() <= 0) {
			return null;
		} else {
			return list.get(0);
		}
	}
}
