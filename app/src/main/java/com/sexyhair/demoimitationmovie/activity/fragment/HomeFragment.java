package com.sexyhair.demoimitationmovie.activity.fragment;



import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.sexyhair.demoimitationmovie.R;
import com.sexyhair.demoimitationmovie.common.context.AppContext;
import com.sexyhair.demoimitationmovie.components.bannerview.BannerView;
import com.sexyhair.demoimitationmovie.presenter.NavHomePresenter;
import com.sexyhair.demoimitationmovie.view.NavHomeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sexyhair on 18/4/19.
 */

public class HomeFragment extends MVPBaseFragment<NavHomeView, NavHomePresenter> implements NavHomeView {


    private BannerView bannerView;
//    private LinearLayout home_title_location;

    ViewPager mViewPager;
    List<Fragment> mFragments;
    Toolbar mToolbar;

    private int[] mTitles = new int[]{
            R.string.home_filesort_movie,
            R.string.home_filesort_file,
            R.string.home_filesort_variety,
            R.string.home_filesort_book

    };




    @Override
    protected NavHomePresenter createPresenter() {
        return new NavHomePresenter();
    }

    @Override
    protected void findViews(View viewContainer) {
        bannerView = (BannerView) findViewById(R.id.bannerView);

        mViewPager = (ViewPager) findViewById(R.id.viewpager);

//        home_title_location = (LinearLayout)findViewById(R.id.home_title_location);
//        home_title_location.setAlpha(0.0f);
//        getStatusHeight();
//        mToolbar = (Toolbar)findViewById(R.id.toolbar) ;
//        mToolbar.setTitle("唐嫣");
    }

    @Override
    protected void initViews() {
        setupViewPager();
    }


    private void setupViewPager() {
        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        mFragments = new ArrayList<>();
        for (int i = 0; i < mTitles.length; i++) {
            HomeSortFragment listFragment = new HomeSortFragment();
            mFragments.add(listFragment);
        }
        HomeSortAdapter adapter =
                new HomeSortAdapter(
//                        getSupportFragmentManager(),
                        getChildFragmentManager(),
                        mFragments, mTitles);


        viewPager.setAdapter(adapter);
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
//        textview.setText(result);
    }

    public class HomeSortAdapter extends FragmentPagerAdapter {

        protected List<Fragment> mFragmentList;

        protected int[] mTitles;


        public HomeSortAdapter(FragmentManager fm, List<Fragment> fragmentList, int[] mTitles) {
            super(fm);
            if (fragmentList == null) {
                fragmentList = new ArrayList<>();
            }
            this.mFragmentList = fragmentList;
            this.mTitles = mTitles;
        }

        public void add(Fragment fragment) {
            if (isEmpty()) {
                mFragmentList = new ArrayList<>();

            }
            mFragmentList.add(fragment);
        }

        @Override
        public Fragment getItem(int position) {
            //        Logger.i("BaseFragmentAdapter position=" +position);
            return isEmpty() ? null : mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return isEmpty() ? 0 : mFragmentList.size();
        }

        public boolean isEmpty() {
            return mFragmentList == null;

        }

        @Override
        public CharSequence getPageTitle(int position) {
            return getString(mTitles[position]);
        }

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