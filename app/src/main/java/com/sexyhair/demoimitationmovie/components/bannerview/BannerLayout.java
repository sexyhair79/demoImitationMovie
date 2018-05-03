package com.sexyhair.demoimitationmovie.components.bannerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.sexyhair.demoimitationmovie.common.utils.Logger;

/**
 * Created by sexyhair on 18/4/19.
 */

public class BannerLayout extends FrameLayout {
    private BannerView mBannerView;
    private BannerIndicatorView mBannerIndicatorView;


    public BannerLayout(@NonNull Context context) {
        super(context);
        init(context, null);
    }

    public BannerLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public BannerLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }


    private void init(Context context, AttributeSet attrs) {
        mBannerView = new BannerView(context, attrs);
        mBannerIndicatorView = new BannerIndicatorView(context, attrs);
    }

    public void startBannerAnimation(int[] resIds) {
        if (resIds == null || resIds.length <= 0) {
            Logger.w(Logger.Log_View,
                    "BannerView--startBannerAnimation(int[] resIds) 参数错误");
            return;
        }

        mBannerView.startBannerAnimation(resIds);
    }
}
