package com.asia00.testmessenger2service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;

public class MessengerService extends Service {
    private static final String TAG = "MessengerService";

    private static class MessengerHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MyConstants. :
                    Log.i(TAG, "receive msg from client :" + msg.getData().getString("msg"));
                    break;
                default:
                    super.handleMessage(msg);
            }
        }
    }

    private final Messenger mMessenger = new Messenger(new MessengerHandler());

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
