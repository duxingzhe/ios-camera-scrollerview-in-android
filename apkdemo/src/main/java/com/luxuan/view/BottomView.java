package com.luxuan.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

/**
 * Created by Luxuan on 2017/7/21.
 */

public class BottomView extends LinearLayout {
    private CameraScroller mCameraScroller;
    private Context mContext;

    public BottomView(Context context, AttributeSet attrs){
        super(context,attrs);
        mContext=context;
        LayoutInflater.from(context).inflate(R.layout.camera_scroller_layout,this,true);
    }

    public void init(){
        mCameraScroller=(CameraScroller)findViewById(R.id.camera_scroller);
    }

    public void moveLeft(){
        CameraScroller cameraScroller=mCameraScroller;
        cameraScroller.leftIndex=Util.getCurrentSelectedIndex()-1;
        cameraScroller.rightIndex=Util.getCurrentSelectedIndex();
        int k=Math.round((cameraScroller.getChildAt(cameraScroller.leftIndex).getWidth()+cameraScroller.getChildAt(cameraScroller.rightIndex).getWidth())/2.0F);
        cameraScroller.mScroller.startScroll(cameraScroller.getScrollX(),0,-k,0,cameraScroller.duration);
        cameraScroller.scrollToNext(cameraScroller.rightIndex,cameraScroller.leftIndex);
        Util.setSelectedIndex(Util.getCurrentSelectedIndex()-1);
        cameraScroller.invalidate();

    }

    public void moveRight(){
        CameraScroller cameraScroller=mCameraScroller;
        cameraScroller.leftIndex=Util.getCurrentSelectedIndex();
        cameraScroller.rightIndex=Util.getCurrentSelectedIndex()+1;
        int k=Math.round((cameraScroller.getChildAt(cameraScroller.leftIndex).getWidth()+cameraScroller.getChildAt(cameraScroller.rightIndex).getWidth())/2.0F);
        cameraScroller.mScroller.startScroll(cameraScroller.getScrollX(),0,k,0,cameraScroller.duration);
        cameraScroller.scrollToNext(cameraScroller.leftIndex,cameraScroller.rightIndex);
        Util.setSelectedIndex(Util.getCurrentSelectedIndex()+1);
        cameraScroller.invalidate();
    }
}
