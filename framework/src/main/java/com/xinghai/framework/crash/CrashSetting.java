package com.xinghai.framework.crash;

import android.os.Environment;

/**
 * Created on 16/10/26.
 * author: yuanbaoyu
 */

public class CrashSetting {

    public static final String CrashLogDir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + "framework_log";

}
