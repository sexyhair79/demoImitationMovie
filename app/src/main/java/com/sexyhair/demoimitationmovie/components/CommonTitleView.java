package com.sexyhair.demoimitationmovie.components;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sexyhair.demoimitationmovie.R;
import com.sexyhair.demoimitationmovie.common.utils.ResFileUtil;

/**
 * Created by sexyhair on 16/12/21.
 */

public class CommonTitleView extends LinearLayout {
    private View view = null;
    private ImageButton left = null;
    private ImageButton right = null;
    private TextView title = null;


    public CommonTitleView(Context context) {
        super(context);
        initView();
    }

    public CommonTitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public CommonTitleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public CommonTitleView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        view = View.inflate(getContext(), R.layout.view_common_title, this);
        left = (ImageButton) view.findViewById(R.id.commonTitle_left);
        right = (ImageButton) view.findViewById(R.id.commonTitle_right);
        title = (TextView) view.findViewById(R.id.commonTitle_title);
    }

    public ImageView getLeftView() {
        return left;
    }

    public ImageButton getRightView() {
        return right;
    }

    public TextView getTitleView() {
        return title;
    }

    public void setLeftViewImg(int ResId) {
        left.setImageResource(ResId);
    }

    public void setRightViewImg(int ResId) {
        right.setImageResource(ResId);
    }

    public void setTitleValue(int ResId) {
        title.setText(ResFileUtil.getStringByResId(ResId));
    }

//    public void setTitleValue(String title){
//        if(TextUtils.isEmpty(title)){
//            title.setText(title);
//        }
//    }

}
