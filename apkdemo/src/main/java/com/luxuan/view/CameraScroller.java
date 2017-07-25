package com.luxuan.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;
import android.widget.TextView;

/**
 * Created by Luxuan on 2017/7/21.
 */

public class CameraScroller extends ViewGroup{

    public Scroller mScroller;
    public int leftIndex;
    public int rightIndex;
    public int duration=300;

    public CameraScroller(Context context, AttributeSet attrs){
        super(context, attrs);
        mScroller=new Scroller(context);
    }

    public final void scrollToNext(int preIndex, int nextIndex){
        TextView selectedText=(TextView)getChildAt(preIndex);
        if(selectedText!=null){
            selectedText.setTextColor(getResources().getColor(R.color.black));
        }
        selectedText=(TextView)getChildAt(nextIndex);
        if(selectedText!=null){
            selectedText.setTextColor(getResources().getColor(R.color.chosenTextColor));
        }
    }

    public void computeScroll(){
        if(mScroller.computeScrollOffset()){
            scrollTo(mScroller.getCurrX(),mScroller.getCurrY());
            invalidate();
        }
        super.computeScroll();
    }

    protected void onFinishInflate(){
        super.onFinishInflate();
    }

    protected void onLayout(boolean changed, int left,int top,int right, int bottom){
        int cCount = getChildCount();
        int childLeft=0;
        int childRight=0;
        int selectedMode=Util.getCurrentSelectedIndex();
        int widthOffset=0;//居中显示
        /**
         * 遍历所有childView根据其宽和高，不考虑margin
         */
        for(int i=0;i<cCount;i++){
            View childView = getChildAt(i);
            if(i<selectedMode){
                widthOffset+=childView.getMeasuredWidth();
            }
        }

        for (int i = 0; i < cCount; i++)
        {
            View childView = getChildAt(i);
            if(i!=0){
                View preView=getChildAt(i-1);
                childLeft=preView.getRight();
                childRight=childLeft+childView.getMeasuredWidth();
            }else{
                //getChildAt(0).getMeasuredWidth()应该被替换为被确认的值，循环计算。
                childLeft=(getWidth()-getChildAt(selectedMode).getMeasuredWidth())/2-widthOffset;
                childRight=childLeft+childView.getMeasuredWidth();
            }
            childView.layout(childLeft, top, childRight, bottom);
        }

        TextView indexText=(TextView)getChildAt(selectedMode);
        indexText.setTextColor(getResources().getColor(R.color.chosenTextColor));
    }

    protected void onMeasure(int widthMeasureSpec,int heightMeasureSpec){
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(heightMeasureSpec));
    }

}
