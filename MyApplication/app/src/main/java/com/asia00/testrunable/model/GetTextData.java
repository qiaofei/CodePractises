package com.asia00.testrunable.model;

import java.util.Random;

/**
 * Created by QiaoFei on 2015/12/8.
 */
public class GetTextData {
    public String getData() {
        Random random = new Random();
        int randomInt = random.nextInt();
        return "" + randomInt;
    }
}
