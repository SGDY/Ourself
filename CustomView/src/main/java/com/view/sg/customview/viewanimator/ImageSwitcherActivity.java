package com.view.sg.customview.viewanimator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.ViewSwitcher;

import com.view.sg.customview.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageSwitcherActivity extends AppCompatActivity {

    int[] imageIds = new int[]
            {
                    R.mipmap.bomb5, R.mipmap.bomb6, R.mipmap.bomb7
                    , R.mipmap.bomb8, R.mipmap.bomb9, R.mipmap.bomb10
                    , R.mipmap.bomb11, R.mipmap.bomb12, R.mipmap.bomb13
                    , R.mipmap.bomb14, R.mipmap.bomb15, R.mipmap.bomb16
            };

    ImageSwitcher switcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_switcher);

        List<Map<String, Object>> listItems = new ArrayList<>();
        for (int i = 0; i < imageIds.length; i++) {
            Map<String, Object> listItem = new HashMap<>();
            listItem.put("image", imageIds[i]);
            listItems.add(listItem);
        }

        switcher = (ImageSwitcher) findViewById(R.id.switcher);

        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(ImageSwitcherActivity.this);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ImageSwitcher.LayoutParams.WRAP_CONTENT, ImageSwitcher.LayoutParams.WRAP_CONTENT));
                return imageView;
            }
        });

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems, R.layout.cell, new String[]{"image"}, new int[]{R.id.image1});
        GridView grid = (GridView) findViewById(R.id.grid01);
        grid.setAdapter(simpleAdapter);

        grid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switcher.setImageResource(imageIds[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        grid.setOnItemClickListener((parent,view,position,id) -> switcher.setImageResource(imageIds[position]));
    }
}
