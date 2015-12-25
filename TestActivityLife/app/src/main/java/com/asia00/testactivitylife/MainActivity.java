package com.asia00.testactivitylife;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String tag = " 1";
    private TextView textView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.tv);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
        Log.d("tag", "onCreate" + tag);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("tag", "onStart" + tag);
        textView.setText("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("tag", "onResume" + tag);
        textView.setText("onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("tag", "onRestart" + tag);
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
    /*      12-25 18:26:25.245 24499-24499/com.asia00.testactivitylife D/tagonPause 1
            12-25 18:26:25.245 24499-24499/com.asia00.testactivitylife D/tag: onSaveInstanceState 1
            12-25 18:26:25.245 24499-24499/com.asia00.testactivitylife D/tag: onStop 1
            12-25 18:26:25.245 24499-24499/com.asia00.testactivitylife D/tag: onDestroy 1
            12-25 18:26:25.315 24499-24499/com.asia00.testactivitylife D/tag: onCreate 1
            12-25 18:26:25.315 24499-24499/com.asia00.testactivitylife D/tag: onStart 1
            12-25 18:26:25.315 24499-24499/com.asia00.testactivitylife D/tag: onRestoreInstanceState 1
            12-25 18:26:25.325 24499-24499/com.asia00.testactivitylife D/tag: onResume 1*/
    //正确的Activity生命周期
    // 打开Activity onCreate -> onStart -> onResume
    //关闭Activity onPause -> onStop -> onDestroy
    //倒转Activity onPause -> onSaveInstance -> onStop -> onDestroy -> onCreate -> onStart -> onRestoreInstanceState
}
