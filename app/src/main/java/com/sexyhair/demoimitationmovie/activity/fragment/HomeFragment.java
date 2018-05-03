package com.sexyhair.demoimitationmovie.activity.fragment;


import android.view.View;
import android.widget.TextView;

import com.sexyhair.demoimitationmovie.R;
import com.sexyhair.demoimitationmovie.components.bannerview.BannerView;
import com.sexyhair.demoimitationmovie.presenter.NavHomePresenter;
import com.sexyhair.demoimitationmovie.view.NavHomeView;

/**
 * Created by sexyhair on 18/4/19.
 */

public class HomeFragment extends MVPBaseFragment<NavHomeView, NavHomePresenter> implements NavHomeView {

    private TextView textview;
    private BannerView bannerView;


    @Override
    protected NavHomePresenter createPresenter() {
        return new NavHomePresenter();
    }

    @Override
    protected void findViews(View viewContainer) {
        bannerView = (BannerView) findViewById(R.id.bannerView);
        textview = (TextView) findViewById(R.id.textview);

    }


    @Override
    protected void initViews() {
    }


    @Override
    protected void populateData() {
        super.populateData();
        mPresenter.populateBannerData();
        mPresenter.populateNewsData();

    }

    @Override
    public void showBannerList(int[] resIds) {
        bannerView.startBannerAnimation(resIds);
    }

    @Override
    public void showMovieList(String result) {
        textview.setText(result);
    }


    @Override
    protected int getLayoutView() {
        return R.layout.fragment_nav_home;
    }


}


//    /**
//     * 给banner设置属性 使用此banner需要的其他设置： res/anim/banner_left_in.xml。<br/>
//     * res/anim/banner_left_out.xml。<br/>
//     * res/anim/banner_right_in.xml。<br/>
//     * res/anim/banner_right_out.xml。<br/>
//     * 和CircleFlowIndicatorView
//     * <p>
//     * demo中 属性和方法是同时都有的，但是代码是后加上去的，所以一代码为准的，要是看xml中的效果，把对应的方法注释即可。
//     */
//    private void formatBanner() {
//
//
//
//
////        /**
////         * 是否自动轮播。<br/>
////         * 对应属性：bannerAutoFling。<br/>
////         * 方法测试可用。验证右下<br/>
////         * 属性测试可用。验证右下<br/>
////         */
////        bannerView.setBannerAutoFling(true);
////        // 这个网络路径
////        String[] paths = new String[]{
////                "http://image.zsoftware.cn/clnuurccndmxmjqzntiwnjc1otg3ndu2/2016/932e5ab732c5402d900b6d42ec9446d8",
////                "http://image.zsoftware.cn/clnuurccndmxmjqzntiwnjc1otg3ndu2/2016/3142ebfde4d2440ba9d228c4500319e2",
////                "http://image.zsoftware.cn/clnuurccndmxmjqzntiwnjc1otg3ndu2/2015/557a3c89df284c638cfa34c2c2c8b4f4"};
//
//
//    }

//        movieCall.enqueue(new Callback<AppResponse>() {
//            @Override
//            public void onResponse(Call<AppResponse> call, Response<AppResponse> response) {
//                Logger.i(Logger.Log_NetData ,response.body().getResult().toString());
////                textView.setText(response.body().getResult().toString());
//            }
//
//            @Override
//            public void onFailure(Call<AppResponse> call, Throwable t) {
//                Logger.i(Logger.Log_NetData ,"异常");
//            }
//        });