package com.example.fei.customtextview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/**
 * Created by Fei on 16/1/2.
 */
public class CustomTitleView extends View {
    //文本
    private String mTitleText;
    //尺寸
    private int mTitleTextSize;
    //颜色
    private int mTitleTextColor;

    public CustomTitleView(Context context) {
        super(context);
    }

    public CustomTitleView(Context context, AttributeSet attrs) {
//        super(context, attrs);
        this(context, attrs, 0);
//    this(context,attrs,R.attr.);
    }

    public CustomTitleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getSelStyle(context, attrs, defStyleAttr);
    }

    //获取自定义属性
    public void getSelStyle(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomTitleView, defStyleAttr, 0);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.CustomTitleView_titleText:
                    mTitleText = a.getString(attr);
                    break;
                case R.styleable.CustomTitleView_titleTextColorr:
                    mTitleTextColor = a.getInt(attr, Color.BLACK);
                    break;
                case R.styleable.CustomTitleView_titleTextSize:
                    mTitleTextSize = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
                    break;
            }
        }
        a.recycle();
        //绘制文本
        //定义画笔
        Paint mPaint = new Paint();
        mPaint.setColor(mTitleTextColor);
        mPaint.setTextSize(mTitleTextSize);
        Rect mRect = new Rect();
        mPaint.getTextBounds(mTitleText,0,mTitleText.length(),mRect);
    }
}
