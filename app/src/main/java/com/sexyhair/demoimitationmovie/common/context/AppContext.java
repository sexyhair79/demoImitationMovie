package com.sexyhair.demoimitationmovie.common.context;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.sexyhair.demoimitationmovie.common.utils.Logger;

import java.lang.reflect.Constructor;

/**
 * Created by sexyhair on 16/12/13.
 */

public class AppContext {
    public static final String userId = "aeffdkajf";
    /**
     * 整体的上下文
     */
    public static Context appContext = null;

    /**
     * 这个是当前正在显示可交互的activity
     */
    public static Activity currentActivity = null;


    public static SharedPreferences userInfoSP = null;

    public static int screenWidth = -1;
    public static int screenHeight = -1;
    public static int screenStatusHeight = -1;
    public static int screenTitleHeight = -1;
    public static int screenContentHeight = -1;

    public static Object getBaseBeanByClazz(Context context, Class targetBeanClazz) {
        Object tartgetBean = null;
        try {
            Constructor constructor = targetBeanClazz.getConstructor(Context.class);
            tartgetBean = constructor.newInstance(context);
        } catch (Exception e) {
            Logger.w(Logger.Log_TryException, "AppContext.java--getBaseBeanByClazz()中异常" + e);
        }
        return tartgetBean;
    }

}
