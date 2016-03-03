package com.hy.materialitem.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hy.materialitem.R;
import com.kifile.materialwidget.MaterialBackgroundDetector;

/**
 * Created by henry  16/3/3.
 */
public class CommonItem extends LinearLayout implements View.OnClickListener{
    private View mParent;
    private TextView mTvContent;
    private ImageView mIcon;
    private ImageView mArrow;
    private MaterialLayout mMaterial;
    private boolean isHiddenArrow;
    private String mText;
    private Drawable mDrawable;
    private int mColor;
    private int mClickId=-1;

    public CommonItem(Context context) {
        super(context);
    }

    public CommonItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        getAttrValue(context, attrs);
    }

    public CommonItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getAttrValue(context, attrs);

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        init();
    }


    private void getAttrValue(Context context, AttributeSet attrs) {
        mParent = LayoutInflater.from(context).inflate(R.layout.widget_common_item, this, true);
        TypedArray attribute = context.obtainStyledAttributes(attrs,
                R.styleable.CommonItem);
        if (null != attribute) {
            isHiddenArrow = attribute.getBoolean(R.styleable.CommonItem_showArrow, false);
            mDrawable = attribute.getDrawable(R.styleable.CommonItem_iconSrc);
            mText = attribute.getString(R.styleable.CommonItem_text);
            mColor = attribute.getColor(R.styleable.CommonItem_backgroundMaskColor, MaterialBackgroundDetector.DEFAULT_COLOR);
            attribute.recycle();
        }


    }

    private void init() {
        mIcon = (ImageView) findViewById(R.id.img_icon);
        mArrow = (ImageView) findViewById(R.id.img_right);
        mTvContent = (TextView) findViewById(R.id.tv_content);
        mMaterial = (MaterialLayout) findViewById(R.id.ml);
        mMaterial.setColor(mColor);
        mMaterial.setOnClickListener(this);
        mIcon.setImageDrawable(mDrawable);
        mArrow.setVisibility(isHiddenArrow ? VISIBLE : GONE);
        mTvContent.setText(mText);

    }


    @Override
    public void onClick(View v) {
        if (null!=mOnItemClickListener){
            mOnItemClickListener.onClick(mClickId);
        }
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(int clickId,OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
        this.mClickId=clickId;
    }

    public interface OnItemClickListener{
        void onClick(int id);
    }
}
