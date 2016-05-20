package com.view.sg.customview.image;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import com.view.sg.customview.R;

import java.util.Timer;
import java.util.TimerTask;

public class MoveBackActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }

    class MyView extends View {
        //记录背景位图的实际高度
        final int BACK_HEIGHT = 700;
        //背景图片
        private Bitmap back;
        //飞机图片
        private Bitmap plane;
        //定义图片的宽度
        final int WIDTH = 140;
        final int HEIGHT = 240;

        private Matrix matrix = new Matrix();
        //背景图片的开始位置
        private int startY = BACK_HEIGHT - HEIGHT;

        public MyView(Context context) {
            super(context);
            back = BitmapFactory.decodeResource(context.getResources(),R.mipmap.back_img);

            //获取窗口管理器
            WindowManager windowManager = getWindowManager();
            Display display = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            display.getMetrics(displayMetrics);
            //获取屏幕的宽度
            float screenWidth = displayMetrics.widthPixels;
            //获取图片的缩放比例
            float scale = screenWidth / WIDTH;
            matrix.setScale(scale,scale);

            plane = BitmapFactory.decodeResource(context.getResources(), R.mipmap.plane);

            final Handler handler = new Handler(){
                @Override
                public void handleMessage(Message msg) {
                    if (msg.what == 0x123) {
                        //重新开始移动
                        if (startY <= 3) {
                            startY = BACK_HEIGHT - HEIGHT;
                        } else {
                            startY -= 3;
                        }
                    }
                    invalidate();
                }
            };

            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.sendEmptyMessage(0x123);
                }
            },0,100);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            //根据原始位图和缩放Matrix创建新图片
            Bitmap bitmap2 = Bitmap.createBitmap(back, 0, startY, WIDTH, HEIGHT, matrix, false);
            //绘制新位图
            canvas.drawBitmap(bitmap2,0,0,null);
            //绘制飞机
            canvas.drawBitmap(plane,320,700,null);
        }
    }
}
