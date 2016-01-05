package com.yihukurama.core.sdk.nohttp;

import android.content.Context;

import com.yihukurama.core.android.widge.WaitDialog;
import com.yolanda.nohttp.OnResponseListener;
import com.yolanda.nohttp.Response;

/**
 * Created by dengshuai on 16/1/5.
 */
public class NoHttpResponseListener<T> implements OnResponseListener<T> {

    private WaitDialog mWaitDialog;

    private NoHttpCallBack<T> callback;

    public NoHttpResponseListener(Context context, NoHttpCallBack<T> httpCallback) {
        if (context != null)
            mWaitDialog = new WaitDialog(context);
        this.callback = httpCallback;
    }

    @Override
    public void onStart(int what) {
        if (mWaitDialog != null && !mWaitDialog.isShowing())
            mWaitDialog.show();
    }

    @Override
    public void onSucceed(int what, Response<T> response) {
        if (callback != null)
            callback.onSucceed(what, response);
    }

    @Override
    public void onFailed(int what, String url, Object tag, CharSequence message, int responseCode, long networkMillis) {
        if (callback != null)
            callback.onFailed(what, url, tag, message, responseCode, networkMillis);
    }

    @Override
    public void onFinish(int what) {
        if (mWaitDialog != null && mWaitDialog.isShowing())
            mWaitDialog.dismiss();
    }
}
