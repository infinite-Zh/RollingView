package com.infinite.rollingoverview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class RollingOverView extends ViewFlipper {

    private int mTextColor=Color.BLACK;
    private int mTextSize=18;
    private int mAnimDuration=500;
    private int mFlipInterval=2000;
    public RollingOverView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray array=context.obtainStyledAttributes(attrs,R.styleable.RollingOverView);
        mFlipInterval=array.getInt(R.styleable.RollingOverView_flipInterval,2000);
        mTextColor=array.getInt(R.styleable.RollingOverView_textColor, Color.BLACK);
        mTextSize= (int) array.getDimension(R.styleable.RollingOverView_textSize, 18);
        mTextSize=px2sp(context,mTextSize);
        mAnimDuration=array.getInt(R.styleable.RollingOverView_animationDuration,500);
        array.recycle();
    }

    public RollingOverView(Context context) {
        super(context);
    }

    public void setContents(String[] arrs){
        if (arrs!=null&&arrs.length>0){
            for(String str:arrs){
                addChild(str);
            }
        }

        Animation animationIn= AnimationUtils.loadAnimation(getContext(),R.anim.in_animation);
        animationIn.setDuration(mAnimDuration);
        setInAnimation(animationIn);

        Animation animationOut= AnimationUtils.loadAnimation(getContext(),R.anim.out_animation);
        animationOut.setDuration(mAnimDuration);
        setOutAnimation(animationOut);
        setFlipInterval(mFlipInterval);
    }

    private void addChild(String content){
        if (TextUtils.isEmpty(content))
            content="";
        TextView txt=new TextView(getContext());
        ViewGroup.LayoutParams lp=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                                             ViewGroup.LayoutParams.MATCH_PARENT);
        txt.setLayoutParams(lp);
        txt.setTextColor(mTextColor);
        txt.setTextSize(mTextSize);
        txt.setText(content);
        txt.setGravity(Gravity.CENTER_VERTICAL);
        addView(txt);
    }


    private static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }
}
