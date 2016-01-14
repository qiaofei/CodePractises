package com.wqf.mydiary.diary.biz;

import java.util.List;

import com.wqf.mydiary.diary.dao.DiaryInfoDao;
import com.wqf.mydiary.diary.entity.*;

public class DiaryInfoService {
	private DiaryInfoDao diaryInfoDao;

	public DiaryInfoDao getDiaryInfoDao() {
		return diaryInfoDao;
	}

	public void setDiaryInfoDao(DiaryInfoDao diaryInfoDao) {
		this.diaryInfoDao = diaryInfoDao;
	}

	public List<DiaryInfo> getDiaryInfoById(String userId) {
		String querySql = "from DiaryInfo where " + "userid = '" + userId
				+ "' ";
		List<DiaryInfo> diaryList = diaryInfoDao.getDiaryInfoById(querySql);
		return diaryList;
	}

	public String insertNewDiary(String title, String content, String userId,
			String time) {
		try {
			/* 插入新用户信息 */
			/*String insertSql = "insert into diary_info "
					+ "(title,content,userid,time) " + "values ('" + sTitle
					+ "','" + sContent + "','" + userId + "')";*/
			String insertSql = "insert into diary_info "
					+ "(title,content,userid,time) " + "values ('" + title
					+ "','" + content + "','" + userId + "','" + time +"')";
			boolean insertOk = diaryInfoDao.exeSql(insertSql);
			if (!insertOk) {
				throw new Exception("插入信息失败，检查输入信息！");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "success";
	}
}
