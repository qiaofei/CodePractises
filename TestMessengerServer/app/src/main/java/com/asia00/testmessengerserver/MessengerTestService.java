package com.asia00.testmessengerserver;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by QiaoFei on 2015/12/29.
 */
public class MessengerTestService extends Service {
    @Nullable

    protected static final String TAG = "MessengerTestService";

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Log.d(TAG, "收到消息");
                    //获取客户端message中的Messenger，用于回调
                    final Messenger callback = msg.replyTo;
                    try {
                        // 回调
                        callback.send(Message.obtain(null, 0));
                    } catch (RemoteException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
            }
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        return new Messenger(mHandler).getBinder();
    }
}
