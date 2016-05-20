package com.view.sg.drawview;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class CanvasActivity extends Activity {

    ImageView imageView;
    Paint mPaint;
    Canvas mCanvas;
    Bitmap mBitmap;

    private float currentX;
    private float currentY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        initComponent();
    }

    private void initComponent() {
        imageView = (ImageView) findViewById(R.id.img_view);
        imageView.setOnTouchListener(new MyOnTouchListener());
    }

    private void initVariable() {
        if (mBitmap == null) {
            mBitmap = Bitmap.createBitmap(imageView.getWidth(), imageView.getHeight(), Bitmap.Config.ARGB_8888);

            mCanvas = new Canvas(mBitmap);

            mPaint = new Paint();
            mPaint.setColor(Color.RED);
            mPaint.setStrokeWidth(5);

            mCanvas.drawColor(Color.GREEN);
            imageView.setImageBitmap(mBitmap);
        }
    }

    class MyOnTouchListener implements View.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN://按下
                    initVariable();
                    currentX = event.getX();
                    currentY = event.getY();
                    break;
                case MotionEvent.ACTION_MOVE://移动
                    float x = event.getX();
                    float y = event.getY();

                    mCanvas.drawLine(currentX,currentY,x,y,mPaint);
                    imageView.setImageBitmap(mBitmap);
                    currentX = x;
                    currentY = y;
                    break;
                case MotionEvent.ACTION_UP://抬起
                    File cacheDir = Environment.getExternalStorageDirectory();
                    File cacheFile = new File(cacheDir.getPath(),"test_01_19.jpg");
                    Toast.makeText(CanvasActivity.this, cacheFile.getPath(), Toast.LENGTH_SHORT).show();

                    try {
                        FileOutputStream outputStream = new FileOutputStream(cacheFile);
                        boolean isSuccess = mBitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                        if (isSuccess) {
                            Toast.makeText(CanvasActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
            }
            return true;//true表示本方法可以处理onTouch事件，不需传递
        }
    }
}
