package com.asia00.testservlet.util;

import android.util.Log;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by QiaoFei on 2016/1/6.
 */
public class JsonUtil {
    /**
     * 根据json字符串
     * 转换成list
     *
     * @param str
     * @return
     */
    public static List getListByStr(String str, Class clazz) {
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
    public static Object getEntityByStr(String str, Class clazz) {
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
