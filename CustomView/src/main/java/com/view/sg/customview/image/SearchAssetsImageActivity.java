package com.view.sg.customview.image;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

import com.view.sg.customview.R;

import java.io.IOException;
import java.io.InputStream;

public class SearchAssetsImageActivity extends Activity {

    String[] images = null;
    AssetManager assets = null;
    int currentImg = 0;
    ImageView imgView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_assets_image);

        imgView = (ImageView) findViewById(R.id.img_view);

        try {
            assets = getAssets();
            //获取Assets目录下所有的文件
            images = assets.list("");
        } catch (IOException e) {
            e.printStackTrace();
        }

        findViewById(R.id.btn).setOnClickListener(v -> {
            if (currentImg >= images.length) {
                currentImg = 0;
            }
            while (!images[currentImg].endsWith(".png") && !images[currentImg].endsWith(".jpg") && !images[currentImg].endsWith(".gif")) {
                currentImg ++;
                if (currentImg >= images.length) {
                    currentImg = 0;
                }
            }
            InputStream inputStream = null;
            try {
                inputStream = assets.open(images[currentImg++]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            BitmapDrawable bitmapDrawable = (BitmapDrawable) imgView.getDrawable();
            if (bitmapDrawable != null && !bitmapDrawable.getBitmap().isRecycled()) {
                bitmapDrawable.getBitmap().recycle();
            }
            //从InputStream中读取图片放在ImageView中
            imgView.setImageBitmap(BitmapFactory.decodeStream(inputStream));
        });
    }
}
