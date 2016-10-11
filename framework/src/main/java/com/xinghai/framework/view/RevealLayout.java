package com.xinghai.framework.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created on 16/9/18.
 * author: yuanbaoyu
 */
public class RevealLayout extends LinearLayout {

    public RevealLayout(Context context) {
        super(context);
    }

    public RevealLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RevealLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public RevealLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


}
