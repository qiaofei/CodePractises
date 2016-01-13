package com.wqf.mydiary.diary.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wqf.mydiary.diary.entity.*;

public class DiaryInfoDao extends HibernateDaoSupport {
	public List<DiaryInfo> getDiaryInfoById(String sSql) {
		// 先获取Session
		Session session = this.getSession();
		// new一list实例
		List<DiaryInfo> diaryList = new ArrayList<DiaryInfo>();
		// 创建query语句
		try{
			Query qurey = session.createQuery(sSql);
			diaryList = qurey.list();
		}catch(Exception e){
			
		}
		// list实例接受查询返回值
		
		return diaryList;
	}
}
