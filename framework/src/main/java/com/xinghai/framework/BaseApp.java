package com.xinghai.framework;

import android.app.Application;

import com.xinghai.framework.common.crash.CrashHandler;
import com.xinghai.framework.common.logger.Log;
import com.xinghai.framework.common.logger.LogWrapper;

/**
 * Created on 16/11/7.
 * author: yuanbaoyu
 */

public class BaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //crash日志输出
        CrashHandler.getInstance().init(this);

        //配置log
        LogWrapper logWrapper = new LogWrapper();
        Log.setLogNode(logWrapper);
    }
}
