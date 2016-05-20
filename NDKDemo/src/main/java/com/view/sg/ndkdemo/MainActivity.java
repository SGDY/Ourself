package com.view.sg.ndkdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = (TextView) findViewById(R.id.tv);
        tv.setText(getStringFromNative());
    }

    public native String getStringFromNative();

    static {
        System.loadLibrary("ourSelfJni");
    }
}
