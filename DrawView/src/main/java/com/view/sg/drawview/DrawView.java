package com.view.sg.drawview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * @author sg
 * @version 1.0
 * @description
 * @createDate 2015/11/28
 */
public class DrawView extends View {

    public float currentX = 40;
    public float currentY = 50;

    Paint p = new Paint();

    public DrawView(Context context) {
        super(context);
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置画笔的颜色
        p.setColor(Color.RED);
        canvas.drawCircle(currentX,currentY,15,p);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //修改currentX和currentY两个属性
        currentX = event.getX();
        currentY = event.getY();
        //通知当前组件重绘自己
        invalidate();
        //返回true表明该处理方法已经处理该事件
        return true;
    }
}
