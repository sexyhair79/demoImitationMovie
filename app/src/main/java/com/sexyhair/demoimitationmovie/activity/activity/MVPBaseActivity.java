package com.sexyhair.demoimitationmovie.activity.activity;


import android.os.Bundle;

import com.sexyhair.demoimitationmovie.presenter.BasePresenter;

/**
 * @param <V> view
 * @param <T> presenter
 */
public abstract class MVPBaseActivity<V, T extends BasePresenter<V>> extends BaseActivity {

    private T mPresenter;

    protected abstract MVPBaseActivity getActivity();

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    protected abstract T createPresenter();


}
