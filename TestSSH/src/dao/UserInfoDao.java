package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entity.UserInfo;

public class UserInfoDao {
	public List<UserInfo> getUserInfoBySql(String sSql) {
//		 Session session = this.getSession();
		List<UserInfo> list = new ArrayList<UserInfo>();
		try {
			// Query query = session.createQuery(sSql);
			// list = query.list();
		} catch (Exception e) {
		}
		return list;
	}
}
