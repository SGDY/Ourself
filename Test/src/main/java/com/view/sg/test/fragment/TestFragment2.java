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

public class TestFragment2 extends TestFragment {

    public TestFragment2() {
        // Required empty public constructor
        LogUtil.log("TestFragment2 Constructor...");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        LogUtil.log("TestFragment2 onAttach...");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.log("TestFragment2 onCreate...");
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout_1, new TestFragment1());
        transaction.commit();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        LogUtil.log("TestFragment2 onCreateView...");
        return inflater.inflate(R.layout.fragment_test_fragment2, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LogUtil.log("TestFragment2 onViewCreated...");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogUtil.log("TestFragment2 onActivityCreated...");
    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtil.log("TestFragment2 onStart...");
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtil.log("TestFragment2 onResume...");
    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtil.log("TestFragment2 onPause...");
    }

    @Override
    public void onStop() {
        super.onStop();
        LogUtil.log("TestFragment2 onStop...");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LogUtil.log("TestFragment2 onDestroyView...");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtil.log("TestFragment2 onDestroy...");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        LogUtil.log("TestFragment2 onDetach...");
    }
}
