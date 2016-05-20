package com.view.sg.activityseries;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.view.sg.activityseries.preference.PreferenceActivityTest;

/**
 * LauncherActivity继承ListActivity,重写Intent intentForPosition(int position)方法，该方法根据不同列表项返回不同的Intent
 */
public class MainActivity extends LauncherActivity {
    //定义Activity的名称
    String[] names = {"设置程序参数"};
    //定义Activity对应的实现类
    Class[] classes = {PreferenceActivityTest.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, names);
        setListAdapter(arrayAdapter);
    }

    @Override
    protected Intent intentForPosition(int position) {
        return new Intent(this,classes[position]);
    }
}
