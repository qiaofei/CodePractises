package com.asia00.testservlet;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.asia00.testservlet.bean.UserInfo;
import com.google.gson.Gson;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    EditText etPassword;
    Button btnLogin;
    Message message;
    Button btnGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = (EditText) findViewById(R.id.etName);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnGo = (Button) findViewById(R.id.btnGo);
        message = new Message();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLogin();
            }
        });
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, UserListActivity.class));
            }
        });
    }


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    Toast.makeText(getApplicationContext(), "用户名密码正确", Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    Toast.makeText(getApplicationContext(), "用户名密码错误", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    //判断是否登陆成功
    public void checkLogin() {

        //开启线程网络请求
        new Thread(new Runnable() {
            String userName = etName.getText().toString();
            String userPassword = etPassword.getText().toString();

            @Override
            public void run() {
                //使用http请求,总共分五步
                //1,创建httpClient对象
                HttpClient httpCient = new DefaultHttpClient();
                //第二步：创建代表请求的对象,参数是访问的服务器地址
                HttpGet httpGet = new HttpGet("http://192.168.1.189:8080/th/servlet/AppTestServlet");
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
                        //判断用户名和密码是否正确
                        if (userName.equals(userInfo.getUserName()) && userPassword.equals(userInfo.getUserPassword())) {
                            message.what = 0;
                        } else {
                            message.what = 1;
                        }
                        handler.sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
