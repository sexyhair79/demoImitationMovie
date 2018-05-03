package com.sexyhair.demoimitationmovie.model;

import com.sexyhair.demoimitationmovie.R;
import com.sexyhair.demoimitationmovie.common.netrequest.AppResponse;
import com.sexyhair.demoimitationmovie.common.netrequest.MovieService;
import com.sexyhair.demoimitationmovie.common.utils.Logger;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by sexyhair on 18/5/3.
 */

public class NavHomeModelImpl implements NavHomeModel {
    @Override
    public void loadBannerList(OnLoadBannerListenter loadBannerListenter) {
        int[] resIds = {R.mipmap.banner_achieve_0,
                R.mipmap.banner_achieve_2,
                R.mipmap.banner_achieve_5,
                R.mipmap.banner_achieve_3
//            R.mipmap.banner_achieve_4,
//            R.mipmap.banner_achieve_5,
//            R.mipmap.banner_achieve_1
        };
        loadBannerListenter.onLoadBannerSuccess(resIds);
    }

    @Override
    public void loadNewsList(final OnLoadNewsListenter loadNewsListenter) {
//        http://op.juhe.cn/onebox/movie/pmovie?key=d5f379dc6df91313822cde900dd2dde5&city=北京
        String url = "http://op.juhe.cn/onebox/movie/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();


        MovieService movieService = retrofit.create(MovieService.class);
        Observable<AppResponse> movieCall = movieService.getPMovies();
        movieCall.
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Subscriber<AppResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        loadNewsListenter.onLoadNewsFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(AppResponse appResponse) {
                        Logger.i(Logger.Log_NetData, appResponse.toString());
                        loadNewsListenter.onLoadNewsSuccess(appResponse.toString());
                    }
                });
    }

}
