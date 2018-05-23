package com.sexyhair.demoimitationmovie.components.bannerview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import com.sexyhair.demoimitationmovie.R;

/**
 * Created by sexyhair on 18/5/3.
 */

public class MyToolBar extends Toolbar {

    public MyToolBar(Context context) {
        this(context,null);
    }

    public MyToolBar(Context context, @Nullable AttributeSet attrs) {
        this(context,null,0);
    }

    public MyToolBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
    private void init(Context context){
        LayoutInflater.from(getContext()).inflate(R.layout.layout_title_location, this);
    }
}
