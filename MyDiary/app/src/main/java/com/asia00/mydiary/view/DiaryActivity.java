package com.asia00.mydiary.view;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.asia00.mydiary.R;
import com.asia00.mydiary.entity.DiaryInfo;
import com.asia00.mydiary.util.DateTimeUtil;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.OnClick;

public class DiaryActivity extends BaseActivity {
    @Bind(R.id.etTitle)
    EditText etTitle;
    @Bind(R.id.etContent)
    EditText etContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);
        initSharedPreference();
    }

    @OnClick({R.id.btnSave, R.id.btnCancle})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSave:
                break;
            case R.id.btnCancle:
                break;
        }
    }

    /**
     * 添加新日志
     */
    public void saveDiary() {
        HashMap hashMap = new HashMap();
        String sTitle = etTitle.getText().toString();
        String sContent = etContent.getText().toString();
        //拿到用户id
        int userId = mSharedPreferences.getInt("userid", 0);
        //拿到当前时间
        String sCurrTime = DateTimeUtil.getCurrTime();
        if (sTitle.length() < 1) {
            Toast.makeText(this, "标题不能为空！", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            DiaryInfo localDiary = new DiaryInfo(sTitle, sContent, userId, sCurrTime);
            hashMap.put("localDiary", localDiary);
            //将localDiary上传至服务器
        } catch (Exception e) {

        }
    }
}
