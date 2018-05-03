package com.sexyhair.demoimitationmovie.model;

/**
 * Created by sexyhair on 18/5/3.
 */

public interface NavHomeModel {
    void loadBannerList(OnLoadBannerListenter loadBannerListenter);

    void loadNewsList(OnLoadNewsListenter loadNewsListenter);


    interface OnLoadBannerListenter<T> {
        void onLoadBannerSuccess(T t);

        void onLoadBannerFailure(String message);
    }


    interface OnLoadNewsListenter<T> {
        void onLoadNewsSuccess(T t);

        void onLoadNewsFailure(String message);
    }


}
