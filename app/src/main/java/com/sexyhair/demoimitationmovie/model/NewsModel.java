package com.sexyhair.demoimitationmovie.model;


import com.sexyhair.demoimitationmovie.bean.NewsSort;

/**
 * Created by sexyhair on 16/12/15.
 *
 */

public interface NewsModel {
    /**
     *加载 用户已经选择了的新闻分类。
     */
    void loadUserNewsSortList(String userId, OnLoadUserNewsSortListener onLoadUserNewsSortListener);

    /**
     * 加载新闻分类列表
     */
    void laodNewsSortList(OnLoadNewsSortListListener onLoadNewsSortListListener);

    /**
     * 某条新闻的详情页
     */
    void loadNewsDetail();

    /**
     * 加载某新闻分类下的新闻列表
     * TODO：应该是从本地数据库拿的数据
     */
    void loadNewsList(int newsSortId, OnLoadNewsListListener onLoadNewsListListener);

    /**
     * 提交用户选泽的新闻分类
     */
    void submitUserNewsSort(NewsSort userSort, int operationType);
}
