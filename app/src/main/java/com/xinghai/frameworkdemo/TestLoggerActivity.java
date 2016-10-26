package com.xinghai.frameworkdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.xinghai.framework.logger.Log;
import com.xinghai.framework.logger.LogFragment;
import com.xinghai.framework.logger.LogWrapper;
import com.xinghai.framework.logger.MessageOnlyLogFilter;

/**
 * Created on 16/10/26.
 * author: yuanbaoyu
 */

public class TestLoggerActivity extends AppCompatActivity {

    private static final String TAG = "TestLoggerActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_logger);
        initLogger();
    }

    private void initLogger() {
        LogWrapper logWrapper = new LogWrapper();
        // Using Log, front-end to the logging chain, emulates android.util.log method signatures.
        Log.setLogNode(logWrapper);

        // Filter strips out everything except the message text.
        MessageOnlyLogFilter msgFilter = new MessageOnlyLogFilter();
        logWrapper.setNext(msgFilter);

        // On screen logging via a fragment with a TextView.
        LogFragment logFragment = (LogFragment) getSupportFragmentManager()
                .findFragmentById(R.id.log_fragment);
        msgFilter.setNext(logFragment.getLogView());

        String s = null;

        Log.e(TAG, "Ready");

        try {
            s.length();
        }catch (NullPointerException e){
            Log.e(TAG,"异常信息", e);
        }

        Log.d(TAG, json);
    }

    String json = "{\n" +
            "  \"array\": [\n" +
            "    1,\n" +
            "    2,\n" +
            "    3\n" +
            "  ],\n" +
            "  \"boolean\": true,\n" +
            "  \"null\": null,\n" +
            "  \"number\": 123,\n" +
            "  \"object\": {\n" +
            "    \"a\": \"b\",\n" +
            "    \"c\": \"d\",\n" +
            "    \"e\": \"f\"\n" +
            "  },\n" +
            "  \"string\": \"Hello World\"\n" +
            "}";
}
