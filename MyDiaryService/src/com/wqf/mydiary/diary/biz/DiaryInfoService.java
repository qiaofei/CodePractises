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
		String querySql = "from DiaryInfo where " + "userid = '"
					+ userId + "' ";
		List<DiaryInfo> diaryList = diaryInfoDao.getDiaryInfoById(querySql);
		return diaryList;
	}
}
