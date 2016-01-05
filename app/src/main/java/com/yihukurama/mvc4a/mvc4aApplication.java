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

        // 设置默认的Cookie管理器，不设置的话NoHttp会自动替你完成Cookie的维护
        // 设置Cookit管理器的好处是APP初始化的时候加载必要的Cookie，但是也可以在每个Request对象中添加Cookie
//		NoHttp.setDefaultCookieManager(new MyCookieManager());
    }

    public static Mvc4aApplication getInstance() {
        return _instance;
    }
}
