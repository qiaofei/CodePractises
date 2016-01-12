package com.asia00.mydiary.view;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.Window;

import java.util.LinkedList;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2015/9/19.
 */
public class BaseActivity extends AppCompatActivity {
    public static LinkedList<Activity> sAllActivitys = new LinkedList<Activity>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 锁定竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) {
            // Activity was brought to front and not created,
            // Thus finishing this will get us to the last viewed activity
            finish();
            return;
        }
        if (getLayoutId() != 0) {
            setContentView(getLayoutId());
        }
        sAllActivitys.add(this);
        ButterKnife.bind(this);
        initData();
        initView();
    }
    /*protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) {
            // Activity was brought to front and not created,
            // Thus finishing this will get us to the last viewed activity
            finish();
            return;
        }

        init();
    }*/
    //初始化控件
    public void initView() {
    }

    public void initData() {
    }

    protected int getLayoutId() {
        return 0;
    }

    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }

  /*  public void closeAllActivity() {
        for (Activity activity : sAllActivitys) {
            activity.finish();
            sAllActivitys.remove(activity);
        }
    }*/

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
