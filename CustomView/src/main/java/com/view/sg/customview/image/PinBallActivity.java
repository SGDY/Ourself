package com.view.sg.customview.image;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 弹球游戏，其中小球和球拍分别以圆形区域和矩形区域代表，小球开始随机速度向下运动，遇到边框或者球拍时小球反弹，
 * 球拍由用户控制，当用户按下向左，向右键时，球拍会向左向右移动
 *
 */
public class PinBallActivity extends Activity {
    //桌面的宽度
    private int tableWidth;
    //桌面的高度
    private int tableHeight;
    //球拍的垂直位置
    private int racketY;
    //定义球拍的高度和宽度
    private final int RACKET_HEIGHT = 30;
    private final int RACKET_WIDTH = 90;
    //小球的大小
    private final int BALL_SIZE = 16;
    //小球的纵向运行速度
    private int ySpeed = 15;

    Random random = new Random();
    //返回一个-0.5~0.5的比率，用于控制小球的运动方向
    private double xyRate = random.nextDouble() - 0.5;
    //小球横向的运行速度
    private int xSpeed = (int) (ySpeed * xyRate * 2);
    //ballX和ballY代表小球的坐标
    private int ballX = random.nextInt(200) + 20;
    private int ballY = random.nextInt(10) + 20;
    //球拍的水平位置
    private int racketX = random.nextInt(200);
    //游戏是否结束的旗标
    private boolean isLose = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉窗口标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //全屏显示
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
       //创建GameView组件
        final GameView gameView = new GameView(this);
        setContentView(gameView);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        display.getMetrics(displayMetrics);

        //获取屏幕的宽和高
        tableWidth = displayMetrics.widthPixels;
        tableHeight = displayMetrics.heightPixels;

        racketY = tableHeight - 80;
        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 0x123) {
                    gameView.invalidate();
                }
            }
        };

        gameView.setOnKeyListener((v,keyCode,event) -> {

            switch (event.getKeyCode()) {
                //控制挡板左移
                case KeyEvent.KEYCODE_A:
                    if (racketX > 0) {
                        racketX -= 10;
                    }
                    break;
                //控制挡板右移
                case KeyEvent.KEYCODE_D:
                    if (racketX < tableWidth - RACKET_WIDTH) {
                        racketX += 10;
                    }
                    break;
            }
            gameView.invalidate();
            return true;
        });

        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //如果小球碰到左右边框
                if (ballX <= 0 || ballX >= tableWidth - BALL_SIZE) {
                    xSpeed = -xSpeed;
                }
                //如果小球高度超出了球拍的位置，且横向不在球拍范围之内，游戏结束
                if (ballY >= racketY - BALL_SIZE && (ballX < racketX || ballX > racketX + RACKET_WIDTH)) {
//                    timer.cancel();
                    ySpeed = -ySpeed;
//                    isLose = true;
                }else if (ballY <= 0 || (ballY >= racketY - BALL_SIZE && ballX > racketX && ballX <= racketX + RACKET_WIDTH)) {
                    //如果小球位于球拍之内，且到达球拍指定位置，小球反弹
                     timer.cancel();
//                    ySpeed = -ySpeed;
                    isLose = true;
                }

                ballY += ySpeed;
                ballX += xSpeed;

//                handler.sendEmptyMessage(0x123);
                gameView.postInvalidate();
            }
        },0,100);
    }

    class GameView extends View {

        Paint paint = new Paint();

        public GameView(Context context) {
            super(context);
            setFocusable(true);
            paint.setStyle(Paint.Style.FILL);
            //设置去锯齿
            paint.setAntiAlias(true);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            if (isLose) {
                //如果游戏已经结束
                paint.setColor(Color.RED);
                paint.setTextSize(40);
                canvas.drawText("游戏已经结束",tableWidth / 2 - 100,200,paint);
            } else {
                //如果游戏还未结束
                //设置颜色，并绘制小球
                paint.setColor(Color.rgb(255,0,0));
                canvas.drawCircle(ballX, ballY, BALL_SIZE, paint);
                //设置颜色，并绘制球拍
                paint.setColor(Color.rgb(80, 80, 200));
                canvas.drawRect(racketX,racketY,racketX + RACKET_WIDTH,racketY + RACKET_HEIGHT,paint);
            }
        }
    }
}
