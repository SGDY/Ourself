package com.view.sg.activityseries.preference;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.widget.Button;
import android.widget.Toast;

import com.view.sg.activityseries.R;

import java.util.List;

/**
 * @author sg
 * @version 1.0
 * @description PreferenceActivity不再使用普通的界面布局文件，而是使用选项设置的布局文件。
 * 布局文件以PreferenceScreen作为根元素-它表明定义一个参数设置的界面布局。
 * @createDate 2016/1/1
 */
public class PreferenceActivityTest extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //该方法用于为该界面设置一个标题按钮
        if (hasHeaders()) {
            Button button = new Button(this);
            button.setText("设置操作");
            //将该按钮添加到该界面上
            setListFooter(button);
        }
    }

    //重写该方法，负责加载界面布局文件
    @Override
    public void onBuildHeaders(List<Header> target) {
        //加载选项设置列表的布局文件
        loadHeadersFromResource(R.xml.preference_headers, target);
    }

    //重写该方法，验证各PreferenceFragment是否有效
    @Override
    protected boolean isValidFragment(String fragmentName) {
        return true;
    }

    //PreferenceFragment负责加载选项设置的布局文件
    public static class Prefs1Fragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);
        }
    }

    public static class Prefs2Fragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.display_prefs);
            String website = getArguments().getString("website");
            Toast.makeText(getActivity(), "网站域名是: " + website, Toast.LENGTH_SHORT).show();
        }
    }
}
