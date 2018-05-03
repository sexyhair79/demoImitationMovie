package com.sexyhair.demoimitationmovie.components.bannerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ViewFlipper;

import com.sexyhair.demoimitationmovie.R;
import com.sexyhair.demoimitationmovie.common.utils.Logger;

import java.util.List;

/**
 * 用于banner 的轮播
 *
 * @author wj <br/>
 *         <p>
 *         <p>
 *         分析：
 *         1-图片来源，是否带有提示标
 *         本地+带提示标
 *         本地+不带提示标
 *         网络+带提示
 *         网络+不带提示
 *         <p>
 *         ViewFlipper类的特性和一些基本方法 :<br/>
 *         setOutAnimation: 设置View退出屏幕时候使用的动画，参数setInAnimation函数一样。<br/>
 *         showNext： 调用该函数来显示FrameLayout里面的下一个View。<br/>
 *         showPrevious： 调用该函数来显示FrameLayout里面的上一个View。<br/>
 *         isFlipping： 用来判断View切换是否正在进行.<br/>
 *         setFilpInterval：设置View之间切换的时间间隔.<br/>
 *         startFlipping：使用上面设置的时间间隔来开始切换所有的View，切换会循环进行.<br/>
 *         stopFlipping: 停止View切换.<br/>
 *         setAutoStart(boolean isauto):设置自动播放功能（点击事件，前自动播放） .<br/>
 *         </p>
 *         <p>
 *         TranslateAnimation动画： <br/>
 *         float fromXDelta 动画开始的点离当前View X坐标上的差值 。<br/>
 *         float toXDelta 动画结束的点离当前View X坐标上的差值 。<br/>
 *         float fromYDelta 动画开始的点离当前View Y坐标上的差值 。<br/>
 *         float toYDelta 动画开始的点离当前View Y坐标上的差值 。<br/>
 *         <p>
 *         代码如下:。<br/>
 *         animation.setDuration(long durationMillis);//设置动画持续时间 。<br/>
 *         animation.setRepeatCount(int i);//设置重复次数 。<br/>
 *         animation.setRepeatMode(Animation.REVERSE);//设置反方向执行 。<br/>
 *         <p>
 *         Xml属性： 代码如下:。<br/>
 *         android:duration：运行动画的时间 。<br/>
 *         android:repeatCount：定义动画重复的时间 。<br/>
 *         </p>
 *         <p>
 *         <p>
 *         <p>
 *         API:<br/>
 *         1,void setBannerAutoFling(boolean isAutoFling) 是否自动轮播，默认true。<br/>
 *         <p>
 *         2,void setBannerCircleBottomMargin(int bottom) 设置banner中的圆点的下margin。<br/>
 *         <p>
 *         3,void setBannerCircleBottomRight(int bottom, int right)
 *         设置banner中的圆点的下margin 和 右margin。<br/>
 *         <p>
 *         4,void setBannerCircleCurrentDrawable(int resId) 设置 圆点的选中图片。<br/>
 *         <p>
 *         5,void setBannerCircleDefaultDrawable(int resId) 设置 圆点的默认图片。<br/>
 *         <p>
 *         <p>
 *         <p>
 *         <p>
 *         9,void setBannerCircleGravity(int gravity) 设置circle的位置的。<br/>
 *         <p>
 *         10,void setBannerCircleLeftMargin(int left) 设置banner中的圆点的左侧margin。<br/>
 *         <p>
 *         11,void setBannerCircleRightMargin(int right) 设置banner中的圆点的右margin。<br/>
 *         <p>
 *         12, void setBannerCircleTopMargin(int top) 设置banner中的圆点的上margin。<br/>
 *         <p>
 *         <p>
 *         <p>
 *         <p>
 *         <p>
 *         15,void setBannerDefaultDrawable(Drawable bannerDefaultDrawable)
 *         设置banner默认的图片。<br/>
 *         16,void setBannerDefaultDrawable(int resId) 设置banner默认的图片。<br/>
 *         <p>
 *         17,void setBannerScaleType(ScaleType mScaleType) 设置banner图片的拉伸格式。<br/>
 *         <p>
 *         18,void setBannerShowCircle(boolean isShowCircle) 设置是否显示圆点。<br/>
 *         <p>
 *         19,void setOnBannerListener(OnBannerListener OnBannerListener) 点击事件。<br/>
 *         <p>
 *         20, void startBannerAnimation(int[] resIds) 启动banner轮播 本地的路径 。<br/>
 *         <p>
 *         21, void startBannerAnimation(List<Integer> resIds) 启动banner轮播 本地的路径
 *         。<br/>
 *         <p>
 *         22,void startBannerAnimation(List<String> picUrls, ImageLoader
 *         mImageLoader) 启动banner轮播 网络路径 。<br/>
 *         <p>
 *         23,void startBannerAnimation(String[] picUrls, ImageLoader
 *         mImageLoader) 启动banner轮播 网络路径 。<br/>
 */
