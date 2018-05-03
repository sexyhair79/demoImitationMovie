package com.sexyhair.demoimitationmovie.activity.activity;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.RadioButton;

import com.sexyhair.demoimitationmovie.R;
import com.sexyhair.demoimitationmovie.bean.NewsSort;
import com.sexyhair.demoimitationmovie.common.context.AppContext;
import com.sexyhair.demoimitationmovie.common.utils.Contants;
import com.sexyhair.demoimitationmovie.common.utils.ResFileUtil;
import com.sexyhair.demoimitationmovie.components.CommonTitleView;
import com.sexyhair.demoimitationmovie.presenter.NewsSortPresenter;
import com.sexyhair.demoimitationmovie.presenter.NewsSortPresenterImpl;
import com.sexyhair.demoimitationmovie.view.NewsSortView;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sexyhair on 16/12/20.
 * 所有的新闻分类
 */

public class NewsSortActivity extends BaseActivity implements NewsSortView {

    //view
    private GridLayout userNewsSortGridLayout = null;
    private CommonTitleView title;

    //频道的
    private RadioButton newsSort_channelCommend = null;
    private GridLayout commendGridLayout = null;

    //变量
    private List<NewsSort> userNewsSortList = null;
    private NewsSortPresenter newsSortPresenter = null;

    @Override
    protected void getBundle() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null && bundle.containsKey(Contants.JumpKey.ToNewsSort)) {
            userNewsSortList = (List<NewsSort>) bundle.getSerializable(Contants.JumpKey.ToNewsSort);
        }
    }

    @Override
    protected void findViews() {
        userNewsSortGridLayout = (GridLayout) findViewById(R.id.newsSort_userNewsSort);
        newsSort_channelCommend = (RadioButton) findViewById(R.id.newsSort_channelCommend);
        commendGridLayout = (GridLayout) findViewById(R.id.newsSort_commendGridLayout);
        title = (CommonTitleView) findViewById(R.id.newsSort_title);
        ((ViewGroup.MarginLayoutParams) title.getLayoutParams()).topMargin = AppContext.screenStatusHeight;
        title.setLeftViewImg(-1);
        title.setRightViewImg(R.drawable.main_tab_home_selected);
        title.setTitleValue(R.string.newsSort_title);
    }

    @Override
    protected void initView() {
        //初始化tabLayout 和viewpager
        newsSortPresenter = new NewsSortPresenterImpl(this);
        userNewsSortGridLayout.setLayoutTransition(getLayoutTransition());
        commendGridLayout.setLayoutTransition(getLayoutTransition());
        showUserNewsSortList();
    }


    /**
     * 设置布局动画
     */
    private LayoutTransition getLayoutTransition() {
        LayoutTransition layoutTransition = new LayoutTransition();
        //设置动画时间
        layoutTransition.setDuration(500);
        //TODO：设置动画效果,参数1：动画类型，参数2：Aimator类型
//        layoutTransition.setAnimator(LayoutTransition.APPEARING, layoutTransition.getAnimator(LayoutTransition.APPEARING));
//        layoutTransition.setAnimator(LayoutTransition.CHANGE_APPEARING, layoutTransition.getAnimator(LayoutTransition.CHANGE_APPEARING));
//        layoutTransition.setAnimator(LayoutTransition.DISAPPEARING, layoutTransition.getAnimator(LayoutTransition.DISAPPEARING));
        layoutTransition.setAnimator(LayoutTransition.CHANGE_DISAPPEARING, layoutTransition.getAnimator(LayoutTransition.CHANGE_DISAPPEARING));
        return layoutTransition;

    }

    @Override
    protected void setListener() {
        super.setListener();
        title.getRightView().setOnClickListener(new View.OnClickListener() {
            long lastClick = 0;

            @Override
            public void onClick(View view) {
                if (System.currentTimeMillis() - lastClick < Contants.jumpShortTime) {
                    return;
                }
                lastClick = System.currentTimeMillis();
                Intent intent = new Intent();
                intent.putExtra(Contants.JumpKey.ToNewsSortResult, (Serializable) userNewsSortList);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    protected void populateData() {
        newsSortPresenter.populateNewsSortList();
    }

    private void showUserNewsSortList() {
        for (NewsSort userNewsSortBean : userNewsSortList) {
            addUserNewsSortGridLayout(userNewsSortBean.getId(), userNewsSortBean.getSortName());
        }
    }

    private Button getSortButton() {
        Button btn = new Button(getActivity());
        int width = (AppContext.screenWidth - (6 * ResFileUtil.getDimenByResId(R.dimen.textSize20))) / 4;
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(width,
                width / 3);
        GridLayout.LayoutParams lp = new GridLayout.LayoutParams(params);
        int margin = ResFileUtil.getDimenByResId(R.dimen.d10);
        lp.setMargins(margin, margin, margin, margin);
        btn.setLayoutParams(lp);
        btn.setBackgroundResource(R.drawable.newssort_channel_btn_selector);
        btn.setTextColor(ResFileUtil.getColorByResId(R.color.common_txt_gray));
        btn.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                ResFileUtil.getDimenByResId(R.dimen.textSize22));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userNewsSortGridLayout.removeView(view);
            }
        });
        return btn;
    }

    @Override
    public void showNewSortList(final List<NewsSort> mNewsSort) {
        for (NewsSort newsSort : mNewsSort) {
            addNewsSortGridLayout(newsSort.getId(), newsSort.getSortName());
        }
    }

    @Override
    public void showUserNewsSort(List<NewsSort> mUserNewsSortBeans) {

    }

    private class GridLayoutBtnOnClickListener implements View.OnClickListener {
        private int type = -1;

        public GridLayoutBtnOnClickListener(int type) {
            this.type = type;
        }

        @Override
        public void onClick(View view) {
            String sortName = ((Button) view).getText().toString();
            Integer id = (Integer) view.getTag();
            NewsSort bean = new NewsSort();
            bean.setSortName(sortName);
            bean.setId(id);
            switch (type) {
                case Contants.typeUserNewsSort:
                    addNewsSortGridLayout(id, sortName);
                    userNewsSortGridLayout.removeView(view);
                    if (userNewsSortList.contains(bean)) {
                        userNewsSortList.remove(bean);
                    }
                    break;
                case Contants.typeNewsSort:
                    //点击了新闻分类的所有分类，那么则
                    addUserNewsSortGridLayout(id, sortName);
                    userNewsSortList.add(bean);
                    commendGridLayout.removeView(view);
                    break;
            }
            newsSortPresenter.submitUserNewsSortTem(bean, type);
        }
    }


    private void addUserNewsSortGridLayout(int id, String sortName) {
        Button btn = getSortButton();
        btn.setText(sortName);
        btn.setTag(id);
        btn.setOnClickListener(new GridLayoutBtnOnClickListener(Contants.typeUserNewsSort));
        userNewsSortGridLayout.addView(btn);

    }

    private void addNewsSortGridLayout(int id, String sortName) {
        Button btn = getSortButton();
        btn.setText(sortName);
        btn.setTag(id);
        btn.setOnClickListener(new GridLayoutBtnOnClickListener(Contants.typeNewsSort));
        commendGridLayout.addView(btn);
    }

    @Override
    protected BaseActivity getActivity() {
        return NewsSortActivity.this;
    }

    @Override
    protected int getLayoutView() {
        return R.layout.news_sort_all;
    }

}
