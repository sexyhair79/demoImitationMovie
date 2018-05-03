package com.sexyhair.demoimitationmovie.presenter;

import com.sexyhair.demoimitationmovie.bean.NewsSort;

/**
 * Created by sexyhair on 16/12/20.
 * 获取所有的新闻分类
 */

public interface NewsSortPresenter {
    void populateNewsSortList();

    void populateUserNewsSortList(String userId);

    void submitUserNewsSortTem(NewsSort newsSort, int operationType);

}
