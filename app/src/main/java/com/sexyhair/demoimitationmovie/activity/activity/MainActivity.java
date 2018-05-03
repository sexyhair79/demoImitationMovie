package com.sexyhair.demoimitationmovie.activity.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.content.res.AppCompatResources;
import android.view.View;
import android.widget.ToggleButton;

import com.sexyhair.demoimitationmovie.R;
import com.sexyhair.demoimitationmovie.activity.fragment.FindFragment;
import com.sexyhair.demoimitationmovie.activity.fragment.HomeFragment;
import com.sexyhair.demoimitationmovie.activity.fragment.MovieInfoFragment;
import com.sexyhair.demoimitationmovie.activity.fragment.MyFragment;
import com.sexyhair.demoimitationmovie.activity.fragment.NewsFragment;
import com.sexyhair.demoimitationmovie.common.utils.Contants;
import com.sexyhair.demoimitationmovie.common.utils.Logger;
import com.sexyhair.demoimitationmovie.common.utils.ResFileUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> fragmentList;
    private ViewPagerAdapter mViewPagerAdapter;


    private boolean isLogin = false;
    private int preFragmentId = -1;


    @Override
    protected void findViews() {
        tabLayout = (TabLayout) findViewById(R.id.mainTab_layout);
        viewPager = (ViewPager) findViewById(R.id.mainTab_viewPager);
//        ((ViewGroup.MarginLayoutParams) viewPager.getLayoutParams()).topMargin = AppContext.screenStatusHeight;
    }

    @Override
    protected void initView() {
        fragmentList = new ArrayList<>();
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(mViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < fragmentList.size(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
                if (i == 0) {
                    Logger.i(Logger.Log_Utils, "初始时：" + mViewPagerAdapter.getTabView(i).toString());
                }
                ToggleButton mToggleButton = mViewPagerAdapter.getTabView(i);
                tab.setCustomView(mToggleButton);
                if (mToggleButton != null) {
                    mToggleButton.setOnClickListener(new TabClickListener());
                    mToggleButton.setTag(i);
                }
            }
        }
        viewPager.setCurrentItem(0);
    }


    private class TabClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            //点击的时候切换viewpager
            long start = System.currentTimeMillis();
            int viewId = (int) view.getTag();
            viewPager.setCurrentItem(viewId);
            int count = tabLayout.getTabCount();
            for (int i = 0; i < count; i++) {
                TabLayout.Tab viewTab = tabLayout.getTabAt(i);
                ToggleButton button = (ToggleButton) viewTab.getCustomView();
                if (i == viewId) {
                    button.setChecked(true);
                } else {
                    button.setChecked(false);
                }
            }
            long end = System.currentTimeMillis();
            Logger.i(Logger.Log_Utils, "点击时间的时间间隔：" + (end - start));
        }
    }



    private class ViewPagerAdapter extends FragmentPagerAdapter {
        private ToggleButton mToggleButton = null;
        private List<Fragment> mFragmentList;
        private List<String> titles;

        private NewsFragment mNewsFragment = null;
        private MovieInfoFragment mMovieInfoFragment = null;
        private FindFragment mFindFragment = null;
        private MyFragment mMyFragment = null;
        private HomeFragment mHomeFragment = null;


        public ViewPagerAdapter(FragmentManager fm, List<Fragment> fragmentList) {
            super(fm);
            initTabFragment(fragmentList);
            this.mFragmentList = fragmentList;
        }

        private void initTabFragment(List<Fragment> fragmentList) {
            titles = new ArrayList<>();
            titles.add(ResFileUtil.getStringByResId(R.string.main_tab_home));
            titles.add(ResFileUtil.getStringByResId(R.string.main_tab_movie));
            titles.add(ResFileUtil.getStringByResId(R.string.main_tab_cinema));
            titles.add(ResFileUtil.getStringByResId(R.string.main_tab_movieshow));
            titles.add(ResFileUtil.getStringByResId(R.string.main_tab_my));
            //添加fragment
            mNewsFragment = new NewsFragment();
            mMovieInfoFragment = new MovieInfoFragment();
            mFindFragment = new FindFragment();
            mMyFragment = new MyFragment();
            mHomeFragment = new HomeFragment();
            fragmentList.add(mHomeFragment);
            fragmentList.add(mNewsFragment);
            fragmentList.add(mMovieInfoFragment);
            fragmentList.add(mFindFragment);
            fragmentList.add(mMyFragment);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        private ToggleButton getTabView(int position) {
            int resID = 0;

            switch (position) {
                case 0:
                    mToggleButton = (ToggleButton) View.inflate(getActivity(), R.layout.main_tab_togglebutton, null);
                    resID = R.drawable.main_tab_home_selector;
                    break;
                case 1:
                    mToggleButton = (ToggleButton) View.inflate(getActivity(), R.layout.main_tab_togglebutton, null);
                    resID = R.drawable.main_tab_movie_selector;
                    break;
                case 2:
                    mToggleButton = (ToggleButton) View.inflate(getActivity(), R.layout.main_tab_togglebutton, null);
                    resID = R.drawable.main_tab_vedio_selector;
                    break;
                case 3:
                    mToggleButton = (ToggleButton) View.inflate(getActivity(), R.layout.main_tab_togglebutton, null);
                    resID = R.drawable.main_tab_movieinfo_selector;
                    break;
                case 4:
                    mToggleButton = (ToggleButton) View.inflate(getActivity(), R.layout.main_tab_togglebutton, null);
                    resID = R.drawable.main_tab_person_selector;
                    break;
            }
            formatToggleButtonTab(mToggleButton, resID, titles.get(position));
            return mToggleButton;
        }

        /**
         * @param toggle
         * @param resId
         */
        private void formatToggleButtonTab(ToggleButton toggle, int resId, String txt) {
            int width = ResFileUtil.getDimenByResId(R.dimen.d40);
            int height = ResFileUtil.getDimenByResId(R.dimen.d40);
            int padding = ResFileUtil.getDimenByResId(R.dimen.d1);
            Drawable drawable = AppCompatResources.getDrawable(getActivity(), resId);
            if (drawable != null) {
                drawable.setBounds(0, 0, width, height);
                toggle.setCompoundDrawables(null, drawable, null, null);
//                toggle.setCompoundDrawablePadding(padding);
            }
            toggle.setTextOff(txt);
            toggle.setTextOn(txt);
            toggle.setText(txt);
        }


        //此方法用来显示tab上的名字
//        @Override
//        public CharSequence getPageTitle(int position) {
//            return titles.get(position % titles.size());
//        }
//
//
    }

    @Override
    protected void setListener() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Logger.d(Logger.Log_Utils, "onPageScrolled()方法");
            }

            @Override
            public void onPageSelected(int position) {
                Logger.d(Logger.Log_Utils, "onPageSelected()方法");
                if (position == 3) {
                    if (!isLogin) {
//                        ActivityUtils.jumpToForResult(getActivity(), LoginActivity.class, false, Contants.RequestCode.mainToUserLogin);
//                        viewPager.setCurrentItem(preFragmentId);
                    } else {

                    }
                } else {
                    preFragmentId = position;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Logger.d(Logger.Log_Utils, "onPageScrollStateChanged()方法");

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int myId = 3;
        if (requestCode == Contants.RequestCode.mainToUserLogin) {
            if (resultCode == RESULT_OK) {
                TabLayout.Tab viewTab = tabLayout.getTabAt(preFragmentId);
                ToggleButton button = (ToggleButton) viewTab.getCustomView();
                button.setChecked(false);
                isLogin = true;
                viewPager.setCurrentItem(myId);
                preFragmentId = myId;
            } else {
                TabLayout.Tab viewTab = tabLayout.getTabAt(myId);
                ToggleButton button = (ToggleButton) viewTab.getCustomView();
                button.setChecked(false);
            }
        }
    }


    @Override
    protected int getLayoutView() {
        return R.layout.activity_main;
    }

    @Override
    protected BaseActivity getActivity() {
        return MainActivity.this;
    }

}
