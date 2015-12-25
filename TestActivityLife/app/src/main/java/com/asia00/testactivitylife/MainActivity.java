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
}
