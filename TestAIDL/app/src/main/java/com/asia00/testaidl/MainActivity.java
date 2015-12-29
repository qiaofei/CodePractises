package com.asia00.testaidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.asia00.testaidl.aidl.ForActivity;
import com.asia00.testaidl.aidl.ForService;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "AIDLActivity";
    private Button btnOk;
    private Button btnCancel;
    private Button btnCallBack;

    private void Log(String str) {
        Log.d(TAG, "------ " + str + "------");
    }

    private ForActivity mCallBack = new ForActivity.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public void performAction() throws RemoteException {
            Toast.makeText(MainActivity.this, "this toast is called from service", Toast.LENGTH_SHORT).show();
        }
    };

    ForService mService;
    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mService = ForService.Stub.asInterface(service);
            try {
                mService.registerTestCall(mCallBack);
            } catch (Exception e) {
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log("disconnect service");
            mService = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOk = (Button) findViewById(R.id.btn_ok);
        btnCancel = (Button) findViewById(R.id.btn_cancle);
        btnCallBack = (Button) findViewById(R.id.btn_callback);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                Intent intent = new Intent(MainActivity.this, mAIDLService.class);
                intent.putExtras(args);
                //bindService
                bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
                //startService
                startService(intent);
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                unbindService(mConnection);
                //stopService(intent);
            }
        });
        btnCallBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    mService.involkCallBack();
                } catch (RemoteException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }
}
