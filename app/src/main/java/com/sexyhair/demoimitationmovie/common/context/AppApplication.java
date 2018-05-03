package com.sexyhair.demoimitationmovie.common.context;

import android.app.Application;

import com.sexyhair.demoimitationmovie.common.utils.Contants;


/**
 * Created by sexyhair on 16/12/13.
 */

public class AppApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppContext.appContext = AppApplication.this;
        AppContext.userInfoSP = getSharedPreferences(Contants.userInfoStatus, 0);// 0 标示私有
    }
}