public class BannerView extends ViewFlipper implements OnGestureListener {

    private Context context;
    // 手势判断的标准
    private int verticalMinDistance = 20;
    private int minVelocity = 0;
    // 时间间隔
    private int animationTime = 5000;
    private GestureDetector detector;
    // 当前执行onSingleUP时View的tag,也就是位置。
    private int clickPosition = -1;
    // 是否自动轮播
    protected boolean isAutoFling = true;
    // 是否手势滑动到上一个，现在是手势向右滑动后，所有动画都烦了，应该只有手动向右时动画才是向右的，其他一切向左；
    private Boolean isAutoPre = false;
    // 关于CircleFlowIndicator的
    // 这个View中有多少个圈
    private int number = 0;
    // 默认状态下的图标
//    private Drawable defaultResDrawable = null;
    // 当前状态下的图标
//    private Drawable currentResDrawable = null;
    // 两个点之间的间距

    // 设置图片的默认的拉伸格式，null： 代表不拉伸
    private ScaleType scaleType = ScaleType.FIT_XY;
    // 是否有拉伸格式
    private boolean isScaleType = true;
    // banner的默认图,只有是网络图片的时候才会用到
    private Drawable bannerDefaultDrawable = null;

    // 默认是右下
    private int gravity = Gravity.BOTTOM;
//    private Context context = null;

    private void init(Context context, AttributeSet attrs) {
        this.context = context;
        detector = new GestureDetector(context, this);
        TypedArray array = context.obtainStyledAttributes(attrs,
                R.styleable.BannerView);

//        currentResDrawable = array
//                .getDrawable(R.styleable.BannerView_bannerCircleSrcCurrent);
//        defaultResDrawable = array
//                .getDrawable(R.styleable.BannerView_bannerCircleSrcDefault);
        bannerDefaultDrawable = array
                .getDrawable(R.styleable.BannerView_bannerDefaultDrawable);


        isAutoFling = array.getBoolean(R.styleable.BannerView_bannerAutoFling,
                true);
        gravity = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
        // 因为circleFlowIndicator是有默认值得，所以这个是不需要默认值得；
    }


    /**
     * 获取子View 本地图片，无圆点
     *
     * @param resId
     * @param index 用于点击事件里的
     */
    private View getBannerChildView(int resId, int index) {
        ImageView img = new ImageView(getContext());
        img.setImageResource(resId);
        formatImageView(img);
        img.setTag(index);
        return img;
    }


    /**
     * 格式化本地的ImageView
     *
     * @param img
     */
    private void formatImageView(ImageView img) {
        if (isScaleType) {
            img.setScaleType(scaleType);
        }
    }


    /**
     * 设置动画
     */
    private void setAnimation() {
        if (isAutoFling) {
            this.startFlipping();
        }
        this.setFlipInterval(animationTime);
        this.setInAnimation(AnimationUtils.loadAnimation(context,
                R.anim.banner_left_in));
        this.setOutAnimation(AnimationUtils.loadAnimation(context,
                R.anim.banner_left_out));
        // this.setInAnimation(getInAnimation());
        // this.setOutAnimation(getOutAnimation());
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.detector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent arg0) {
        return true;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                           float velocityY) {
        if (e1.getX() - e2.getX() > verticalMinDistance
                && Math.abs(velocityX) > minVelocity) { // 向左手势
            this.setInAnimation(AnimationUtils.loadAnimation(context,
                    R.anim.banner_left_in));
            this.setOutAnimation(AnimationUtils.loadAnimation(context,
                    R.anim.banner_left_out));
            this.showNext();
            return true;
        } else if (e2.getX() - e1.getX() > verticalMinDistance
                && Math.abs(velocityX) > minVelocity) { // 向右手势
            this.setInAnimation(AnimationUtils.loadAnimation(context,
                    R.anim.banner_right_in));
            this.setOutAnimation(AnimationUtils.loadAnimation(context,
                    R.anim.banner_right_out));
            isAutoPre = true;
            this.showPrevious();
            return true;
        }
        return false;
    }

