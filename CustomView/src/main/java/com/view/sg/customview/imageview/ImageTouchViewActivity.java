package com.view.sg.customview.imageview;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.view.sg.customview.R;

public class ImageTouchViewActivity extends Activity {

    private ImageTouchView imageTouchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_touch_view);

        imageTouchView = (ImageTouchView) findViewById(R.id.image_touch_view);
        findViewById(R.id.btn_rotate).setOnClickListener(v -> {
            Matrix matrix = new Matrix();
            Bitmap bitmap = ((BitmapDrawable) imageTouchView.getDrawable()).getBitmap();
            // 设置旋转角度
            matrix.setRotate(90);
            // 重新绘制Bitmap
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            imageTouchView.setImageBitmap(bitmap);
        });
    }
}
