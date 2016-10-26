package com.xinghai.frameworkdemo;

import android.app.Application;

import com.xinghai.framework.crash.CrashHandler;

/**
 * Created on 16/10/26.
 * author: yuanbaoyu
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CrashHandler.getInstance().init(this);
    }
}
