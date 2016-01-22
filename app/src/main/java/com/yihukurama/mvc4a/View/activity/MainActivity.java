package com.yihukurama.mvc4a.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yihukurama.core.sdk.nohttp.NoHttpCallBack;
import com.yihukurama.mvc4a.R;
import com.yihukurama.mvc4a.view.activity.testactivity.DBActivity;
import com.yihukurama.mvc4a.view.activity.testactivity.LoginActivity;
import com.yolanda.nohttp.Response;

public class MainActivity extends BaseActivity implements NoHttpCallBack,View.OnClickListener{
    private NoHttpCallBack mHttpCB;


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


    }


    private void initData() {
        mHttpCB = this;

    }







    /**
     * nohttp 请求成功
     * @param what   请求id
     * @param response
     */
    @Override
    public void onSucceed(int what, Response response) {
        showToastLong(response.get().toString());
    }

    /**
     * nohttp 请求失败
     * @param what
     * @param url
     * @param tag
     * @param message
     * @param responseCode
     * @param networkMillis
     */
    @Override
    public void onFailed(int what, String url, Object tag, CharSequence message, int responseCode, long networkMillis) {
       showToastLong(message.toString());
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
        }
    }
}
