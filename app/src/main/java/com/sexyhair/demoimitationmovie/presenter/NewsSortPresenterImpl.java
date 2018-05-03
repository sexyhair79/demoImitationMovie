package com.sexyhair.demoimitationmovie.presenter;

import com.sexyhair.demoimitationmovie.bean.NewsSort;
import com.sexyhair.demoimitationmovie.common.utils.Logger;
import com.sexyhair.demoimitationmovie.model.NewsModel;
import com.sexyhair.demoimitationmovie.model.NewsModelImpl;
import com.sexyhair.demoimitationmovie.model.OnLoadNewsSortListListener;
import com.sexyhair.demoimitationmovie.model.OnLoadUserNewsSortListener;
import com.sexyhair.demoimitationmovie.view.NewsSortView;

import java.util.List;

/**
 * Created by sexyhair on 16/12/20.
 */

public class NewsSortPresenterImpl implements NewsSortPresenter, OnLoadNewsSortListListener, OnLoadUserNewsSortListener {

    private NewsSortView newsSortView = null;
    private NewsModel newsModelImpl = null;


    public NewsSortPresenterImpl(NewsSortView newsSortView) {
        this.newsSortView = newsSortView;
        newsModelImpl = new NewsModelImpl();
    }


    @Override
    public void populateNewsSortList() {
        newsModelImpl.laodNewsSortList(this);
    }


    @Override
    public void populateUserNewsSortList(String userId) {
        Logger.i(Logger.Log_NetData, "用户的新闻分类---Presenter层接受请求，调用Mode层的加载数据方法");
        newsModelImpl.loadUserNewsSortList(userId, this);
    }

    @Override
    public void submitUserNewsSortTem(NewsSort newsSort, int operationType) {

    }

//    @Override
//    public void submitUserNewsSortTem(NewsSort userNewsSortBean, int operationType) {
//        newsModelImpl.submitUserNewsSort(userNewsSortBean,operationType);
//    }

    @Override
    public void onLoadNewsSortListSuccess(List<NewsSort> mNewsSort) {
        newsSortView.showNewSortList(mNewsSort);
    }

    @Override
    public void onLoadNewsSortListFailure(String message) {

    }

    @Override
    public void onLoadUserNewsSortSuccess(List<NewsSort> newsSortList) {
        newsSortView.showUserNewsSort(newsSortList);
    }

    @Override
    public void onLoadUserNewsSortFailure(String message) {

    }
}
