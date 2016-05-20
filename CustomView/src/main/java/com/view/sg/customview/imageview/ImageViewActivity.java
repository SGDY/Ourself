package com.view.sg.customview.imageview;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.view.sg.customview.R;

public class ImageViewActivity extends AppCompatActivity {

    int[] images = new int[]{
            R.mipmap.lijiang,
            R.mipmap.qiao,
            R.mipmap.shuangta,
            R.mipmap.shui,
            R.mipmap.xiangbi,
    };
    //设置当前显示的图片
    int currentImage = 2;
    //定义图片的透明度
    private int alpha = 255;

    Button btnPlus,btnMinus,btnNext;
    ImageView image1,image2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        btnMinus = (Button) findViewById(R.id.minus);
        btnNext = (Button) findViewById(R.id.next);
        btnPlus = (Button) findViewById(R.id.plus);

        image1 = (ImageView) findViewById(R.id.image1);
        image2 = (ImageView) findViewById(R.id.image2);

        btnNext.setOnClickListener(v -> image1.setImageResource(images[++currentImage % images.length]));
        View.OnClickListener listener = v -> {
            if (v == btnPlus) {
                alpha += 20;
            }
            if (v == btnMinus) {
                alpha -= 20;
            }
            if (alpha > 255) {
                alpha = 255;
            }
            if (alpha < 0) {
                alpha = 0;
            }
            image1.setImageAlpha(alpha);
        };
        btnPlus.setOnClickListener(listener);
        btnMinus.setOnClickListener(listener);

        image1.setOnTouchListener((view,event) -> {

            BitmapDrawable bitmapDrawable = (BitmapDrawable) image1.getDrawable();
            //获取第一个图片显示框中的位图
            Bitmap bitmap = bitmapDrawable.getBitmap();
            //bitmap的实际大小和第一个ImageView的缩放比例
            double scale = 1.0 * bitmap.getHeight() / image1.getHeight();
            //获取需要显示图片的开始点
            int x = (int) (event.getX() * scale);
            int y = (int) (event.getY() * scale);

            if (x + 120 > bitmap.getWidth()) {
                x = bitmap.getWidth() - 120;
            }

            if (y + 120 > bitmap.getHeight()) {
                y = bitmap.getHeight() - 120;
            }

            image2.setImageBitmap(Bitmap.createBitmap(bitmap, x, y, 120, 120));
            image2.setImageAlpha(alpha);
            return false;
        });
    }
}
