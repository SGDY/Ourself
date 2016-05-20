package com.view.sg.customview.imageview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.QuickContactBadge;

import com.view.sg.customview.R;

public class QuickContactBadgeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_contact_badge);
        // 获取QuickContactBadge组件
        QuickContactBadge badge = (QuickContactBadge) findViewById(R.id.badge);
        // 将QuickContactBadge组件与特定电话号码对应的联系人建立关联
        badge.assignContactFromPhone("12345678",false);

    }
}
