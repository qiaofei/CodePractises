package util;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

public class JsonUtil {
	
	/**
	 * 将list转换成json字符�?
	 * @param list
	 * @return
	 */
	public static String transListToJson(List list){
		JSONArray jsonArray = null;
		try{		
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
			jsonArray = JSONArray.fromObject(list,jsonConfig);
		}catch(Exception e){
		}
		return jsonArray.toString();
	}
	
	/**
	 * 将对象转换称json字符�?
	 * @param object
	 * @return
	 */
	public static String transObjectToJson(Object object){
		JSONObject json = null;
		try{
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
			json = JSONObject.fromObject(object,jsonConfig); 
		}catch(Exception e){
		}
		return json.toString();
	}
	
	/**
	 * json字符串转换成对象
	 * @param jsonStr
	 * @param cls
	 * @return
	 */
	/*public static Object transJsonToObject(String jsonStr,Class cls){
		Gson gson = new Gson();  
		Object obj = gson.fromJson(jsonStr, cls);
		return obj;
	}*/
}
