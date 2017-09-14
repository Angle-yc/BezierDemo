package com.angle.hshb.bezierdemo;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.angle.hshb.bezierdemo.utils.WaveView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    WaveView waveView;
    TouchImageView ivImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        waveView = (WaveView) findViewById(R.id.wave_view);
        waveView.setRunning();
        ivImg = (TouchImageView) findViewById(R.id.iv_img);
        ivImg.setImageResource(R.drawable.a4);
    }

    /**
     * 多张纵向拼接
     * @param bitList
     * @return
     */
    private Bitmap addBitmap(List<Bitmap> bitList) {
        Bitmap result = null;
        int width = bitList.get(0).getWidth();
        int height = 0;
        for (int i = 0; i < bitList.size(); i++) {
            height += bitList.get(i).getHeight() / 10 * 8;
        }
        result = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(result);
        int pathH = 0;
        for (int i = 0; i < bitList.size(); i++) {
            canvas.drawBitmap(bitList.get(i), 0, pathH, null);
            pathH += bitList.get(i).getHeight() / 10 * 8;
            bitList.get(i).recycle();
        }
        return result;
    }


    /**
     * 纵向拼接
     * <功能详细描述>
     *
     * @param first
     * @param second
     * @return
     */
    private Bitmap addBitmap(Bitmap first, Bitmap second) {
        int width = Math.max(first.getWidth(), second.getWidth());
        int height = first.getHeight() + second.getHeight();
        Bitmap result = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(result);
        canvas.drawBitmap(first, 0, 0, null);
        canvas.drawBitmap(second, 0, first.getHeight(), null);
        return result;
    }

    /**
     * 横向拼接
     * <功能详细描述>
     *
     * @param first
     * @param second
     * @return
     */
    private Bitmap add2Bitmap(Bitmap first, Bitmap second) {
        int width = first.getWidth() + second.getWidth();
        int height = Math.max(first.getHeight(), second.getHeight());
        Bitmap result = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(result);
        canvas.drawBitmap(first, 0, 0, null);
        canvas.drawBitmap(second, first.getWidth(), 0, null);
        return result;
    }
}
