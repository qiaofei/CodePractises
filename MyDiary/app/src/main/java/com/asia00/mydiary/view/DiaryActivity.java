package com.asia00.mydiary.view;

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

public class DiaryActivity extends BaseActivity {
    //    @Bind(R.id.etTitle)
    private EditText etTitle;
    //    @Bind(R.id.etContent)
    private EditText etContent;
    private Button btnSave;
//    private Button btnCancle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);
        initSharedPreference();
        etTitle = (EditText) findViewById(R.id.etTitle);
        etContent = (EditText) findViewById(R.id.etContent);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDiary();
            }
        });
    }

   /* @OnClick({R.id.btnSave, R.id.btnCancle})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSave:
                break;
            case R.id.btnCancle:
                break;
        }
    }*/

    /**
     * 添加新日志
     */
    public void saveDiary() {
        HashMap hashMap = new HashMap();
        String sTitle = etTitle.getText().toString();
        String sContent = etContent.getText().toString();
        //拿到用户id
        String userId = "" + mSharedPreferences.getInt("userid", 0);
        //拿到当前时间
        String sCurrTime = DateTimeUtil.getCurrTime();
        if (sTitle.length() < 1) {
            Toast.makeText(this, "标题不能为空！", Toast.LENGTH_SHORT).show();
            return;
        }
        hashMap.put("title", sTitle);
        hashMap.put("content", sContent);
        hashMap.put("userId", userId);
        hashMap.put("currTime", sCurrTime);
        //将localDiary上传至服务器
        ServiceUtil.volleyPost(new ServiceUtil.VolleyCallback() {
            @Override
            public void onSuccess(Object result, int status) {
                Toast.makeText(getApplicationContext(), (String) result, Toast.LENGTH_LONG).show();
            }
        }, this, hashMap, CommonUrl.SAVEDIARYURL, String.class);
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }
}
