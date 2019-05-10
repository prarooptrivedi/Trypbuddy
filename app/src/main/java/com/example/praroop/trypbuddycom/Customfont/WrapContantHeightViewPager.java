package com.example.praroop.trypbuddycom.Customfont;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


/**
 * Created by wolfsoft5 on 7/4/18.
 */

public class WrapContantHeightViewPager extends ViewPager {
private boolean enabled;

public WrapContantHeightViewPager(Context context){
        super(context);
        this.enabled=true;

        }

public WrapContantHeightViewPager(Context context, AttributeSet attrs){
        super(context,attrs);
        this.enabled=true;

        }

@Override
protected void onMeasure(int widthMeasureSpec,int heightMeasureSpec){
        super.onMeasure(widthMeasureSpec,heightMeasureSpec);

        int height=0;
        for(int i=0;i<getChildCount();i++){
        View child=getChildAt(i);
        child.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        int h=child.getMeasuredHeight();
        if(h>height)height=h;
        }

        heightMeasureSpec= MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);

        super.onMeasure(widthMeasureSpec,heightMeasureSpec);
        }

@Override
public boolean onTouchEvent(MotionEvent event){
        if(this.enabled){
        return super.onTouchEvent(event);

        }

        return false;
        }

@Override
public boolean onInterceptTouchEvent(MotionEvent event){
        if(this.enabled){
        return super.onInterceptTouchEvent(event);
        }

        return false;
        }

public void setPagingEnabled(boolean enabled){
        this.enabled=enabled;
        }

        }
