package com.xinghai.framework.common.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;

import com.xinghai.framework.R;
import com.xinghai.framework.common.logger.Log;

/**
 * Created on 16/10/14.
 * author: yuanbaoyu
 */

public class NetUtils {
    public static final String TAG = "NetUtils";

    public static final int TYPE_NO = -1;
    public static final int TYPE_WIFI = 0;
    public static final int TYPE_MOBILE = 1;

    /**
     * Check whether the device is connected, and if so, whether the connection
     * is wifi or mobile (it could be something else).
     *
     * @param context
     * @return TYPE_NO，无网；TYPE_WIFI，wifi连接；TYPE_MOBILE，移动数据连接
     */
    public int checkNetworkConnection(@NonNull Context context) {
        // BEGIN_INCLUDE(connect)
        ConnectivityManager connMgr =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeInfo = connMgr.getActiveNetworkInfo();
        if (activeInfo != null && activeInfo.isConnected()) {
            boolean wifiConnected = activeInfo.getType() == ConnectivityManager.TYPE_WIFI;
            boolean mobileConnected = activeInfo.getType() == ConnectivityManager.TYPE_MOBILE;
            if(wifiConnected) {
                Log.i(TAG, context.getString(R.string.wifi_connection));
                return TYPE_WIFI;
            } else if (mobileConnected){
                Log.i(TAG, context.getString(R.string.mobile_connection));
                return TYPE_MOBILE;
            }
        } else {
            Log.i(TAG, context.getString(R.string.no_wifi_or_mobile));
        }
        return TYPE_NO;
        // END_INCLUDE(connect)
    }

    /**
     * 网络是否连接
     * @param context
     * @return true,网络连接；false，无网
     */
    public boolean isOnline(@NonNull Context context){
        int type = checkNetworkConnection(context);
        if(type == TYPE_NO){
            return false;
        }
        return true;
    }
}
