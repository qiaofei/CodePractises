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
	private DiaryInfo diaryInfo;
	private String sCurrTime;
	private String sTitle;
	private String sContent;

	public DiaryInfo getDiaryInfo() {
		return diaryInfo;
	}

	public void setDiaryInfo(DiaryInfo diaryInfo) {
		this.diaryInfo = diaryInfo;
	}

	public String getsCurrTime() {
		return sCurrTime;
	}

	public void setsCurrTime(String sCurrTime) {
		this.sCurrTime = sCurrTime;
	}

	public String getsTitle() {
		return sTitle;
	}

	public void setsTitle(String sTitle) {
		this.sTitle = sTitle;
	}

	public String getsContent() {
		return sContent;
	}

	public void setsContent(String sContent) {
		this.sContent = sContent;
	}

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

	public String insertNewDiary() {
		String msg = "";
		try {
			msg = diaryInfoService.insertNewDiary(sTitle, sContent,
					"" + userId, sCurrTime);
		} catch (Exception e) {
			msg = e.getMessage();
		}
		transMsg = TransMsgUtil.setTransMsg(1, msg);
		return "success";
	}
}
