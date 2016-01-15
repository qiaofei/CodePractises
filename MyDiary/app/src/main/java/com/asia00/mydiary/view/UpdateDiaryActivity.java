package com.asia00.mydiary.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.asia00.mydiary.R;
import com.asia00.mydiary.util.CommonUrl;
import com.asia00.mydiary.util.DateTimeUtil;
import com.asia00.mydiary.util.ServiceUtil;

import java.util.HashMap;

public class UpdateDiaryActivity extends BaseActivity {
    private EditText etTitle;
    private EditText etContent;
    private Button btnSave;
    private Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_diary);
        etTitle = (EditText) findViewById(R.id.etTitle);
        etContent = (EditText) findViewById(R.id.etContent);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDiary();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteDiary();
            }
        });
    }


    /**
     * 保存新日志
     */
    public void updateDiary() {
        //拿到该日志的id
        Intent intent = this.getIntent();
        String diaryId = intent.getStringExtra("diaryId");
        //更新日志
        HashMap hashMap = new HashMap();
        String sTitle = etTitle.getText().toString();
        String sContent = etContent.getText().toString();
        //拿到当前时间
        String sCurrTime = DateTimeUtil.getCurrTime();
        if (sTitle.length() < 1) {
            Toast.makeText(this, "标题不能为空！", Toast.LENGTH_SHORT).show();
            return;
        }
        hashMap.put("title", sTitle);
        hashMap.put("content", sContent);
        hashMap.put("currTime", sCurrTime);
        hashMap.put("id", diaryId);
        ServiceUtil.volleyPost(new ServiceUtil.VolleyCallback() {
            @Override
            public void onSuccess(Object result, int status) {
                Toast.makeText(getApplicationContext(), (String) result, Toast.LENGTH_LONG).show();
            }
        }, this, hashMap, CommonUrl.UPDATEDIARYURL, String.class);
    }

    /**
     * 删除日志
     */
    public void deleteDiary() {
        //获取到diaryId
        Intent intent = this.getIntent();
        String diaryId = intent.getStringExtra("diaryId");
        HashMap hashMap = new HashMap();
        hashMap.put("id", diaryId);
        //根据diaryId删除日志
        ServiceUtil.volleyPost(new ServiceUtil.VolleyCallback() {
            @Override
            public void onSuccess(Object result, int status) {
                Toast.makeText(getApplicationContext(), (String) result, Toast.LENGTH_LONG).show();
            }
        }, this, hashMap, CommonUrl.DELETEDIARYURL, String.class);
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }
}
