package com.yihukurama.core.utils;

import android.content.Context;
import android.content.pm.PackageManager;

/**
 * Created by dengshuai on 16/2/23.
 * 获取APP基本信息，在application类中初始化
 */
public class AppInfoUtil {
    private static AppInfoUtil ourInstance;
    private Context mContext;
    public static AppInfoUtil getInstance() {

        return ourInstance;

    }

    public static AppInfoUtil initAppInfoUtil(Context context){

        ourInstance = new AppInfoUtil(context);
        return ourInstance;
    }
    private AppInfoUtil(Context context) {
        this.mContext = context;
    }

    //获取APP名字
    public String getAppName(){
        PackageManager pm = mContext.getPackageManager();
        String appName = mContext.getApplicationInfo().loadLabel(pm).toString();
        return appName;
    }


    //获取APP包名
    public String getPakageName(){
        return mContext.getPackageName();
    }

    //获取APP版本号
    public String getVersion(){
        return "";
    }
}
