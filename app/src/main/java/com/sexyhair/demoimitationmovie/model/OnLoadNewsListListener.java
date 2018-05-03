package com.sexyhair.demoimitationmovie.model;

import com.sexyhair.demoimitationmovie.bean.News;

import java.util.List;

/**
 * Created by sexyhair on 16/12/27.
 */

public interface OnLoadNewsListListener {
    void onLoadNewsListSuccess(List<News> newsList);

    void onLoadNewsListFailure(String message);
}
