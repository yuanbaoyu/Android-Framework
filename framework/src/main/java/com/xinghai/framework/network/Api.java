package com.xinghai.framework.network;

import android.content.Context;
import android.text.TextUtils;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created on 16/11/7.
 * author: yuanbaoyu
 */

public class Api {

    private static OkHttpClient okHttpClient;

    private static Retrofit retrofit;

    private static Context mContext;

    private static final int DEFAULT_TIMEOUT = 20;
    public static String baseUrl;
//    private Cache cache = null;
//    private File httpCacheDirectory;

    private static class SingletonHolder {
        private static final Api INSTANCE = new Api(mContext);
    }

    public static Api getInstance(Context context, String url) {
        if (context != null) {
            mContext = context;
            baseUrl = url;
        }
        return SingletonHolder.INSTANCE;
    }

//    public static Api getInstance(Context context, String url, Map<String, String> headers) {
//        if (context != null) {
//            mContext = context;
//        }
//        return new Api(context, url, headers);
//    }

    private Api(){}

    private Api(Context context) {

        this(context, baseUrl, null);
    }

    private Api(Context context, String url) {

        this(context, url, null);
    }

    private Api(Context context, String url, Map<String, String> headers) {

        if (TextUtils.isEmpty(url)) {
            url = baseUrl;
        }

//        if ( httpCacheDirectory == null) {
//            httpCacheDirectory = new File(mContext.getCacheDir(), "tamic_cache");
//        }
//
//        try {
//            if (cache == null) {
//                cache = new Cache(httpCacheDirectory, 10 * 1024 * 1024);
//            }
//        } catch (Exception e) {
//            Log.e("OKHttp", "Could not create http cache", e);
//        }

        okHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(
                        new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
//                .cookieJar(new NovateCookieManger(context))
//                .cache(cache)
                .addInterceptor(new BaseInterceptor(headers))
//                .addInterceptor(new CaheInterceptor(context))
//                .addNetworkInterceptor(new CaheInterceptor(context))
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .connectionPool(new ConnectionPool(8, 15, TimeUnit.SECONDS))
                // 这里你可以根据自己的机型设置同时连接的个数和时间，我这里8个，和每个保持时间为10s
                .build();
        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

    }

    /**
     * create you ApiService
     * Create an implementation of the API endpoints defined by the {@code service} interface.
     */
    public <T> T create(final Class<T> service){
        if (service == null) {
            throw new RuntimeException("Api service is null!");
        }
        return retrofit.create(service);
    }

}
