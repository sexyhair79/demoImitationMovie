package com.sexyhair.demoimitationmovie.components.bannerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import com.sexyhair.demoimitationmovie.common.utils.Logger;


/**
 * 广告位那的标示
 *
 * @author wj
 *         <p>
 *         <p>
 *         关于：getResources().getDrawable(R.drawable.blueball1).mutate();中的mutate(
 *         )方法。<br/>
 *         http://blog.sina.com.cn/s/blog_4a0238270101ggal.html<br/>
 *         <p>
 *         注意： 自定义View中，onDraw出来的 extends View inflate.laayout的extends 容器
 *         <p>
 *         注意：给此view设置padding是不好使的，还有就是此View的高度智能是求的宽度。设置高度是无效的。
 *         <p>
 *         API:
 *         Indicator
 */
public class BannerIndicatorView extends View {

    // 如果没有特殊设定的话，默认是5个；不同项目需要不同的默认值的话，只需要更改这个就可以了。
    private final int INDICATOR_COUNT = 0;
    // 默认的宽高，设置的不能低于这个
    private final int WIDTH_MIN = 2;
    // 默认的宽高，设置的不能低于这个
    private final int WIDTH_MAX = 2000;
    // 默认的间距，设置的不能低于这个
    private final int GAP_MIN = 0;
    // 默认的间距，设置的不能低于这个
    private final int GAP_MAX = 720;
    // 这个View中有多少个圈
    private int number = -1;
    // 默认状态下的图标
    private Drawable defaultResDrawable = null;
    // 当前状态下的图标
    private Drawable currentResDrawable = null;
    // 当前选中的图标的位置。默认是第一个从0 开始；
    private int currentIndex = 1;
    // 两个点之间的间距,默认是5
    private int circleGap = 40;
    private int circleWidth = 0;
    private int circleHight = 0;

    /**
     * 得到相关的属性 初始化
     *
     * @param context
     * @param attrs
     */
    private void init(Context context, AttributeSet attrs) {
        // 设置默认值
        if (number == -1) {
            number = INDICATOR_COUNT;
        }
        if (circleGap == 0) {
            circleGap = GAP_MIN;
        }
        if (circleWidth == 0) {
            circleWidth = WIDTH_MIN;
        }
        if (circleHight == 0) {
            circleHight = WIDTH_MIN;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (defaultResDrawable == null || currentResDrawable == null) {
            Logger.i(Logger.Log_View,
                    "CircleFlowIndicator.java -----图标传入失败");
            return;
        }
        if (currentIndex >= number) {
            // 逻辑错误
            Logger.i(Logger.Log_View,
                    "CircleFlowIndicator.java -----逻辑错误");
            return;
        }
        for (int i = 0; i < number; i++) {
            Drawable drawable = null;
            if (currentIndex == i) {
                drawable = currentResDrawable;
            } else {
                drawable = defaultResDrawable;
            }
            int left = i * (circleWidth + circleGap);
            drawable.setBounds(left, 0, left + circleWidth, 0 + circleWidth);
            drawable.draw(canvas);
        }

    }

    @SuppressLint("NewApi")
    public BannerIndicatorView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    public BannerIndicatorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public BannerIndicatorView(Context context) {
        super(context);
        init(context, null);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //没有padding 设置padding无效
        int minWidth = number * circleWidth + circleGap * (number - 1);
        int maxWidth = View.resolveSize(minWidth, widthMeasureSpec);
        int maxHeight = View.resolveSize(circleHight, widthMeasureSpec);
        setMeasuredDimension(maxWidth, maxHeight);
    }

    /**
     * 设置每一个圆的宽高
     *
     * @param width
     */
    public void setCircleFlowWidth(int width, int height) {
        if (width < WIDTH_MIN) {
            return;
        }
        if (width > WIDTH_MAX) {
            return;
        }

        if (height < WIDTH_MIN) {
            return;
        }
        if (height > WIDTH_MAX) {
            return;
        }
        this.circleWidth = width;
        this.circleHight = width;
        invalidate();
    }

    /**
     * 设置每一个圆的间距
     */
    public void setCircleFlowGap(int gap) {
        if (gap < GAP_MIN) {
            return;
        }
        if (gap > GAP_MAX) {
            return;
        }
        this.circleGap = gap;
        invalidate();
    }

    /**
     * 设置每一个圆的宽宽高
     *
     * @param width
     */
    public void setIndicatorWidthAndHight(int width, int hight) {
        if (hight < WIDTH_MIN) {
            return;
        }
        if (hight > WIDTH_MAX) {
            return;
        }
        if (width < WIDTH_MIN) {
            return;
        }
        if (width > WIDTH_MAX) {
            return;
        }
        this.circleWidth = width;
        this.circleHight = hight;
        invalidate();
    }


    /**
     * 设置圆的数量
     */
    public void setCircleFlowNumber(int number) {
        if (number < 0) {
            return;
        }
        if (number > 100) {
            return;
        }
        this.number = number;
        invalidate();
    }

    /**
     * 设置圆的当前位置
     */
    public synchronized void setCircleFlowIndex(int index) {
        if (index < 0 || index > number) {
            return;
        }
        this.currentIndex = index;
//		requestLayout();
        invalidate();
    }

    /**
     * 设置 圆的选中图片
     *
     * @param resId
     */
    public void setCircleFlowCurrentDrawable(int resId) {
        if (resId < 0) {
            return;
        }
        currentResDrawable = getResources().getDrawable(resId);
        invalidate();
    }

    /**
     * 设置 圆的默认图片
     *
     * @param resId
     */
    public void setCircleFlowDefaultDrawable(int resId) {
        if (resId < 0) {
            return;
        }
        defaultResDrawable = getResources().getDrawable(resId);
        invalidate();
    }

    /**
     * 设置 圆的选中和默认图片
     *
     * @param currentResId 选中图片
     * @param defaultResId 默认图片
     */
    public void setCircleFlowDrawable(int currentResId, int defaultResId) {
        if (currentResId < 0 || defaultResId < 0) {
            return;
        }
        defaultResDrawable = getResources().getDrawable(defaultResId);
        currentResDrawable = getResources().getDrawable(currentResId);
        invalidate();
    }

    /**
     * 设置 圆的默认图片
     *
     * @param defaultResDrawable
     */
    public void setCircleFlowDefaultDrawable(Drawable defaultResDrawable) {
        if (defaultResDrawable == null) {
            return;
        }
        this.defaultResDrawable = defaultResDrawable;
        invalidate();
    }

    /**
     * 设置 圆的选中图片
     *
     * @param currentResDrawable
     */
    public void setCircleFlowCurrentDrawable(Drawable currentResDrawable) {
        if (currentResDrawable == null) {
            return;
        }
        this.currentResDrawable = currentResDrawable;
        invalidate();
    }

    /**
     * 设置 圆的选中和默认图片
     *
     * @param currentResDrawable 选中图片
     * @param defaultResDrawable 默认图片
     */
    public void setCircleFlowDrawable(Drawable currentResDrawable, Drawable defaultResDrawable) {
        if (currentResDrawable == null || defaultResDrawable == null) {
            return;
        }
        this.defaultResDrawable = defaultResDrawable;
        this.currentResDrawable = currentResDrawable;
        invalidate();
    }

}
