package com.view.sg.customview.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;

import com.view.sg.customview.R;

import java.util.jar.Attributes;

/**
 * @author 上官丹意
 * @version 1.0
 * @description
 * @createDate 2016/1/24
 */
public class MatrixView extends View {
    //设置倾斜度
    public float sx = 0.0f;
    //缩放比例
    public float scale = 1.0f;
    //判断缩放还是倾斜
    public boolean isScale = false;
    //初始化图片资源
    private Bitmap bitmap;
    //Matrix 实例
    private Matrix matrix = new Matrix();
    //位图宽和高
    private int width,height;

    public MatrixView(Context context,AttributeSet set) {
        super(context,set);
        //获得位图
        bitmap = ((BitmapDrawable)context.getResources().getDrawable(R.mipmap.a)).getBitmap();
        //获得位图宽
        width = bitmap.getWidth();
        //获得位图高
        height = bitmap.getHeight();
        //使当前视图获得焦点
        this.setFocusable(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //重置Matrix
        matrix.reset();

        if (!isScale) {
            //倾斜
            matrix.setSkew(sx,0);
        } else {
            matrix.setScale(scale,scale);
        }
        //根据原始位图和Matrix创建新图片
        Bitmap bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        //绘制新位图
        canvas.drawBitmap(bitmap2,matrix,null);
    }
}
