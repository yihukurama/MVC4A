package com.yihukurama.core.sdk.nohttp;

import com.yolanda.nohttp.Response;

/**
 * Created by dengshuai on 16/1/5.
 * interface for http response
 */
public abstract interface NoHttpCallBack<T> {
    public abstract void onSucceed(int what, Response<T> response);

    public abstract void onFailed(int what, String url, Object tag, CharSequence message, int responseCode, long networkMillis);
}
