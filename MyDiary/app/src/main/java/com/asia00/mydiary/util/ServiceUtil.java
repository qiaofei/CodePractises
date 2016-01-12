package com.asia00.mydiary.util;


import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by suboxu on 2015/8/31 0031.
 */
public class ServiceUtil {
    private static RequestQueue mQueue;
    private static StringRequest stringRequest;
    private static JSONObject jsonObject;
    private static Object obj = null;

    public interface VolleyCallback {
        void onSuccess(Object result, int status);
    }

    /**
     * 获取相应远程信息
     *
     * @param
     * @param url
     * @return
     */
    public static void getResponse(final VolleyCallback callback, Context context, String url, final Class clazz) {
        mQueue = Volley.newRequestQueue(context);
        try {
            stringRequest = new StringRequest(CommonUrl.BASESERVICEURL + url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.d("TAG", response);
                            try {
                                jsonObject = new JSONObject(response);
                                int status = jsonObject.getInt("status");
                                String transName = jsonObject.getString("transName");
                                String transData = jsonObject.getString("transData");
                                if ("String".equals(transName)) {
                                    obj = transData;
                                } else if ("List".equals(transName)) {
                                    obj = getListByStr(transData, clazz);
                                } else if ("Entity".equals(transName)) {
                                    obj = getEntityByStr(transData, clazz);
                                }
                                callback.onSuccess(obj, status);
                            } catch (JSONException e) {
//                                e.printStackTrace();
                                Log.e("TAG", e.getMessage(), e);
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("TAG", error.getMessage(), error);
                }
            });
            mQueue.add(stringRequest);

        } catch (Exception e) {
//            e.printStackTrace();
            Log.e("TAG", e.getMessage(), e);
        }
    }

    public static void volleyPost(final VolleyCallback callback, Context context, HashMap<String, String> hashMap, String url, final Class clazz) {
        final HashMap<String, String> mHashMap = hashMap;
//        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, CommonUrl.BASESERVICEURL + url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Request", "response -> " + response);
                        try {
                            jsonObject = new JSONObject(response);
                            int status = jsonObject.getInt("status");
                            String transName = jsonObject.getString("transName");
                            String transData = jsonObject.getString("transData");
                            if ("String".equals(transName)) {
                                obj = transData;
                            } else if ("List".equals(transName)) {
                                obj = getListByStr(transData, clazz);
                            } else if ("Entity".equals(transName)) {
                                obj = getEntityByStr(transData, clazz);
                            }
                            callback.onSuccess(obj, status);
                        } catch (JSONException e) {
//                            e.printStackTrace();
                            Log.e("TAG", e.getMessage(), e);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Request", "error -> " + error);
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                //在这里设置需要post的参数
                return mHashMap;
            }
        };
        RequestQueueSingleTon.getInstance(context).addToRequestQueue(stringRequest);
//        requestQueue.add(stringRequest);
    }

    /**
     * 根据json字符串
     * 转换成list
     *
     * @param str
     * @return
     */
    private static List getListByStr(String str, Class clazz) {
        Type objectType = type(List.class, clazz);
        List list = new ArrayList();
        if (!"".equals(str)) {
            try {
                Gson mgson = new Gson();
                list = mgson.fromJson(
                        str, objectType);
            } catch (Exception e) {
//                e.printStackTrace();
                Log.e("TAG", e.getMessage(), e);
            }
        }
        return list;
    }

    /**
     * 根据json字符串
     * 转换成实体类
     *
     * @param str
     * @return
     */
    private static Object getEntityByStr(String str, Class clazz) {
        Object obj = null;
        if (!"".equals(str)) {
            try {
                Gson mgson = new Gson();
                obj = mgson.fromJson(str, clazz);
            } catch (Exception e) {
//                e.printStackTrace();
                Log.e("TAG", e.getMessage(), e);
            }
        }
        return obj;
    }

    private static ParameterizedType type(final Class raw, final Type... args) {
        return new ParameterizedType() {
            public Type getRawType() {
                return raw;
            }

            public Type[] getActualTypeArguments() {
                return args;
            }

            public Type getOwnerType() {
                return null;
            }
        };
    }

}
