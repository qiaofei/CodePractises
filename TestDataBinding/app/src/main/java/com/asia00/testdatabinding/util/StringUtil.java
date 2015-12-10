package com.asia00.testdatabinding.util;

/**
 * Created by QiaoFei on 2015/12/8.
 */
public class StringUtil {
    public static String capitalize(final String word) {
        if (word.length() > 1) {
            return String.valueOf(word.charAt(0)).toUpperCase() + word.substring(1);
        }
        return word;
    }
}
