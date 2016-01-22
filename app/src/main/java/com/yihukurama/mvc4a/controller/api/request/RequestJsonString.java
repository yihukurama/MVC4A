package com.yihukurama.mvc4a.controller.api.request;

import com.yihukurama.mvc4a.controller.utils.code.md5.MD5Utils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by dengshuai on 16/1/7.
 * 把用于请求的参数转化为Json串
 */
public class RequestJsonString {


    public static String loginJsonString(RequestParams requestParams){
        JSONObject object = new JSONObject();
        JSONObject object2 = new JSONObject();
        try {
            object.put("m", "db");
            object.put("oper", "query");
            object.put("sqlid", "31000");
            object2.put("UID", requestParams.getLoginParams().get("UID"));
            String usermd5 = MD5Utils.encrypt(requestParams.getLoginParams().get("UID"));
            String passmd5 = MD5Utils.encrypt(requestParams.getLoginParams().get("PWD"));
            String pwd = usermd5 + passmd5;
            String md5pwd = MD5Utils.encrypt(pwd,true);
            object2.put("PWD", md5pwd);
            object2.put("IMSI", requestParams.getLoginParams().get("IMSI"));
            object2.put("SITE", requestParams.getLoginParams().get("SITE"));
            if(requestParams.getLoginParams().get("VALIDATE_CODE")!=null)
                object2.put("VALIDATE_CODE", requestParams.getLoginParams().get("VALIDATE_CODE"));
            else
                object2.put("VALIDATE_CODE", "");
            object.put("params", object2);
        } catch (JSONException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        String json = object.toString();
        return json;
    }
}
