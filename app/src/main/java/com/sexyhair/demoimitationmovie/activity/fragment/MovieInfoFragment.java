package com.sexyhair.demoimitationmovie.activity.fragment;

import android.view.View;

import com.sexyhair.demoimitationmovie.R;
import com.sexyhair.demoimitationmovie.components.bannerview.BannerLayout;

/**
 * Created by sexyhair on 16/12/13.
 */

public class MovieInfoFragment extends BaseFragment {
    private int[] resIds = {R.mipmap.banner_achieve_0,
            R.mipmap.banner_achieve_2,
            R.mipmap.banner_achieve_5,
            R.mipmap.banner_achieve_3
//            R.mipmap.banner_achieve_4,
//            R.mipmap.banner_achieve_5,
//            R.mipmap.banner_achieve_1
    };

    private BannerLayout mBannerLayout;

    @Override
    protected void findViews(View viewContainer) {
        super.findViews(viewContainer);
        mBannerLayout = viewContainer.findViewById(R.id.bannerLayout);
        mBannerLayout.startBannerAnimation(resIds);
    }

    @Override
    protected int getLayoutView() {
        return R.layout.fragment_moviesinfo;
    }
}
