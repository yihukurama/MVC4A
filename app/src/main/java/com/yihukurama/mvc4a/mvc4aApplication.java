package com.yihukurama.mvc4a;

import android.app.Application;

import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.NoHttp;

/**
 * Created by dengshuai on 16/1/5.
 */
public class Mvc4aApplication extends Application {
    private static Mvc4aApplication _instance;

    public String headPath;

    @Override
    public void onCreate() {
        super.onCreate();
        _instance = this;

        Logger.setTag("NoHttpSample");
        Logger.setDebug(true);// 开始NoHttp的调试模式，这样就能看到请求过程和日志

        NoHttp.init(this);

    }

    public static Mvc4aApplication getInstance() {
        return _instance;
    }
}
