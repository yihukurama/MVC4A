package com.yihukurama.core.sdk.nohttp;

import android.content.Context;

import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.Request;
import com.yolanda.nohttp.RequestQueue;
import com.yolanda.nohttp.download.DownloadQueue;

/**
 * Created by dengshuai on 16/1/5.
 */
public class NoHttpApi {
    private static NoHttpApi noHttpApi;

    private RequestQueue requestQueue;

    private static DownloadQueue downloadQueue;

    private NoHttpApi() {
        requestQueue = NoHttp.newRequestQueue();
    }

    /**
     * 创建请求对象，管理请求队列
     */
    public static NoHttpApi getRequestInstance() {
        if (noHttpApi == null)
            noHttpApi = new NoHttpApi();
        return noHttpApi;
    }

    public static DownloadQueue getDownloadInstance() {
        if (downloadQueue == null)
            downloadQueue = NoHttp.newDownloadQueue();
        return downloadQueue;
    }

    /**
     * 添加一个请求到请求队列
     */
    public <T> void add(Context context, int what, Request<T> request, NoHttpCallBack<T> callback) {
        // what: 用来区分请求，当多个请求使用同一个OnResponseListener时，在回调方法中会返回这个what
        // request: 请求对象，包涵Cookie、Head、请求参数、URL、请求方法
        // responseListener 请求结果监听，回调时把what原样返回
        requestQueue.add(what, request, new NoHttpResponseListener<T>(context, callback));
    }

    /**
     * 取消这个sign标记的所有请求
     */
    public void cancelBySign(Object sign) {
        requestQueue.cancelBySign(sign);
    }

    /**
     * 取消队列中所有请求
     */
    public void cancelAll() {
        requestQueue.cancelAll();
    }

    /**
     * 退出app时停止所有请求
     */
    public void stopAll() {
        requestQueue.stop();
    }

}
