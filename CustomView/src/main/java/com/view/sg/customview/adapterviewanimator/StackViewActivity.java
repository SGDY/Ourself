package com.view.sg.customview.adapterviewanimator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.StackView;

import com.view.sg.customview.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StackViewActivity extends AppCompatActivity {

    StackView stackView;
    int[] imageIds = new int[]
            {
                    R.mipmap.bomb5, R.mipmap.bomb6, R.mipmap.bomb7
                    , R.mipmap.bomb8, R.mipmap.bomb9, R.mipmap.bomb10
                    , R.mipmap.bomb11, R.mipmap.bomb12, R.mipmap.bomb13
                    , R.mipmap.bomb14, R.mipmap.bomb15, R.mipmap.bomb16
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack_view);

        stackView = (StackView) findViewById(R.id.mStackView);
        // 创建一个List对象，List对象的元素是Map
        List<Map<String, Object>> listItems =
                new ArrayList<Map<String, Object>>();
        for (int i = 0; i < imageIds.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("image", imageIds[i]);
            listItems.add(listItem);
        }
        // 创建一个SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,
                listItems
                // 使用/layout/cell.xml文件作为界面布局
                , R.layout.cell, new String[]{"image"},
                new int[]{R.id.image1});
        stackView.setAdapter(simpleAdapter);
    }

    public void prev(View view) {
        // 显示上一个组件
        stackView.showPrevious();
    }

    public void next(View view) {
        // 显示下一个组件
        stackView.showNext();
    }
}
