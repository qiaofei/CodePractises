package com.asia00.mydiary.view;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

import java.util.LinkedList;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2015/9/19.
 */
public class BaseActivity extends AppCompatActivity {
    public static LinkedList<Activity> sAllActivitys = new LinkedList<Activity>();
    public SharedPreferences mSharedPreferences;
    public SharedPreferences.Editor mEditor;
    private long exitTime = 0;

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

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 初始化SharedPreference
     */
    public void initSharedPreference() {
        mSharedPreferences =
                getSharedPreferences("MyDiaryPreference", MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
    }

    public void onBackPressed() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            for (Activity activity : sAllActivitys) {
                activity.finish();
            }

            sAllActivitys.clear();
            System.exit(0);
        }
    }
}
