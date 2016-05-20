package com.view.sg.customview.adapterviewanimator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.view.sg.customview.MainActivity;
import com.view.sg.customview.R;

public class AdapterViewFlipperActivity extends AppCompatActivity {

    int[] imageIds = new int[]
            {
                    R.mipmap.shuangzi, R.mipmap.shuangyu,
                    R.mipmap.chunv, R.mipmap.tiancheng, R.mipmap.tianxie,
                    R.mipmap.sheshou, R.mipmap.juxie, R.mipmap.shuiping,
                    R.mipmap.shizi, R.mipmap.baiyang, R.mipmap.jinniu,
                    R.mipmap.mojie};
    private AdapterViewFlipper flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_view_flipper_activity);

        flipper = (AdapterViewFlipper) findViewById(R.id.flipper);
        // 创建一个BaseAdapter对象，该对象负责提供Gallery所显示的列表项
        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return imageIds.length;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            // 该方法返回的View代表了每个列表项
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                // 创建一个ImageView
                ImageView imageView = new ImageView(AdapterViewFlipperActivity.this);
                imageView.setImageResource(imageIds[position]);
                // 设置ImageView的缩放类型
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                // 为imageView设置布局参数
                imageView.setLayoutParams(new ViewGroup.LayoutParams(
                        RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        };
        flipper.setAdapter(adapter);
    }

    public void prev(View source) {
        // 显示上一个组件
        flipper.showPrevious();
        // 停止自动播放
        flipper.stopFlipping();
    }

    public void next(View source) {
        // 显示下一个组件。
        flipper.showNext();
        // 停止自动播放
        flipper.stopFlipping();
    }

    public void auto(View source) {
        // 开始自动播放
        flipper.startFlipping();
    }
}
