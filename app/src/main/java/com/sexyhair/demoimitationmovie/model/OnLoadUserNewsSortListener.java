package com.sexyhair.demoimitationmovie.model;


import com.sexyhair.demoimitationmovie.bean.NewsSort;

import java.util.List;

/**
 * Created by sexyhair on 16/12/15.
 * 用户选择的新闻分类的回调接口
 */

public interface OnLoadUserNewsSortListener {
    void onLoadUserNewsSortSuccess(List<NewsSort> newsSortList);

    void onLoadUserNewsSortFailure(String message);

}
