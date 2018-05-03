package com.sexyhair.demoimitationmovie.presenter;

import com.sexyhair.demoimitationmovie.bean.News;
import com.sexyhair.demoimitationmovie.model.NewsModelImpl;
import com.sexyhair.demoimitationmovie.model.OnLoadNewsListListener;
import com.sexyhair.demoimitationmovie.view.NewsListView;

import java.util.List;

/**
 * Created by sexyhair on 16/12/27.
 */

public class NewsListPresenterImpl implements NewsListPresenter ,OnLoadNewsListListener {
    private NewsListView newsListView = null;
    private NewsModelImpl newsModel = null;

    public NewsListPresenterImpl(NewsListView newsListView) {
        this.newsListView = newsListView;
        newsModel = new NewsModelImpl();
    }

    @Override
    public void popularNewsList(int newsSortId) {

        newsModel.loadNewsList(newsSortId,this);
    }

    @Override
    public void onLoadNewsListSuccess(List<News> newsList) {
        newsListView.showNewsList(newsList);
//        newsListView.showNewsList(newsList);
    }


    @Override
    public void onLoadNewsListFailure(String message) {

    }
}
