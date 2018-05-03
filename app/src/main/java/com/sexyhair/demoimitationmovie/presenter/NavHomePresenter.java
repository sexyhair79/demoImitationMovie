package com.sexyhair.demoimitationmovie.presenter;

import com.sexyhair.demoimitationmovie.model.NavHomeModel;
import com.sexyhair.demoimitationmovie.model.NavHomeModelImpl;
import com.sexyhair.demoimitationmovie.view.NavHomeView;

/**
 * Created by sexyhair on 18/4/23.
 */

public class NavHomePresenter extends BasePresenter<NavHomeView> implements NavHomeModel.OnLoadBannerListenter<int[]>
        , NavHomeModel.OnLoadNewsListenter<String> {

    protected NavHomeModelImpl mNavHomeModeImpl;


    public NavHomePresenter() {
        mNavHomeModeImpl = new NavHomeModelImpl();

    }

    public void populateBannerData() {
        mNavHomeModeImpl.loadBannerList(this);
    }


    public void populateNewsData() {
        mNavHomeModeImpl.loadNewsList(this);
    }


    @Override
    public void onLoadBannerSuccess(int[] ints) {
        mViewRef.get().showBannerList(ints);
    }

    @Override
    public void onLoadBannerFailure(String message) {

    }

    @Override
    public void onLoadNewsSuccess(String s) {
        mViewRef.get().showMovieList(s);
    }

    @Override
    public void onLoadNewsFailure(String message) {

    }
}
