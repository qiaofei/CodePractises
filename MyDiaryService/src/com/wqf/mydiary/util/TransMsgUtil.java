package com.wqf.mydiary.util;

import java.io.Serializable;
import java.util.List;

/**
 * 传输信息工具�?
 * 
 * @author suboxu 2015-8-28
 */
public class TransMsgUtil {

	/**
	 * 给传输信息类赋�? 数据为List类型
	 * 
	 * @param status
	 * @param transName
	 * @param list
	 * @return
	 */
	public static TransMsg setTransMsg(int status, String transName, List list) {
		TransMsg transMsg = new TransMsg();
		transMsg.setStatus(status);
		transMsg.setTransName("List");
		transMsg.setTransData(list);
		return transMsg;
	}

	/**
	 * 给传输信息类赋�? 数据为实体类
	 * 
	 * @param status
	 * @param transName
	 * @param seri
	 * @return
	 */
	public static TransMsg setTransMsg(int status, String transName,
			Serializable seri) {
		TransMsg transMsg = new TransMsg();
		transMsg.setStatus(status);
		transMsg.setTransName("Entity");
		transMsg.setTransData(seri);
		return transMsg;
	}

	/**
	 * 给传输信息类赋�? 数据为字符串
	 * 
	 * @param status
	 * @param transName
	 * @param str
	 * @return
	 */
	public static TransMsg setTransMsg(int status, String str) {
		TransMsg transMsg = new TransMsg();
		transMsg.setStatus(status);
		transMsg.setTransName("String");
		transMsg.setTransData(str);
		return transMsg;
	}
}
