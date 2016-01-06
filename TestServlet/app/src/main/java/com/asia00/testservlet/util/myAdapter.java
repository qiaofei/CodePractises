package com.asia00.testservlet.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.asia00.testservlet.R;
import com.asia00.testservlet.bean.UserInfoNew;

import java.util.List;

/**
 * Created by QiaoFei on 2016/1/6.
 */
public class MyAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private List<UserInfoNew> data;

    public MyAdapter(Context context, List<UserInfoNew> data, int layoutId) {
//        super(context,data,layoutId);
        //this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.data = data;
        //this.layoutId = layoutId;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tv_name = (TextView) convertView.findViewById(R.id.tvName);
            viewHolder.tv_phone = (TextView) convertView.findViewById(R.id.tvTel);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        UserInfoNew userInfoNew = data.get(position);
        viewHolder.tv_name.setText(userInfoNew.getUserName());
        viewHolder.tv_phone.setText(userInfoNew.getUserTel());
        return convertView;
    }

    private class ViewHolder {
        TextView tv_name;
        TextView tv_phone;
    }
}