    @Override
    public void onLongPress(MotionEvent arg0) {

    }

    @Override
    public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2,
                            float arg3) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent arg0) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent arg0) {
        // 这是一定不会等于null的 除非无banner
        if (getCurrentView() != null && getCurrentView().getTag() != null) {
            clickPosition = (Integer) getCurrentView().getTag();
            if (mOnBannerListener != null) {
                mOnBannerListener.OnBannerListener(clickPosition);
            }
        } else {
            Logger.i(Logger.Log_View, "BannerView.java--操作错误");
        }
        return false;
    }

    @Override
    public void showNext() {
        if (isAutoPre) {
            isAutoPre = false;
            this.setInAnimation(AnimationUtils.loadAnimation(context,
                    R.anim.banner_left_in));
            this.setOutAnimation(AnimationUtils.loadAnimation(context,
                    R.anim.banner_left_out));
        }
        super.showNext();
    }

    public BannerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public BannerView(Context context) {
        super(context);
        init(context, null);
    }

    private OnBannerListener mOnBannerListener;

    /**
     * 点击事件
     *
     * @param OnBannerListener
     */
    public void setOnBannerListener(OnBannerListener OnBannerListener) {
        this.mOnBannerListener = OnBannerListener;
    }

    public interface OnBannerListener {
        public void OnBannerListener(int position);
    }


    /**
     * 设置banner图片的拉伸格式
     *
     * @param mScaleType
     */
    public void setBannerScaleType(ScaleType mScaleType) {
        if (mScaleType == null) {
            isScaleType = false;
        }
        this.scaleType = mScaleType;
    }


    /**
     * 设置banner默认的图片
     *
     * @param resId 资源id
     */
    public void setBannerDefaultDrawable(int resId) {
        if (resId < 0) {
            return;
        }
        bannerDefaultDrawable = getResources().getDrawable(resId);
    }

    /**
     * 设置banner默认的图片
     *
     * @param bannerDefaultDrawable
     */
    public void setBannerDefaultDrawable(Drawable bannerDefaultDrawable) {
        if (bannerDefaultDrawable != null) {
            return;
        }
        this.bannerDefaultDrawable = bannerDefaultDrawable;
    }


    /**
     * 是否自动轮播，默认true
     *
     * @param isAutoFling
     */
    public void setBannerAutoFling(boolean isAutoFling) {
        this.isAutoFling = isAutoFling;
    }


    /**
     * 启动banner轮播 本地的路径
     *
     * @param resIds 集合
     */
    public void startBannerAnimation(List<Integer> resIds) {
        if (resIds == null || resIds.size() <= 0) {
            Logger.w(Logger.Log_View,
                    "BannerView--startBannerAnimation(int[] resIds)参数错误");
            return;
        }

        this.number = resIds.size();
        for (int i = 0; i < resIds.size(); i++) {
            this.addView(getBannerChildViewCircle(resIds.get(i), i));
        }

        setAnimation();
    }


    /**
     * 启动banner轮播 本地的路径
     *
     * @param resIds
     */
    public void startBannerAnimation(int[] resIds) {


        this.number = resIds.length;
        for (int i = 0; i < resIds.length; i++) {
            this.addView(getBannerChildViewCircle(resIds[i], i));
        }


        setAnimation();
    }


    /**
     * 获取子View 本地图片，有圆点
     *
     * @param resId
     * @param index 用于点击事件里的
     */
    private ImageView getBannerChildViewCircle(int resId, int index) {

        ImageView img = new ImageView(getContext());
        img.setImageDrawable(AppCompatResources.getDrawable(context, resId));
//        img.setImageResource(resId);
        formatImageView(img);

        return img;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        setMeasuredDimension(widthMeasureSpec, 300);
    }
}
