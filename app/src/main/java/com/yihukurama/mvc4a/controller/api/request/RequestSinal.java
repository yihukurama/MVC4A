package com.yihukurama.mvc4a.controller.api.request;

import com.yihukurama.core.sdk.nohttp.NoHttpSinal;

/**
 * Created by dengshuai on 16/1/7.
 * 请求接口的标识，不同标识代表不同的请求，可在返回中通过此标识来区分不同的请求从而对不同的请求进行相应的操作
 * 可以用接口号来赋值
 */
public class RequestSinal extends NoHttpSinal{
    public final static int login = 0;
}
