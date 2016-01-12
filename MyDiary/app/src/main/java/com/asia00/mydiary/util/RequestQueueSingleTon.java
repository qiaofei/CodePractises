package com.asia00.mydiary.util;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by QiaoFei on 2015/11/17.
 */
public class RequestQueueSingleTon {
    private static RequestQueueSingleTon mInstance;
    private RequestQueue mRequestQueue;
    private static Context mCtx;

    private RequestQueueSingleTon(Context context) {
        mCtx = context;
        mRequestQueue = getRequestQueue();
    }

    public static synchronized RequestQueueSingleTon getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new RequestQueueSingleTon(context);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <t> void addToRequestQueue(Request<t> req) {
        getRequestQueue().add(req);
    }
}
