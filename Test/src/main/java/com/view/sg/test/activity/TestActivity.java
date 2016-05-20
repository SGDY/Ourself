package com.view.sg.test.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.view.sg.test.Constant;
import com.view.sg.test.R;
import com.view.sg.test.fragment.TestFragment;
import com.view.sg.test.fragment.TestFragment1;
import com.view.sg.test.fragment.TestFragment2;
import com.view.sg.test.util.LogUtil;

public class TestActivity extends FragmentActivity implements TestFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout_2, new TestFragment2());
        transaction.commit();

        LogUtil.log("TestActivity onCreate...");
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        LogUtil.log("TestActivity onFragmentInteraction...");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        LogUtil.log("TestActivity onBackPressed...");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(Constant.TAG, "TestActivity onStart ...");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(Constant.TAG, "TestActivity onRestart ...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(Constant.TAG, "TestActivity onResume ...");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(Constant.TAG, "TestActivity onPause ...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(Constant.TAG, "TestActivity onStop ...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(Constant.TAG, "TestActivity onDestroy ...");
    }
}
