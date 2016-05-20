package com.view.sg.customview.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * @author 上官丹意
 * @version 1.0
 * @description 采用双缓冲实现画图板：当程序需要在指定View上进行绘制时，程序并不直接绘制到该View组件上，而是先绘制到内存中
 * 的一个Bitmap图片上（这就是缓冲区），等到内存中的bitmap绘制好了之后，再一次性地将Bitmap绘制到该View组件上。
 *
 * @createDate 2016/1/24
 */
public class DrawView extends View{
    //定义记录前一个拖动事件发生点的坐标
    float preX, preY;

    private Path path;
    public Paint paint = null;
    //定义内存中的一个图片，该图片作为缓冲区
    Bitmap cacheBitmap = null;
    //定义cacheBitmap上的Canvas对象
    Canvas cacheCanvas = null;

    public DrawView(Context context,int width,int height) {
        super(context);
        //定义一个与该View具有相同大小的缓冲区
        cacheBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        cacheCanvas = new Canvas();
        path = new Path();
        //设置cacheCanvas将会绘制到内存中的cacheBitmap上
        cacheCanvas.setBitmap(cacheBitmap);
        //设置画笔的颜色
        paint = new Paint(Paint.DITHER_FLAG);
        paint.setColor(Color.RED);
        //设置画笔的风格
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
        //设置反锯齿
        paint.setAntiAlias(true);
        paint.setDither(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("Test", "onDraw...");
        Paint bmpPaint = new Paint();
        //将cacheBitmap绘制到该View组件上
        canvas.drawBitmap(cacheBitmap, 0, 0, bmpPaint);
        //沿着Path绘制
        canvas.drawPath(path,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("Test", "onTouchEvent...");
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //从前一个点绘制到当前点之后，把当前点定义成下次绘制的前一个点
                path.moveTo(x,y);
                preX = x;
                preY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                //从前一个点绘制到当前点之后，把当前点定义成下次绘制的前一个点
                path.quadTo(preX,preY,x,y);
                preX = x;
                preY = y;
                break;
            case MotionEvent.ACTION_UP:
                cacheCanvas.drawPath(path,paint);
                path.reset();
                break;
        }
        invalidate();
        return true;//表明该方法已经处理该事件
    }
}
