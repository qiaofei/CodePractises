package com.asia00.mydiary.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import com.asia00.mydiary.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = View.inflate(this, R.layout.activity_splash, null);
        setContentView(view);
        // 渐变展示启动屏
        setAnimation(view);
    }

    //缓冲页
    public void setAnimation(View view) {
        AlphaAnimation aa = new AlphaAnimation(0.5f, 1.0f);
        aa.setDuration(800);
        view.startAnimation(aa);
        aa.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                splashAction();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    //缓冲页面操作
    public void splashAction() {
        startActivity(new Intent(SplashActivity.this, LoginActivity.class));
    }
}
