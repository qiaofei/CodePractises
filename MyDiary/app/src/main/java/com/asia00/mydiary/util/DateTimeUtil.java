package com.asia00.mydiary.util;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Created by QiaoFei on 2016/1/14.
 */
public class DateTimeUtil {
    public static String getCurrTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日    HH:mm:ss     ");
        Date curTime = new Date(System.currentTimeMillis());//获取当前时间
        String sCurTime = formatter.format(curTime);
        return sCurTime;
    }
}
