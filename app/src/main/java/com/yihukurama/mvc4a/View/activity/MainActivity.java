package com.yihukurama.mvc4a.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import com.yihukurama.mvc4a.R;
import com.yihukurama.mvc4a.view.activity.testactivity.DBActivity;
import com.yihukurama.mvc4a.view.activity.testactivity.LoginActivity;
import com.yihukurama.mvc4a.view.activity.testactivity.SdcardActivity;
import com.yihukurama.mvc4a.view.activity.testactivity.WebActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化控件
        initView();

        //初始化一些成员变量
        initData();


    }




    private void initView() {


        findViewById(R.id.btn_http).setOnClickListener(this);
        findViewById(R.id.btn_db).setOnClickListener(this);
        findViewById(R.id.btn_sdcard).setOnClickListener(this);
        findViewById(R.id.btn_web).setOnClickListener(this);

    }


    private void initData() {


    }









    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_http:
                Intent intent = new Intent(MainActivity.this,
                    LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.btn_db:
                Intent intent2 = new Intent(MainActivity.this,
                        DBActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.btn_sdcard:
                Intent intent3 = new Intent(MainActivity.this,
                        SdcardActivity.class);
                startActivity(intent3);
                finish();
                break;
            case R.id.btn_web:
                Intent intent4 = new Intent(MainActivity.this,
                        WebActivity.class);
                startActivity(intent4);

                break;
        }
    }
}
