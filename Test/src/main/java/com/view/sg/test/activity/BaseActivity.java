package com.view.sg.test.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.view.sg.test.Constant;

public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(Constant.TAG, "BaseActivity onCreate ..." + this.toString());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(Constant.TAG, "BaseActivity onStart ...");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(Constant.TAG, "BaseActivity onRestart ...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(Constant.TAG, "BaseActivity onResume ...");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(Constant.TAG, "BaseActivity onPause ...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(Constant.TAG, "BaseActivity onStop ...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(Constant.TAG, "BaseActivity onDestroy ...");
    }
}
