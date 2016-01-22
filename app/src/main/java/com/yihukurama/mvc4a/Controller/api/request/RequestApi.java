package com.yihukurama.mvc4a.controller.api.request;

import android.content.Context;
import android.util.Log;

import com.yihukurama.core.sdk.nohttp.NoHttpApi;
import com.yihukurama.core.sdk.nohttp.NoHttpCallBack;
import com.yihukurama.mvc4a.model.data.memory.URLConstants;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.Request;
import com.yolanda.nohttp.RequestMethod;

import java.io.UnsupportedEncodingException;

/**
 * Created by dengshuai on 16/1/6.
 * 请求API，APP里的所有请求都用该类静态方法
 */
public class RequestApi {


    public static void loginRequest(NoHttpCallBack<String> noHttpCB,Context context,RequestParams requestParams){


        String requestJson = RequestJsonString.loginJsonString(requestParams);
        Log.i("NoHttp", "loginRequest：" + requestJson);
        Request<String> mRequest= NoHttp.createStringRequest(URLConstants.API_PATH, RequestMethod.POST);
        // github是https的请求，这里直接允许，不做证书验证，具体Https的使用请看NoHttpsActivity
        mRequest.setAllowHttps(true);
        try {
            mRequest.setRequestBody(requestJson.getBytes(NoHttp.CHARSET_UTF8));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return;
        }

        // 设置这个请求的tag，NoHttp的请求会为你保持这个tag，在成功或者失败时返回给你
        mRequest.setTag(RequestSinal.login);

        // what: 用来区分请求，当多个请求使用同一个OnResponseListener时，在回调方法中会返回这个what，相当于handler的what一样
        // request: 请求对象，包涵Cookie、Head、请求参数、URL、请求方法
        // responseListener 请求结果监听，回调时把what原样返回
        NoHttpApi.getRequestInstance().add(context, RequestSinal.login, mRequest, noHttpCB);// 这里的what，先用0代替，正式开发中，多个请求使用同一个Listener时，要传入不同的what，相当于handler的what一样
    }




}
