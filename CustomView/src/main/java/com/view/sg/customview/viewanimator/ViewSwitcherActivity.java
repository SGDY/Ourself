package com.view.sg.customview.viewanimator;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.view.sg.customview.R;

import java.util.ArrayList;
import java.util.List;

public class ViewSwitcherActivity extends AppCompatActivity {
    //定义一个常量，用于显示每屏展示的应用程序数
    public static final int NUMBER_PER_SCREEN = 12;

    public static class DataItem {
        //应用程序名称
        public String dataName;
        //应用程序图标
        public Drawable drawable;
    }

    //保存系统所有应用程序的List集合
    private List<DataItem> items = new ArrayList<>();
    //记录当前正在显示第几屏的程序
    private int screenNo = -1;
    private int screenCount;//保存应用程序所占的总屏数
    ViewSwitcher viewSwitcher;

    LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_switcher);

        inflater = LayoutInflater.from(this);
        //创建一个包含40个元素的List集合，用于模拟包含40个应用程序
        for (int i = 0; i < 40; i++) {
            String label = String.valueOf(i);
            Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
            DataItem item = new DataItem();
            item.dataName = label;
            item.drawable = drawable;
            items.add(item);
        }
        //计算应用程序所占的总屏数
        screenCount = items.size() % NUMBER_PER_SCREEN == 0 ? items.size() / NUMBER_PER_SCREEN : items.size() / NUMBER_PER_SCREEN + 1;

        viewSwitcher = (ViewSwitcher) findViewById(R.id.viewSwitcher);
        viewSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                //实际上就是返回一个GridView组件
                return inflater.inflate(R.layout.slidelistview, null);
            }
        });
        next(null);
    }

    public void next(View view) {
        if (screenNo < screenCount - 1) {
            screenNo++;
            //为ViewSwitcher的组件显示过程设置动画
            viewSwitcher.setInAnimation(this, R.anim.slide_in_right);
            //为ViewSwitcher的组件隐藏过程设置动画
            viewSwitcher.setOutAnimation(this, R.anim.slide_out_left);
            ((GridView)viewSwitcher.getNextView()).setAdapter(adapter);
            //单击右边按钮，显示下一屏
            viewSwitcher.showNext();
        }
    }

    public void prev(View view) {
        if (screenNo > 0) {
            screenNo--;
            //为ViewSwitcher的组件显示过程设置动画
            viewSwitcher.setInAnimation(this, android.R.anim.slide_in_left);
            //为ViewSwitcher的组件隐藏过程设置动画
            viewSwitcher.setOutAnimation(this, android.R.anim.slide_out_right);
            ((GridView)viewSwitcher.getNextView()).setAdapter(adapter);
            //单击右边按钮，显示上一屏
            viewSwitcher.showPrevious();
        }
    }

    private BaseAdapter adapter = new BaseAdapter() {
        @Override
        public int getCount() {
            if (screenNo == screenCount - 1 && items.size() % NUMBER_PER_SCREEN != 0) {
                return items.size() % NUMBER_PER_SCREEN;
            }
            return NUMBER_PER_SCREEN;
        }

        @Override
        public DataItem getItem(int position) {
            return items.get(screenNo * NUMBER_PER_SCREEN + position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.labelicon, null);
            }
            ImageView imageView = (ImageView) convertView.findViewById(R.id.imageview);
            imageView.setImageDrawable(getItem(position).drawable);
            TextView textView = (TextView) convertView.findViewById(R.id.textview);
            textView.setText(getItem(position).dataName);
            return convertView;
        }
    };
}
