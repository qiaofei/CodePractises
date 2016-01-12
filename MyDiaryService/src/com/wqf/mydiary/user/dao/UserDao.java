package com.wqf.mydiary.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wqf.mydiary.user.entity.UserInfo;

public class UserDao extends HibernateDaoSupport{

	public List<UserInfo> getAllUsers(String sSql) {
		Session session = this.getSession();
		List<UserInfo> list = new ArrayList<UserInfo>();
		try {
			Query query = session.createQuery(sSql);
			list = query.list();
		} catch (Exception e) {
			
		}
		return list;
	}
	public List<UserInfo> getUserSql(String sSql){
		Session session = this.getSession();
		List<UserInfo> list = new ArrayList<UserInfo>();
		try{
			Query query = session.createQuery(sSql);
			list = query.list();
		}catch(Exception e){
		}
		return list;
	}
}
