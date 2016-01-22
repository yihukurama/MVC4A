package com.yihukurama.mvc4a.controller.api.request;

import java.util.Map;

/**
 * Created by dengshuai on 16/1/8.
 * 该类封装请求的参数
 */
public class RequestParams {

    private Map<String,String> loginParams;

    public Map<String, String> getLoginParams() {
        return loginParams;
    }

    public void setLoginParams(Map<String, String> loginParams) {
        this.loginParams = loginParams;
    }
}
