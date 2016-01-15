package com.asia00.mydiary.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.asia00.mydiary.R;
import com.asia00.mydiary.entity.DiaryInfo;
import com.asia00.mydiary.util.CommonUrl;
import com.asia00.mydiary.util.ServiceUtil;
import com.joanzapata.android.BaseAdapterHelper;
import com.joanzapata.android.QuickAdapter;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private ListView listView;
    private QuickAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listView = (ListView) findViewById(R.id.lvMyDiary);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DiaryActivity.class));
            }
        });
        initSharedPreference();
        showDiaryList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * 获取日志列表
     */
    public void showDiaryList() {
        int userId = mSharedPreferences.getInt("userid", 0);
        ServiceUtil.getResponse(new ServiceUtil.VolleyCallback() {
            @Override
            public void onSuccess(Object result, int status) {
                listView.setAdapter(mAdapter = new QuickAdapter<DiaryInfo>(
                        getApplicationContext(), R.layout.item_listview_diary_list,
                        (ArrayList<DiaryInfo>) result) {
                    @Override
                    protected void convert(BaseAdapterHelper helper, final DiaryInfo item) {
                        helper.setText(R.id.tvDiaryTitle, item.getTitle());
                        helper.setText(R.id.tvDiaryContent, item.getContent());
                        helper.setText(R.id.tvDiaryTime, item.getTime());
                        helper.getView().setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(MainActivity.this, UpdateDiaryActivity.class);
                                intent.putExtra("diaryId", ""+item.getId());
                                startActivity(intent);
                            }
                        });
                    }
                });
            }
        }, this, CommonUrl.GETDIARYBYUSERIDURL + "?userId=" + userId, DiaryInfo.class);
    }
}
