package com.sexyhair.demoimitationmovie.model;


import com.sexyhair.demoimitationmovie.bean.NewsSort;

import java.util.List;

/**
 * Created by sexyhair on 16/12/20.
 */

public interface OnLoadNewsSortListListener {
    void onLoadNewsSortListSuccess(List<NewsSort> mNewsSort);

    void onLoadNewsSortListFailure(String message);
}
