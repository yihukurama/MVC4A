package com.yihukurama.mvc4a.View.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.yihukurama.core.sdk.nohttp.NoHttpApi;
import com.yihukurama.core.sdk.nohttp.NoHttpCallBack;
import com.yihukurama.mvc4a.R;
import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.Request;
import com.yolanda.nohttp.RequestMethod;
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



    }


    private void initData() {
        mHttpCB = this;

    }




    private void noHttpRequestAction(){
        String mTargetUrl = "https://www.baidu.com";
        RequestMethod method = RequestMethod.POST;
        // 创建request时传入url和method
        Request<String> mRequest= NoHttp.createStringRequest(mTargetUrl, method);
        // github是https的请求，这里直接允许，不做证书验证，具体Https的使用请看NoHttpsActivity
        mRequest.setAllowHttps(true);

        // 设置这个请求的tag，NoHttp的请求会为你保持这个tag，在成功或者失败时返回给你
        // mRequest.setTag(object);

        // what: 用来区分请求，当多个请求使用同一个OnResponseListener时，在回调方法中会返回这个what，相当于handler的what一样
        // request: 请求对象，包涵Cookie、Head、请求参数、URL、请求方法
        // responseListener 请求结果监听，回调时把what原样返回
        NoHttpApi.getRequestInstance().add(mContext, 0, mRequest, mHttpCB);// 这里的what，先用0代替，正式开发中，多个请求使用同一个Listener时，要传入不同的what，相当于handler的what一样
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
                noHttpRequestAction();
                break;

        }
    }
}
