package com.asia00.testmessengerclient;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    protected static final String TAG = "MainActivity";
    //定义两个Messenger
    Messenger messenger;
    Messenger reply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reply = new Messenger(handler);
        Intent intent = new Intent();
        intent.setClassName("test.messenger", "test.messenger.MessengerTestService");
        bindService(intent, new ServiceConnection() {

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }

            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Toast.makeText(MainActivity.this, "bind success", Toast.LENGTH_SHORT).show();
                messenger = new Messenger(service);
            }
        }, Context.BIND_AUTO_CREATE);
    }

    public void sendMessage(View v) {
        Message msg = Message.obtain(null, 1);
        // 设置回调用的Messenger
        msg.replyTo = reply;
        try {
            messenger.send(msg);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            Log.d(TAG, "回调成功");
        }

    };
}
