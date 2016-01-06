package util;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

public class JsonTrans {

	// list转为json对象
	public static String transListToJson(List list) {
		JSONArray jsonArray = null;
		try {
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig
					.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
			jsonArray = JSONArray.fromObject(list, jsonConfig);
		} catch (Exception e) {
		}
		return jsonArray.toString();
	}

	// 对象转为json对象
	public static String transObjectToJson(Object object) {
		JSONObject json = null;
		try {
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig
					.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
			json = JSONObject.fromObject(object, jsonConfig);
		} catch (Exception e) {
		}
		return json.toString();
	}
}
