package com.yihukurama.mvc4a.view.activity.testactivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.yihukurama.core.sdk.nohttp.NoHttpCallBack;
import com.yihukurama.mvc4a.R;
import com.yihukurama.mvc4a.controller.api.request.RequestApi;
import com.yihukurama.mvc4a.controller.api.request.RequestParams;
import com.yihukurama.mvc4a.controller.api.response.Response2Bean;
import com.yihukurama.mvc4a.model.object.response.LoginResponseBean;
import com.yihukurama.mvc4a.view.activity.BaseActivity;
import com.yolanda.nohttp.Response;

import java.util.HashMap;
import java.util.Map;

/**
 * A login screen that offers login via email/password.
 */
/**
 * Created by dengshuai on 15/12/30.
 */
public class LoginActivity extends BaseActivity implements NoHttpCallBack,View.OnClickListener {

    // UI references.
    private AutoCompleteTextView mAccountView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    private Button mLoginButton;

    private NoHttpCallBack mHttpCB;
    private RequestParams requestParamses;
    private Map<String,String> loginParams;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        initData();

    }

    private void initView() {
        mAccountView = (AutoCompleteTextView) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);

        mLoginButton = (Button) findViewById(R.id.email_sign_in_button);

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
    }

    private void initData() {
        mHttpCB = this;
        requestParamses = new RequestParams();
        loginParams = new HashMap<String,String>();
        mLoginButton.setOnClickListener(this);
    }





    private void LoginRequest(){



        requestParamses.setLoginParams(loginParams);
        loginParams.put("UID", "15914865707");
        loginParams.put("PWD","5502258");
        loginParams.put("IMSI","89860001191407189811");
        loginParams.put("VALIDATE","");

        RequestApi.loginRequest(mHttpCB,mContext,requestParamses);
    }




    @Override
    public void onSucceed(int what, Response response) {
        showToastLong(response.get().toString());
        Log.i("NoHttp", "发送成功" + response.get().toString());


        //LoginResponseBean loginResponseBean = Response2Bean.toLoginBean(response);

        //用loginResponseBean做相应的业务处理


    }

    @Override
    public void onFailed(int what, String url, Object tag, CharSequence message, int responseCode, long networkMillis) {
        showToastLong(message.toString());
        Log.i("NoHttp","发送失败"+message.toString());
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.email_sign_in_button:
                LoginRequest();
                break;

        }
    }
}

