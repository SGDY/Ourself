package com.view.sg.customview.image;

import android.graphics.BlurMaskFilter;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.view.sg.customview.R;

public class DrawViewActivity extends AppCompatActivity {

    EmbossMaskFilter embossMaskFilter;//浮雕效果
    BlurMaskFilter blurMaskFilter;//模糊效果
    DrawView drawView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout line = new LinearLayout(this);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        //获取创建的高度和宽度 包括虚拟键所在的区域
        getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        //创建一个DrawView，改drawView的宽度、高度与该Activity保持相同
        drawView = new DrawView(this, displayMetrics.widthPixels, displayMetrics.heightPixels);
        line.addView(drawView);

        setContentView(line);
        embossMaskFilter = new EmbossMaskFilter(new float[]{1.5f, 1.5f, 1.5f}, 0.6f, 6f, 4.2f);
        blurMaskFilter = new BlurMaskFilter(8, BlurMaskFilter.Blur.NORMAL);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(this);
        //加载菜单，并添加到menu中
        menuInflater.inflate(R.menu.menu_main_1,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.red:
                drawView.paint.setColor(Color.RED);
                item.setChecked(true);
                break;
            case R.id.green:
                drawView.paint.setColor(Color.GREEN);
                break;
            case R.id.blue:
                drawView.paint.setColor(Color.BLUE);
                item.setChecked(true);
                break;
            case R.id.width_1:
                drawView.paint.setStrokeWidth(1);
                break;
            case R.id.width_3:
                drawView.paint.setStrokeWidth(3);
                break;
            case R.id.width_5:
                drawView.paint.setStrokeWidth(5);
                break;
            case R.id.blur:
                drawView.paint.setMaskFilter(blurMaskFilter);
                break;
            case R.id.emboss:
                drawView.paint.setMaskFilter(embossMaskFilter);
                break;
        }
        return true;
    }
}
