package com.xinghai.frameworkdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.xinghai.framework.common.logger.Log;
import com.xinghai.framework.network.Api;
import com.xinghai.frameworkdemo.rxjava.RetryWhenNetworkException;
import com.xinghai.frameworkdemo.rxjava.Service;
import com.xinghai.frameworkdemo.rxjava.User;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created on 16/10/31.
 * author: yuanbaoyu
 */

public class TestRxJavaActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "TestRxJavaActivity";

    TextView mTvContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
        mTvContent = (TextView) findViewById(R.id.tv_content);
        mTvContent.setOnClickListener(this);
    }

    public void login(){
        Api.getInstance(this, "http://xxx/")
                .create(Service.class)
                .login("张三", "ddlldl")
                .retryWhen(new RetryWhenNetworkException())
                .subscribeOn(Schedulers.io())//指定 subscribe() 发生在 IO 线程
                .observeOn(AndroidSchedulers.mainThread())//回调在主线程
                .subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("login", "onSubscribe:\t");
                    }

                    @Override
                    public void onNext(User value) {
                        Log.e("login", "user:\t" + value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("login", "onError:\t" + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.e("login", "onComplete");
                    }
                });

    }

    public static void hello(String... names) {
        Observable.fromArray(names)
                .retryWhen(new RetryWhenNetworkException())//可以设置重试次数，延迟重试
                .subscribeOn(Schedulers.io())//指定 subscribe() 发生在 IO 线程
                .observeOn(AndroidSchedulers.mainThread())//回调在主线程
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String value) {
                        Log.e(TAG, "Observer 姓名：" + value);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void onClick(View view) {
//        hello("张三", "李四", "王五");
        login();
    }
}
