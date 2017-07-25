package com.luxuan.view;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Luxuan on 2017/6/30.
 */

public class MainActivity extends Activity {

    float x1=0;
    float x2=0;
    float y1=0;
    float y2=0;
    private BottomView mBottomView;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        mBottomView=(BottomView)findViewById(R.id.bottomView);
        mBottomView.init();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){

        if(event.getAction()==MotionEvent.ACTION_DOWN){
            x1=event.getX();
            y1=event.getY();
        }
        if(event.getAction()==MotionEvent.ACTION_UP){
            x2=event.getX();
            y2=event.getY();

            if(x1-x2>50){
                if(Util.getCurrentSelectedIndex()<Util.MAX_INDEX) {
                    mBottomView.moveRight();
                }
            }else if(x2-x1>50){
                if(Util.getCurrentSelectedIndex()>Util.MIN_INDEX) {
                    mBottomView.moveLeft();
                }
            }
        }
        return super.onTouchEvent(event);
    }

}
