package com.sexyhair.demoimitationmovie.components;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;


import com.sexyhair.demoimitationmovie.R;
import com.sexyhair.demoimitationmovie.common.utils.Logger;

import java.lang.ref.WeakReference;

public class HeaderFloatBehavior extends CoordinatorLayout.Behavior<AppBarLayout> {
    private static final String TAG = "HeaderFloatBehavior";

    private WeakReference<View> dependentView;
    private ArgbEvaluator argbEvaluator;

    public HeaderFloatBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);

        argbEvaluator = new ArgbEvaluator();
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, AppBarLayout child, View dependency) {

        if (dependency != null && dependency.getId() == R.id.appBarLayout) {
            dependentView = new WeakReference<>(dependency);
            return true;
        }
        return false;
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout,
                                       @NonNull AppBarLayout child, @NonNull View directTargetChild,
                                       @NonNull View target, int axes, int type) {
        Logger.i(TAG,"  onStartNestedScroll");
        return true;

    }

    @Override
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout child, @NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type);
        Logger.i(TAG,"  onNestedScroll");
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, AppBarLayout child, View dependency) {
        Resources resources = getDependentView().getResources();

        final float progress = 1.0f -
                Math.abs(dependency.getTranslationY() / (dependency.getHeight() -
                        resources.getDimension(R.dimen.collapsed_header_height)));
        Logger.i(TAG,"  ty"+dependency.getTranslationY());
        Logger.i(TAG,"  dependency的高度"+dependency.getHeight());

//        // Translation
//        final float collapsedOffset = resources.getDimension(R.dimen.collapsed_float_offset_y);
//        final float initOffset = resources.getDimension(R.dimen.init_float_offset_y);
//        final float translateY = collapsedOffset + (initOffset - collapsedOffset) * progress;
//        child.setTranslationY(translateY);
//
//        // Background
//        child.setBackgroundColor((int) argbEvaluator.evaluate(
//                progress,
//                resources.getColor(R.color.colorCollapsedFloatBackground),
//                resources.getColor(R.color.colorInitFloatBackground)));
//
//        // Margins
//        final float collapsedMargin = resources.getDimension(R.dimen.collapsed_float_margin);
//        final float initMargin = resources.getDimension(R.dimen.init_float_margin);
//        final int margin = (int) (collapsedMargin + (initMargin - collapsedMargin) * progress);
//        CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) child.getLayoutParams();
//        lp.setMargins(margin, 0, margin, 0);
//        child.setLayoutParams(lp);
//
//        final float progress = 1.f -
//                Math.abs(dependency.getTranslationY() / (dependency.getHeight() -
//                        resources.getDimension(R.dimen.collapsed_header_height)));

//        Logger.i(TAG,"  dependency=="+dependency.toString());
//        dependency.setAlpha(progress);

        return true;
    }

    private View getDependentView() {
        return dependentView.get();
    }

}
