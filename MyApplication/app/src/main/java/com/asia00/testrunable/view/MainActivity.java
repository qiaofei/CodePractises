package com.asia00.testrunable.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.asia00.testrunable.R;
import com.asia00.testrunable.presenter.MainActivityPresenter;

public class MainActivity extends AppCompatActivity implements IMainActivity {
    private TextView tvHello;
    private Button btChangeNumber;
    private MainActivityPresenter mainActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivityPresenter mainActivityPresenter = new MainActivityPresenter();
        tvHello = (TextView) findViewById(R.id.tvHello);
        btChangeNumber = (Button) findViewById(R.id.btChangeNumber);
        btChangeNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTextString(tvHello);
            }
        });
    }

    @Override
    public void setTextString(TextView textView) {
        mainActivityPresenter.getText(textView);
    }
}
