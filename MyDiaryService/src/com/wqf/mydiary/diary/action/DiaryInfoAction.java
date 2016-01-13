package com.wqf.mydiary.diary.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.wqf.mydiary.diary.biz.DiaryInfoService;
import com.wqf.mydiary.diary.entity.DiaryInfo;
import com.wqf.mydiary.util.TransMsg;
import com.wqf.mydiary.util.TransMsgUtil;

public class DiaryInfoAction extends ActionSupport {
	private String userId;
	private DiaryInfoService diaryInfoService;
	private List<DiaryInfo> diaryList;
	private TransMsg transMsg;

	public String getUserId() {
		return userId;
	}

	public List<DiaryInfo> getDiaryList() {
		return diaryList;
	}

	public void setDiaryList(List<DiaryInfo> diaryList) {
		this.diaryList = diaryList;
	}

	public TransMsg getTransMsg() {
		return transMsg;
	}

	public void setTransMsg(TransMsg transMsg) {
		this.transMsg = transMsg;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public DiaryInfoService getDiaryInfoService() {
		return diaryInfoService;
	}

	public void setDiaryInfoService(DiaryInfoService diaryInfoService) {
		this.diaryInfoService = diaryInfoService;
	}

	/**
	 * 根据用户id读取用户的所有日志
	 * 
	 * @return
	 */
	public String getDiaryInfoById() {
		try {
			diaryList = diaryInfoService.getDiaryInfoById(userId);
			if (diaryList != null) {
				transMsg = TransMsgUtil.setTransMsg(1, "List", diaryList);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "success";
	}

}
