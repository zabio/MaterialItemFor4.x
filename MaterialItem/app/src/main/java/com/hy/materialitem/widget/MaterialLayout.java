package com.hy.materialitem.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

import com.kifile.materialwidget.MaterialBackgroundDetector;

/**
 * Created by henry  16/3/3.
 */
public class MaterialLayout extends TextView implements MaterialBackgroundDetector.Callback {
    private MaterialBackgroundDetector mDetector;

    public MaterialLayout(Context context) {
        super(context);
        init(null, 0);
    }

    public MaterialLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public MaterialLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, com.kifile.materialwidget.R.styleable.MaterialTextView, defStyle, 0);
        int color = a.getColor(com.kifile.materialwidget.R.styleable.MaterialTextView_maskColor, MaterialBackgroundDetector.DEFAULT_COLOR);
        a.recycle();
        mDetector = new MaterialBackgroundDetector(getContext(), this, this, color);
    }

    public void setColor(int color){
        mDetector = new MaterialBackgroundDetector(getContext(), this, this, color);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mDetector.onSizeChanged(w, h);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean superResult = super.onTouchEvent(event);
        return mDetector.onTouchEvent(event, superResult);
    }

    public void cancelAnimator() {
        mDetector.cancelAnimator();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isInEditMode()) {
            return;
        }
        mDetector.draw(canvas);
    }

    /**
     * When the view performClick, we should ensure the background animation appears.
     * So we will handle the action in mDetector;
     *
     * @return
     */
    @Override
    public boolean performClick() {
        return mDetector.handlePerformClick();
    }

    /**
     * When the view performClick, we should ensure the background animation appears.
     * So we will handle the action in mDetector;
     *
     * @return
     */
    @Override
    public boolean performLongClick() {
        return mDetector.handlePerformLongClick();
    }


    @Override
    public void performClickAfterAnimation() {
        super.performClick();
    }

    @Override
    public void performLongClickAfterAnimation() {
        super.performLongClick();
    }
}