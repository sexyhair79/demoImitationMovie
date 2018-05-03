package com.sexyhair.demoimitationmovie.activity.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 保证方法功能和BaseActivity是一样的
 *
 * @author wj
 */
public abstract class BaseFragment extends Fragment {

    private View viewContainer;
    protected Activity activity;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewContainer = inflater.inflate(getLayoutView(), null);

        getBundle();
        findViews(viewContainer);
        initViews();
        setListener();
        //填充数据
        populateData();
        return viewContainer;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }


    /**
     * findViewById;
     */
    protected void findViews(View viewContainer) {

    }

    /**
     * 事件监听；
     */
    protected void setListener() {

    }

    /**
     * findViewById 和 初始化
     */
    protected void initViews() {
    }

    /**
     * 提供布局文件
     *
     * @return
     */
    protected abstract int getLayoutView();

    /**
     * 获取数据
     */
    protected void populateData() {
    }

    /**
     * 获取bundle
     */
    protected void getBundle() {
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    protected View findViewById(int resId) {
        if (viewContainer != null && !(resId < 0)) {
            return viewContainer.findViewById(resId);
        }
        return null;
    }
}