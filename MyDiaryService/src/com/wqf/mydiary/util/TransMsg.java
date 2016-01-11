package com.wqf.mydiary.util;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

public class TransMsg {
	private int status;
	private String transName;
	private Object transData;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getTransName() {
		return transName;
	}

	public void setTransName(String transName) {
		this.transName = transName;
	}

	public Object getTransData() {
		return transData;
	}

	public void setTransData(Object transData) {
		this.transData = transData;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		JSONObject json = null;
		try {
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig
					.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
			json = JSONObject.fromObject(this, jsonConfig);
		} catch (Exception e) {
		}
		return json.toString();
	}
}