package com.asia00.testservlet;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.asia00.testservlet.bean.UserInfoNew;
import com.asia00.testservlet.util.JsonUtil;
import com.asia00.testservlet.util.MyAdapter;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

public class UserListActivity extends AppCompatActivity {
    private ListView listView;
    private List<UserInfoNew> list;
    private Message message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        listView = (ListView) findViewById(R.id.listView);
        message = new Message();
        getServerData();
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    setListViewData();
                    break;
            }
        }
    };

    //为listview设置数据
    public void setListViewData() {
        MyAdapter myAdapter = new MyAdapter(this, list, R.layout.list_item);
        listView.setAdapter(myAdapter);
    }

    //获取服务器数据
    public void getServerData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //使用http请求,总共分五步
                //1,创建httpClient对象
                HttpClient httpCient = new DefaultHttpClient();
                //第二步：创建代表请求的对象,参数是访问的服务器地址
                HttpGet httpGet = new HttpGet("http://192.168.1.189:8080/th/servlet/GetAllDriverInfo");
                try {
                    //3,执行请求,获取服务器返回的对象
                    HttpResponse httpResponse = httpCient.execute(httpGet);
                    //4,检查状态是否正常
                    if (httpResponse.getStatusLine().getStatusCode() == 200) {
                        //5,从返回的数据中获取到对应的entity
                        HttpEntity httpEntity = httpResponse.getEntity();
                        String response = EntityUtils.toString(httpEntity, "utf-8");//将entity当中的数据转换为字符串
                        list = JsonUtil.getListByStr(response, UserInfoNew.class);
                        message.what = 0;
                        handler.sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
