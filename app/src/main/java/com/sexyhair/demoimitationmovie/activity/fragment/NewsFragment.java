package com.sexyhair.demoimitationmovie.activity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageButton;

import com.sexyhair.demoimitationmovie.R;
import com.sexyhair.demoimitationmovie.activity.activity.NewsSortActivity;
import com.sexyhair.demoimitationmovie.bean.NewsSort;
import com.sexyhair.demoimitationmovie.common.context.AppContext;
import com.sexyhair.demoimitationmovie.common.utils.ActivityUtils;
import com.sexyhair.demoimitationmovie.common.utils.Contants;
import com.sexyhair.demoimitationmovie.common.utils.Enums;
import com.sexyhair.demoimitationmovie.common.utils.Logger;
import com.sexyhair.demoimitationmovie.presenter.NewsSortPresenter;
import com.sexyhair.demoimitationmovie.presenter.NewsSortPresenterImpl;
import com.sexyhair.demoimitationmovie.view.NewsSortView;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sexyhair on 16/12/13.
 */

public class NewsFragment extends BaseFragment implements NewsSortView {
    //view的findViewById
    private TabLayout sortTabLayout;
    private ImageButton addSortBtn;
    private ViewPager viewPager;


    //变量
    private NewsViewPagerAdapter mNewsViewPagerAdapter = null;
    private long start;
    private long end;
    private List<NewsSort> mUserNewsSortBeans;

    //presenter对象
    private NewsSortPresenter mUserNewsSortPresenterImpl = null;

    @Override
    protected void findViews(View viewContainer) {
        super.findViews(viewContainer);
        sortTabLayout = (TabLayout) findViewById(R.id.news_sortList);
        addSortBtn = (ImageButton) findViewById(R.id.news_title_addSort);
        viewPager = (ViewPager) findViewById(R.id.news_viewPager);

    }

    @Override
    protected void initViews() {
        mUserNewsSortPresenterImpl = new NewsSortPresenterImpl(this);
    }


    @Override
    protected void setListener() {
        addSortBtn.setOnClickListener(new View.OnClickListener() {
            long lastClick = 0;

            @Override
            public void onClick(View view) {
                if (System.currentTimeMillis() - lastClick < Contants.jumpShortTime) {
                    return;
                }
                lastClick = System.currentTimeMillis();
                Bundle bundle = new Bundle();
                bundle.putSerializable(Contants.JumpKey.ToNewsSort, (Serializable) mUserNewsSortBeans);
                ActivityUtils.jumpToForResult(NewsFragment.this, NewsSortActivity.class, false,
                        bundle, Contants.RequestCode.userNewsSort);
                //TODO:把动画天上就可以了
//                            overridePendingTransition(R.anim.alpha_in_top,
//                                    R.anim.tran_out_top);
            }
        });
    }

    @Override
    protected void populateData() {
        Logger.i(Logger.Log_NetData, "用户的新闻分类---Fragment发起加载请求");
        start = System.currentTimeMillis();
        mUserNewsSortPresenterImpl.populateUserNewsSortList(AppContext.userId);
    }

    @Override
    public void showNewSortList(List<NewsSort> mNewsSort) {

    }


    private class NewsViewPagerAdapter extends FragmentPagerAdapter {

        public NewsViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return Enums.NewsSort.getNewsSortFragment(
                    mUserNewsSortBeans.get(position).getId());
        }

        @Override
        public int getCount() {
            return mUserNewsSortBeans.size();
        }

        //此方法用来显示tab上的名字
        @Override
        public CharSequence getPageTitle(int position) {
            return mUserNewsSortBeans.get(position).getSortName();
        }
    }

    @Override
    protected int getLayoutView() {
        return R.layout.news_fragment;
    }

    @Override
    public void showUserNewsSort(List<NewsSort> mUserNewsSortBeans) {
        Logger.i(Logger.Log_NetData, "用户的新闻分类---Fragment接受Presenter回调数据，拿到数据结果--成功并且调用view层展示");
        this.mUserNewsSortBeans = mUserNewsSortBeans;
        for (NewsSort mUserNewsSortBean : mUserNewsSortBeans) {
            sortTabLayout.addTab(sortTabLayout.newTab().setText(mUserNewsSortBean.getSortName()));
        }
        mNewsViewPagerAdapter = new NewsViewPagerAdapter(getChildFragmentManager());
        sortTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        viewPager.setAdapter(mNewsViewPagerAdapter);
        sortTabLayout.setupWithViewPager(viewPager);
        sortTabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        end = System.currentTimeMillis();
        Logger.i(Logger.Log_Utils, "时间间隔：" + (end - start));
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == getActivity().RESULT_OK) {
            if (requestCode == Contants.RequestCode.userNewsSort) {
                List<NewsSort> mUserNewsSortBeans = (List<NewsSort>) data.getSerializableExtra(Contants.JumpKey.ToNewsSortResult);
                if (mUserNewsSortBeans != null && mUserNewsSortBeans.size() > 0) {
                    Logger.e(Logger.Log_Utils, "得到回应");
                    showUserNewsSort(mUserNewsSortBeans);
                }
            }
        }


    }
}
