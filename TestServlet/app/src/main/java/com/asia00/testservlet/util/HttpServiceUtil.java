package com.asia00.testservlet.util;

import com.asia00.testservlet.bean.UserInfo;
import com.google.gson.Gson;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by QiaoFei on 2016/1/6.
 */
public class HttpServiceUtil {
    public static void get() {

        //开启线程网络请求
        new Thread(new Runnable() {
            @Override
            public void run() {
                //使用http请求,总共分五步
                //1,创建httpClient对象
                HttpClient httpCient = new DefaultHttpClient();
                //第二步：创建代表请求的对象,参数是访问的服务器地址
                HttpGet httpGet = new HttpGet("http://192.168.1.111:8080/th/servlet/AppTestServlet");
                try {
                    //3,执行请求,获取服务器返回的对象
                    HttpResponse httpResponse = httpCient.execute(httpGet);
                    //4,检查状态是否正常
                    if (httpResponse.getStatusLine().getStatusCode() == 200) {
                        //5,从返回的数据中获取到对应的entity
                        HttpEntity httpEntity = httpResponse.getEntity();
                        String response = EntityUtils.toString(httpEntity, "utf-8");//将entity当中的数据转换为字符串
                        //使用gson将字符串转换成对应的Bean
                        Gson gson = new Gson();
                        UserInfo userInfo = gson.fromJson(response, UserInfo.class);
                        /*//判断用户名和密码是否正确
                        if (userName.equals(userInfo.getUserName()) && userPassword.equals(userInfo.getUserPassword())) {
                            message.what = 0;
                        } else {
                            message.what = 1;
                        }
                        handler.sendMessage(message);*/
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
