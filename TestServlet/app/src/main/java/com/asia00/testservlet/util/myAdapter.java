package com.asia00.testservlet.util;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;

import com.asia00.testservlet.bean.UserInfoNew;

import java.util.List;

/**
 * Created by QiaoFei on 2016/1/6.
 */
public class myAdapter extends ArrayAdapter<UserInfoNew> {

    public myAdapter(Context context, int resource, int textViewResourceId, List<UserInfoNew> objects) {
        super(context, resource, textViewResourceId, objects);
    }
    public View getView(){

    }
}
