package com.asia00.mydiary.view;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.asia00.mydiary.R;

import butterknife.Bind;
import butterknife.OnClick;

public class UpdateDiaryActivity extends BaseActivity {
    @Bind(R.id.etTitle)
    private EditText etTitle;
    @Bind(R.id.etContent)
    private EditText etContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_diary);
    }

    @OnClick({R.id.btnSave, R.id.btnCancle, R.id.btnDelete})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSave:
                updateDiary();
                break;
            case R.id.btnCancle:
                break;
            case R.id.btnDelete:
                deleteDiary();
                break;
        }
    }

    /**
     * 保存新日志
     */
    public void updateDiary() {

        //拿到该日志的id
    }

    /**
     * 删除日志
     */
    public void deleteDiary() {

    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }
}
