package com.yihukurama.core;

import android.content.Context;

import com.yihukurama.core.sdk.imageloader.ImageLoaderApi;
import com.yihukurama.core.utils.AppInfoUtil;

/**
 * Created by dengshuai on 16/2/23.
 */
public class MVC4A {

    private static Context appContext;
    public static void init(Context context){
        appContext = context;
        AppInfoUtil.initAppInfoUtil(context);
        ImageLoaderApi.initImageLoader(context);
    }

    public static Context getApplicationContext(){
        return appContext;
    }
}
