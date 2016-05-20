package com.view.sg.test.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.view.sg.test.R;
import com.view.sg.test.util.LogUtil;

public class TestFragment1 extends TestFragment {

    public TestFragment1() {
        // Required empty public constructor
        LogUtil.log("TestFragment1 Constructor...");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        LogUtil.log("TestFragment1 onAttach...");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.log("TestFragment1 onCreate...");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LogUtil.log("TestFragment1 onCreateView...");
        return inflater.inflate(R.layout.fragment_test_fragment1, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LogUtil.log("TestFragment1 onViewCreated...");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogUtil.log("TestFragment1 onActivityCreated...");
    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtil.log("TestFragment1 onStart...");
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtil.log("TestFragment1 onResume...");
    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtil.log("TestFragment1 onPause...");
    }

    @Override
    public void onStop() {
        super.onStop();
        LogUtil.log("TestFragment1 onStop...");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LogUtil.log("TestFragment1 onDestroyView...");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtil.log("TestFragment1 onDestroy...");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        LogUtil.log("TestFragment1 onDetach...");
    }

}
