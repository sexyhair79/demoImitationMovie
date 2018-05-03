package com.sexyhair.demoimitationmovie.activity.activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public abstract class BaseActivity extends AppCompatActivity{


    protected abstract BaseActivity getActivity();

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            setTranslucentStatus(true);
//        }
//        SystemBarTintManager tintManager = new SystemBarTintManager(this);
//        tintManager.setStatusBarTintEnabled(true);
//        tintManager.setStatusBarTintResource(getStuteColor());//通知栏所需颜色
        setContentView(getLayoutView());

        getBundle();
        findViews();
        initView();
        setListener();
        populateData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }


    //    /**
//     * 提供状态栏色值
//     *
//     * @return
//     */
//    protected int getStuteColor(){
//        return R.color.common_bg;
//    }
//
//    private void setTranslucentStatus(boolean on) {
//        Window win = getWindow();
//        WindowManager.LayoutParams winParams = win.getAttributes();
//        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
//        if (on) {
//            winParams.flags |= bits;
//        } else {
//            winParams.flags &= ~bits;
//        }
//        win.setAttributes(winParams);
//    }
    /**
     * findViewById;
     */
    protected void findViews() {

    }
    /**
     * findViewById;
     */
    protected void initView() {

    }

    /**
     * 事件监听；
     */
    protected void setListener() {

    }

    /**
     * findViewById 和 初始化
     */
    protected void formatViews() {
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

}
