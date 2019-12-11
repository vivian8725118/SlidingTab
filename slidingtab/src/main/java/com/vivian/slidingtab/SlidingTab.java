package com.vivian.slidingtab;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

/**
 * *          _       _
 * *   __   _(_)_   _(_) __ _ _ __
 * *   \ \ / / \ \ / / |/ _` | '_ \
 * *    \ V /| |\ V /| | (_| | | | |
 * *     \_/ |_| \_/ |_|\__,_|_| |_|
 * <p>
 * Created by vivian on 2019-12-05.
 */
public class SlidingTab extends View {

    public SlidingTab(Context context) {
        super(context);
        initView(context);
    }

    public SlidingTab(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        dealAttrs(context, attrs);
        initView(context);
    }

    public SlidingTab(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        dealAttrs(context, attrs);
        initView(context);
    }

    public SlidingTab(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        dealAttrs(context, attrs);
        initView(context);
    }

    int mStartColor;
    int mEndColor;

    public void dealAttrs(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.SlidingTab);
        mTextSize = ta.getDimensionPixelSize(R.styleable.SlidingTab_textSize, (int) DEFAULT_TEXT_SIZE);
        mRadius = ta.getDimensionPixelSize(R.styleable.SlidingTab_radius, DEFAULT_RADIUS);
        mMainColor = ta.getColor(R.styleable.SlidingTab_mainColor, Color.BLUE);
        mMainColorRes = ta.getResourceId(R.styleable.SlidingTab_mainColorRes, 0);
        if (mMainColorRes != 0) {
            mMainColor = ContextCompat.getColor(context, mMainColorRes);
        }
        mStartColor = ta.getColor(R.styleable.SlidingTab_startColor, 0);
        mEndColor = ta.getColor(R.styleable.SlidingTab_endColor, 0);
        mTabHeight = ta.getDimensionPixelSize(R.styleable.SlidingTab_tabHeight, DEFAULT_TAB_HEIGHT);
        mStrokeWidth = ta.getDimensionPixelSize(R.styleable.SlidingTab_strokeWidth, DEFAULT_TAB_HEIGHT);
        ta.recycle();
    }

    public static final float DEFAULT_TEXT_SIZE = 32f;
    public static final int DEFAULT_RADIUS = 200;
    public static final int DEFAULT_TAB_HEIGHT = 100;
    public static final int DEFAULT_STROKE_WIDTH = 2;

    Paint mPaint;
    Paint mTextPaint;
    RectF mRect;
    RectF mTabRect;

    float mTextSize = DEFAULT_TEXT_SIZE;
    int mRadius = DEFAULT_RADIUS;
    int mTabHeight = DEFAULT_TAB_HEIGHT;

    int width;
    int height;

    int mTabWidth;

    float distance;
    float baseline;
    /**
     * px
     */
    float mStrokeWidth = DEFAULT_STROKE_WIDTH;

    /**
     * default tab's count is 2
     */
    int mTabCount = 2;

    int mMainColor = Color.BLUE;
    int mMainColorRes;
    int mBgColor = Color.WHITE;

    public void initView(Context context) {
        setBackgroundColor(Color.WHITE);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(false);
        mPaint.setColor(mMainColor);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.XOR));


        mTextPaint = new Paint();
        mTextPaint.setColor(mMainColor);
        mTextPaint.setTextSize(mTextSize);
        mTextPaint.setTextAlign(Paint.Align.CENTER);

        //计算baseline
        Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();
        distance = (fontMetrics.bottom - fontMetrics.top) / 2 - fontMetrics.bottom;
        mTextPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.XOR));

        mRect = new RectF();
        mTabRect = new RectF();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthSpec = MeasureSpec.getMode(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightSpec = MeasureSpec.getMode(heightMeasureSpec);

        if (widthSize == 0) {
            widthSize = 150;
        }

        if (heightSize == 0) {
            heightSize = DEFAULT_TAB_HEIGHT;
        }

        switch (heightSpec) {
            case MeasureSpec.EXACTLY:
                break;
            case MeasureSpec.AT_MOST:
            default:
            case MeasureSpec.UNSPECIFIED:
                heightSize = DEFAULT_TAB_HEIGHT;
                break;
        }

        setMeasuredDimension(widthSize, heightSize);
    }

    LinearGradient mLinearGradient;

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;

        mTabHeight = (int) (height - 2 * mStrokeWidth);

        if (mTitles.size() == 0) {
            mTabWidth = 100;
        } else {
            mTabCount = mTitles.size();
            mTabWidth = (int) (width / mTabCount - mStrokeWidth * 2);
        }

        mRect.set(mStrokeWidth, mStrokeWidth, width - mStrokeWidth, height - mStrokeWidth);

        //渐变色
        if (mStartColor != 0 && mEndColor != 0) {
            mLinearGradient = new LinearGradient(0, 0, width, height, mStartColor, mEndColor, Shader.TileMode.CLAMP);
            mPaint.setShader(mLinearGradient);
            mTextPaint.setShader(mLinearGradient);
        }
    }


    /**
     * 更新位置
     *
     * @param newX
     */
    public void slidingTabPosition(int newX) {
        mTabRect.set(0, newX, width / mTabCount + newX, mTabHeight);
    }

    int mCurrentPostion = 0;

    public void setCurrentPostion(int currentPostion) {
        mCurrentPostion = currentPostion;
        invalidate();
    }

    float mCurrentOffset = 0;
    int mScrollPostion = 0;

    public void setScrollFromCurrentPosition(int scrollPosition, float offset) {
        mCurrentOffset = offset;
        mScrollPostion = scrollPosition;
        invalidate();
    }

    List<String> mTitles = new ArrayList<>();

    public void setTitles(List<String> titles) {
        mTitles = titles;
        invalidate();
    }

    public void setTitles(String... titles) {
        for (String title : titles) {
            mTitles.add(title);
        }
    }

    int mCurrentLeft = 0;
    float textWidth = 0;
    Path path = new Path();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        int layerId = canvas.saveLayer(mRect, null);
        canvas.drawColor(mBgColor, PorterDuff.Mode.CLEAR);

        //画tab
        mPaint.setStrokeWidth(mStrokeWidth + 1);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        if (mScrollPostion == 0) {
            mCurrentLeft = mScrollPostion * mTabWidth + (int) (mCurrentOffset * mTabWidth);
        }
        mCurrentLeft = mScrollPostion * mTabWidth + (int) (mCurrentOffset * mTabWidth);
        mTabRect.set(mCurrentLeft + mStrokeWidth, mStrokeWidth, mCurrentLeft + mTabWidth + 2 * mStrokeWidth, mTabHeight + mStrokeWidth);
        canvas.drawRoundRect(mTabRect, mRadius, mRadius, mPaint);
        canvas.save();

        //画文字
        if (mTitles.size() > 0) {
            for (int i = 0; i < mTitles.size(); i++) {
                if (i == mCurrentPostion) {
                    //画当前文字
                    mTextPaint.setColor(mMainColor);
                    textWidth = mTextPaint.measureText(mTitles.get(i));
                    baseline = mTabRect.centerY() + distance;
                    canvas.drawText(mTitles.get(i), i * mTabWidth + (mTabWidth) / 2, baseline, mTextPaint);
                } else {
                    mTextPaint.setColor(mMainColor);
                    textWidth = mTextPaint.measureText(mTitles.get(i));
                    baseline = mTabRect.centerY() + distance;
                    canvas.drawText(mTitles.get(i), i * mTabWidth + (mTabWidth) / 2, baseline, mTextPaint);
                }
            }
        }

        canvas.restoreToCount(layerId);
        //底部
        mPaint.setXfermode(null);
        mPaint.setColor(mMainColor);
        mPaint.setStrokeWidth(mStrokeWidth);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawRoundRect(mRect, mRadius, mRadius, mPaint);
    }
}
