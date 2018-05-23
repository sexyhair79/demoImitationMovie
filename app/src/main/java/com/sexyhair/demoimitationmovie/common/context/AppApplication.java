package com.sexyhair.demoimitationmovie.common.context;

import android.app.Application;

import com.sexyhair.demoimitationmovie.common.utils.Contants;
import com.squareup.leakcanary.LeakCanary;


/**
 * Created by sexyhair on 16/12/13.
 */

public class AppApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //配置内存泄漏的检测：LeakCanary
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // 这个过程专门用于泄漏分析堆分析。不要在这个过程中输入你的应用程序。
            return;
        }
        LeakCanary.install(this);

        AppContext.appContext = AppApplication.this;
        AppContext.userInfoSP = getSharedPreferences(Contants.userInfoStatus, 0);// 0 标示私有
    }
}
