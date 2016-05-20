package com.view.sg.customview.image;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.SumPathEffect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class PathActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }

    class MyView extends View {

        float phase;
        PathEffect[] effects = new PathEffect[7];
        int[] colors;
        private Paint paint;
        Path path;

        public MyView(Context context) {
            super(context);
            paint = new Paint();
            //设置Paint的填充风格
            paint.setStyle(Paint.Style.STROKE);
            paint.setAntiAlias(true);
            paint.setStrokeWidth(1);

            path = new Path();
            path.moveTo(0,0);
            for (int i = 0; i <= 40; i++) {
                //生成40个点，随机生成他们的Y坐标，并将它们连成一条Path
                path.lineTo(i * 20, (float) Math.random() * 60);
            }
            colors = new int[]{Color.BLACK,Color.BLUE,Color.CYAN,Color.GREEN,Color.MAGENTA,Color.RED,Color.YELLOW};
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            canvas.drawColor(Color.WHITE);
            //----------------下面开始初始化7种路径效果----------------
            //不使用路径效果
            effects[0] = null;
            //CornerPathEffect
            effects[1] = new CornerPathEffect(10);
            //DiscretePathEffect
            effects[2] = new DiscretePathEffect(3.0f, 5.0f);
            //DashPathEffect
            effects[3] = new DashPathEffect(new float[]{20,10,5,10},phase);
            //PathDashPathEffect
            Path p = new Path();
            p.addRect(0,0,8,8,Path.Direction.CCW);
            effects[4] = new PathDashPathEffect(p, 12, phase, PathDashPathEffect.Style.ROTATE);
            //ComposePathEffect
            effects[5] = new ComposePathEffect(effects[2], effects[4]);
            //SumPathEffect
            effects[6] = new SumPathEffect(effects[4], effects[3]);

            canvas.translate(8,8);
            for (int i = 0; i < effects.length; i++) {
                paint.setPathEffect(effects[i]);
                paint.setColor(colors[i]);
                canvas.drawPath(path,paint);
                canvas.translate(0,60);
            }

            phase ++;
            invalidate();
        }
    }
}
