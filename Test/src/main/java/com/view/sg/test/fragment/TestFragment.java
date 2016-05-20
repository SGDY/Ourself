package com.view.sg.test.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.view.sg.test.util.LogUtil;

public class TestFragment extends Fragment {

    protected OnFragmentInteractionListener mListener;

    public TestFragment() {
        // Required empty public constructor
        LogUtil.log("TestFragment Constructor...");
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        LogUtil.log("TestFragment onAttach...");
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.log("TestFragment onCreate...");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LogUtil.log("TestFragment onCreateView...");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        LogUtil.log("TestFragment onViewCreated...");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        LogUtil.log("TestFragment onActivityCreated...");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        LogUtil.log("TestFragment onStart...");
        super.onStart();
    }

    @Override
    public void onResume() {
        LogUtil.log("TestFragment onResume...");
        super.onResume();
    }

    @Override
    public void onPause() {
        LogUtil.log("TestFragment onPause...");
        super.onPause();
    }

    @Override
    public void onStop() {
        LogUtil.log("TestFragment onStop...");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        LogUtil.log("TestFragment onDestroyView...");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        LogUtil.log("TestFragment onDestroy...");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        LogUtil.log("TestFragment onDetach...");
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
