package com.wqf.mydiary.diary.entity;

/**
 * DiaryInfo entity. @author MyEclipse Persistence Tools
 */

public class DiaryInfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private String content;
	private Integer userid;
	private String time;

	// Constructors

	/** default constructor */
	public DiaryInfo() {
	}

	/** minimal constructor */
	public DiaryInfo(String title, Integer userid, String time) {
		this.title = title;
		this.userid = userid;
		this.time = time;
	}

	/** full constructor */
	public DiaryInfo(String title, String content, Integer userid, String time) {
		this.title = title;
		this.content = content;
		this.userid = userid;
		this.time = time;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}