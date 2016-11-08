package com.xinghai.frameworkdemo.rxjava;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created on 16/11/7.
 * author: yuanbaoyu
 */

public interface Service {

    @GET("xxx/login/login")
    Observable<User> login(@Query("username") String usernamem,
                           @Query("password") String password);
}
