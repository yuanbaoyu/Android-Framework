package com.xinghai.frameworkdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.xinghai.framework.logger.Log;
import com.xinghai.framework.logger.LogFragment;
import com.xinghai.framework.logger.LogWrapper;
import com.xinghai.framework.logger.MessageOnlyLogFilter;
import com.xinghai.frameworkdemo.convenientbannerdemo.TestConvenientBannerActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toTestMaterialLayoutActivity(View view){
        startActivity(new Intent(this, TestMaterialLayoutActivity.class));
    }

    public void toTestSlidingLayoutActivity(View view){
        startActivity(new Intent(this, TestSlidingLayoutActivity.class));
    }

    public void toTestBanner(View view){
        startActivity(new Intent(this, TestConvenientBannerActivity.class));
    }

    public void toTestBaseAdapter(View view){
        startActivity(new Intent(this, TestBaseAdapterActivity.class));
    }

    public void toTestMenuItemView(View view){
        startActivity(new Intent(this, TestMenuItemViewActivity.class));
    }

    public void toTestLogger(View view){
        startActivity(new Intent(this, TestLoggerActivity.class));
    }

    public void toTestCrash(View view){
        startActivity(new Intent(this, TestCrashHandlerActivity.class));
    }
}
