package com.yihukurama.mvc4a.controller.api.response;

import android.util.Log;

import com.yihukurama.core.utils.JsonUtil;
import com.yihukurama.mvc4a.model.object.response.LoginResponseBean;
import com.yolanda.nohttp.Response;

/**
 * Created by dengshuai on 16/1/7.
 * 把响应的数据转化成程序里的实体
 */
public class Response2Bean {


    public static LoginResponseBean toLoginBean(Response response){
        LoginResponseBean loginResponseBean = null;
        try {//尝试转化为java对象
            loginResponseBean = JsonUtil.jsonToBean(response.get().toString(), LoginResponseBean.class);
            Log.i("NoHttp", loginResponseBean.getOutresult());

        } catch (Exception e) {
            e.printStackTrace();
            Log.i("NoHttp", "程序出了点小状况" + e.toString());
        }

        return loginResponseBean;
    }
}
