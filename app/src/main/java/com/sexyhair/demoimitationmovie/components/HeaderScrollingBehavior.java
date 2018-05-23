package com.sexyhair.demoimitationmovie.components;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.sexyhair.demoimitationmovie.R;
import com.sexyhair.demoimitationmovie.common.utils.Logger;

import java.lang.ref.WeakReference;

/**
 * Created by sexyhair on 18/5/3.
 */

public class HeaderScrollingBehavior extends CoordinatorLayout.Behavior<LinearLayout> {
    private static final String TAG = "ToolbarAlphaBehavior";
    private int offset = 0;
    private int startOffset = 0;
    private int endOffset = 0;
    private Context context;
    private WeakReference<View> dependentView;
    public HeaderScrollingBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        Logger.i(TAG,"  创建");
    }


//    @Override
//    public boolean layoutDependsOn(CoordinatorLayout parent, LinearLayout child, View dependency) {
//
//        if (dependency != null && dependency.getId() == R.id.appBarLayout) {
//            dependentView = new WeakReference<>(dependency);
//            return true;
//        }
//        return false;
//    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout,
                                       @NonNull LinearLayout child, @NonNull View directTargetChild,
                                       @NonNull View target, int axes, int type) {
        Logger.i(TAG,"  onStartNestedScroll");
        return true;

    }


    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, LinearLayout toolbar, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        Logger.i(TAG,"  onNestedScroll");
        startOffset = 0;
        endOffset = context.getResources().getDimensionPixelOffset(R.dimen.collapsed_header_height) - toolbar.getHeight();
        offset += dyConsumed;
        if (offset <= startOffset) {  //alpha为0
            toolbar.getBackground().setAlpha(0);
        } else if (offset > startOffset && offset < endOffset) { //alpha为0到255
            float precent = (float) (offset - startOffset) / endOffset;
            int alpha = Math.round(precent * 255);
            toolbar.getBackground().setAlpha(alpha);
        } else if (offset >= endOffset) {  //alpha为255
            toolbar.getBackground().setAlpha(255);
        }
    }


//    @Override
//    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull LinearLayout child, @NonNull View target,
//        int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
//        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type);
//
//        Logger.i(TAG,"  onNestedScroll");
//        startOffset = 0;
//        endOffset = context.getResources().getDimensionPixelOffset(R.dimen.collapsed_header_height) - child.getHeight();
//        offset += dyConsumed;
//        if (offset <= startOffset) {  //alpha为0
//            child.getBackground().setAlpha(0);
//        } else if (offset > startOffset && offset < endOffset) { //alpha为0到255
//            float precent = (float) (offset - startOffset) / endOffset;
//            int alpha = Math.round(precent * 255);
//            child.getBackground().setAlpha(alpha);
//        } else if (offset >= endOffset) {  //alpha为255
//            child.getBackground().setAlpha(255);
//        }
//    }

//    @Override
//    public boolean onDependentViewChanged(CoordinatorLayout parent, LinearLayout child, View dependency) {
//
//        Logger.i(TAG,"  onDependentViewChanged");
//        return super.onDependentViewChanged(parent, child, dependency);
//    }
}
