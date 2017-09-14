package com.angle.hshb.bezierdemo;

/**
 * Created by Luo_xiasuhuei321@163.com on 2016/9/24.
 * desc:
 */

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;

public class ZZoomImageView extends ImageView implements View.OnTouchListener, ScaleGestureDetector.OnScaleGestureListener {
    //suppress the unused warning because maybe it will be used sometime later
    @SuppressWarnings("unused")
    private static final String TAG = "ZZoomImageView";

    /**
     * 最大放大倍数
     */
//    public static final float SCALE_MAX = 4.0f;

    /**
     * 默认缩放
     */
//    private float initScale = 1.0f;

    /**
     * 手势检测
     */
    ScaleGestureDetector scaleGestureDetector = null;

    Matrix scaleMatrix = new Matrix();

    /**
     * 处理矩阵的9个值
     */
//    float[] martixValue = new float[9];

    public ZZoomImageView(Context context) {
        this(context, null);
    }

    public ZZoomImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ZZoomImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setScaleType(ScaleType.MATRIX);
        scaleGestureDetector = new ScaleGestureDetector(context, this);
        this.setOnTouchListener(this);
    }

    /**
     * 获取当前缩放比例
     */
//    public float getScale() {
//        scaleMatrix.getValues(martixValue);
//        return martixValue[Matrix.MSCALE_X];
//    }

    //--------------------------implement OnTouchListener----------------------------//

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return scaleGestureDetector.onTouchEvent(event);
    }

    //----------------------implement OnScaleGestureListener------------------------//

    @Override
    public boolean onScale(ScaleGestureDetector detector) {
//        float scale = getScale();
        float scaleFactor = detector.getScaleFactor();
        if (getDrawable() == null)
            return true;
//        Log.e(TAG,"君甚咸，此鱼何能及君也？");
//        if (scaleFactor * scale < initScale)
//            scaleFactor = initScale / scale;
//        if (scaleFactor * scale > SCALE_MAX)
//            scaleFactor = SCALE_MAX / scale;
        //设置缩放比例
        scaleMatrix.postScale(scaleFactor, scaleFactor, getWidth() / 2, getHeight() / 2);
        setImageMatrix(scaleMatrix);
        return true;
    }

    @Override
    public boolean onScaleBegin(ScaleGestureDetector detector) {
        return true;
    }

    @Override
    public void onScaleEnd(ScaleGestureDetector detector) {

    }
}