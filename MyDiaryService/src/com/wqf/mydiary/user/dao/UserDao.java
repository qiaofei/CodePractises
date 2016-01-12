package com.wqf.mydiary.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wqf.mydiary.user.entity.UserInfo;

public class UserDao extends HibernateDaoSupport{
	/**
	 * 根据sql执行增删改
	 * @param sSql
	 * @return
	 */
	public boolean exeSql(String sSql){
		Session session = this.getSession();
		boolean isOk = false;
		try{
			SQLQuery query = session.createSQLQuery(sSql);
			query.executeUpdate();
			isOk = true;
		}catch(Exception e){
//			LogUtil.logError("driverError", e.toString());
		}
		return isOk;
	}
	/**
	 * 获取所有用户
	 * @param sSql
	 * @return
	 */
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
	/**
	 * 根据sql获取用户信息
	 * @param sSql
	 * @return
	 */
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
