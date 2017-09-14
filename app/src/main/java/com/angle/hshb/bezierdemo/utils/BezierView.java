package com.angle.hshb.bezierdemo.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 *  贝塞尔练习
 */

public class BezierView extends View {

    private float mSupX=250;
    private float mSupY=400;

    public BezierView(Context context) {
        super(context);
    }

    public BezierView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BezierView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        Paint p=new Paint();
        p.setStrokeWidth(10);
        p.setStyle(Paint.Style.STROKE);
        Path bezierpath=new Path();
        bezierpath.moveTo(100,200);
        bezierpath.quadTo(mSupX,mSupY,400,200);
        canvas.drawPath(bezierpath,p );
        super.onDraw(canvas);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_MOVE:
                mSupX=event.getX();
                mSupY=event.getY();
                break;
        }
        return true;
    }
}
