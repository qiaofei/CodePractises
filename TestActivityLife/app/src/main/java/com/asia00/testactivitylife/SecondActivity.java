package com.asia00.testactivitylife;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by QiaoFei on 2015/12/25.
 */
public class SecondActivity extends Activity {
    private String tag = "2";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("tag", "onCreate" + tag);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("tag", "onStart" + tag);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("tag", "onResume" + tag);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("tag", "onPause" + tag);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("tag", "onStop" + tag);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("tag", "onDestroy" + tag);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("tag", "onSaveInstanceState" + tag);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("tag", "onRestoreInstanceState" + tag);
    }
}
