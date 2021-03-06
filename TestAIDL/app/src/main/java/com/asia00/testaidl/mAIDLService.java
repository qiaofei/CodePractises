package com.asia00.testaidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.asia00.testaidl.aidl.ForActivity;
import com.asia00.testaidl.aidl.ForService;

public class mAIDLService extends Service {
    private static final String TAG = "AIDLService";
    private ForActivity callback;
    private void Log(String str) {
        Log.d(TAG, "------ " + str + "------");
    }
    @Override
    public void onCreate() {
        Log("service create");
    }
    @Override
    public void onStart(Intent intent, int startId) {
        Log("service start id=" + startId);
    }

    @Override
    public IBinder onBind(Intent t) {
        Log("service on bind");
        return mBinder;
    }
    @Override
    public void onDestroy() {
        Log("service on destroy");
        super.onDestroy();
    }
    @Override
    public boolean onUnbind(Intent intent) {
        Log("service on unbind");
        return super.onUnbind(intent);
    }
    public void onRebind(Intent intent) {
        Log("service on rebind");
        super.onRebind(intent);
    }
    private final ForService.Stub mBinder = new ForService.Stub() {
        @Override
        public void involkCallBack() throws RemoteException {
            callback.performAction();
        }

        @Override
        public void registerTestCall(ForActivity cb) throws RemoteException
        {
            callback = cb;

        }

    };
}
