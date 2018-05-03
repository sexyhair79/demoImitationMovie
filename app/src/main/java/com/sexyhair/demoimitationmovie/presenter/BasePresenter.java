package com.sexyhair.demoimitationmovie.presenter;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by sexyhair on 18/4/23.
 * 泛型是View
 */

public class BasePresenter<V> {
    protected Reference<V> mViewRef;//view接口类型的弱引用

    /**
     * 与View建立关联
     *
     * @param view
     */
    public void attachView(V view) {
        mViewRef = new WeakReference<>(view);
    }

    /**
     * @return
     */
    protected V getView() {
        return mViewRef.get();
    }

    public boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

}
