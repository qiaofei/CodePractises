package com.asia00.testrunable.presenter;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.asia00.testrunable.model.GetTextData;
import com.asia00.testrunable.view.IMainActivity;


/**
 * Created by QiaoFei on 2015/12/8.
 */
public class MainActivityPresenter implements IMainActivity {
    GetTextData getTextData = new GetTextData();
    private String textData;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    setTextString((TextView) msg.obj);
                    break;
            }
        }
    };

    public void getText(TextView textView) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                textData = getTextData.getData();
            }
        });
        Message msg = new Message();
        msg.what = 0;
        msg.obj = textView;
        handler.sendMessage(msg);
    }

    public void setTextString(TextView textView) {
        textView.setText(textData);
    }
}
