package com.sexyhair.demoimitationmovie.view;


import com.sexyhair.demoimitationmovie.bean.NewsSort;

import java.util.List;

/**
 * Created by sexyhair on 16/12/20.
 * 获取所有的新闻分类
 */

public interface NewsSortView {
    void showNewSortList(List<NewsSort> mNewsSort);

    void showUserNewsSort(List<NewsSort> mUserNewsSortBeans);

}
