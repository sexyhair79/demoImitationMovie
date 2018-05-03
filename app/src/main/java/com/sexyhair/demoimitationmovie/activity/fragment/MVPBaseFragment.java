package com.sexyhair.demoimitationmovie.activity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sexyhair.demoimitationmovie.presenter.BasePresenter;

/**
 * 保证方法功能和BaseActivity是一样的
 *
 * @author wj
 */
public abstract class MVPBaseFragment<V, T extends BasePresenter<V>> extends BaseFragment {

    protected T mPresenter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);
        View viewContainer = super.onCreateView(inflater, container, savedInstanceState);

        return viewContainer;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.detachView();
    }

    protected abstract T createPresenter();


}