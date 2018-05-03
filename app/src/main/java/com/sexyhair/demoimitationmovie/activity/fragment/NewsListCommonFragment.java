package com.sexyhair.demoimitationmovie.activity.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.sexyhair.demoimitationmovie.R;
import com.sexyhair.demoimitationmovie.activity.adapter.NewsListAdapter;
import com.sexyhair.demoimitationmovie.bean.News;
import com.sexyhair.demoimitationmovie.presenter.NewsListPresenter;
import com.sexyhair.demoimitationmovie.presenter.NewsListPresenterImpl;
import com.sexyhair.demoimitationmovie.view.NewsListView;

import java.util.List;

/**
 * Created by sexyhair on 16/12/15.
 * 所有新闻列表的样式相同的fragment
 * http://123.57.14.118:18084/api/activity/get?page=1&pagesize=10
 */

public class NewsListCommonFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, NewsListView {
    private static final String key = "newsSortId";
    private RecyclerView recyclerView = null;
    private SwipeRefreshLayout swipeRefresh = null;
    private NewsListAdapter newsListAdapter = null;
    private NewsListPresenter newsListPresenter = null;

    @Override
    protected void findViews(View viewContainer) {
        recyclerView = (RecyclerView) findViewById(R.id.newsComFrag_recyclerView);
        swipeRefresh = (SwipeRefreshLayout) findViewById(R.id.newsComFrag_swipeRefreshLayout);
    }

    @Override
    protected void initViews() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(layoutManager);
        newsListAdapter = new NewsListAdapter(activity);
        recyclerView.setAdapter(newsListAdapter);
        newsListPresenter = new NewsListPresenterImpl(this);
    }

    @Override
    protected void setListener() {
        swipeRefresh.setOnRefreshListener(this);
    }

    @Override
    protected void populateData() {
        newsListPresenter.popularNewsList(this.getArguments().getInt(key));
    }


    public static NewsListCommonFragment newInstance(int newsSortId) {
        Bundle bundle = new Bundle();
        NewsListCommonFragment fragment = new NewsListCommonFragment();
        bundle.putInt(key, newsSortId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutView() {
        return R.layout.news_common_fragment;
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void showNewsList(List<News> newsList) {
        newsListAdapter.notifyData(newsList);
    }
}
