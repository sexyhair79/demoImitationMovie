package com.sexyhair.demoimitationmovie.common.utils;

import com.sexyhair.demoimitationmovie.common.context.AppContext;

/**
 * Created by sexyhair on 18/5/3.
 */

public class PhoneUtils {
    public static void getStatusHeight(){
        /**
         * 获取状态栏高度——方法2
         * */
        int statusHeight = -1;
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int height = Integer.parseInt(clazz.getField("status_bar_height")
                    .get(object).toString());
            statusHeight = AppContext.appContext.getResources().getDimensionPixelSize(height);
        } catch (Exception e) {
            e.printStackTrace();
        }
       AppContext.screenStatusHeight = statusHeight;
    }
}
