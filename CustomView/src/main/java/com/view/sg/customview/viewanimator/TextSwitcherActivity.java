package com.view.sg.customview.viewanimator;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.view.sg.customview.R;

public class TextSwitcherActivity extends AppCompatActivity {

    TextSwitcher textSwitcher;
    String[] strs = new String[]
            {
                    "疯狂Java讲义",
                    "轻量级Java EE企业应用实战",
                    "疯狂Android讲义",
                    "疯狂Ajax讲义"
            };
    int curStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_switcher);

        textSwitcher = (TextSwitcher) findViewById(R.id.textSwitcher);
        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            public View makeView() {
                TextView tv = new TextView(TextSwitcherActivity.this);
                tv.setTextSize(40);
                tv.setTextColor(Color.MAGENTA);
                return tv;
            }
        });
        // 调用next方法显示下一个字符串
        next(null);
    }

    // 事件处理函数，控制显示下一个字符串
    public void next(View source) {
        textSwitcher.setText(strs[curStr++ % strs.length]);  // ①
    }
}
