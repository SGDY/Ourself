package com.view.sg.dialogfragmentdemo.model1;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

import com.view.sg.dialogfragmentdemo.MainActivity1;

/**
 * @author sg
 * @version 1.0
 * @description 自定义警告提示框
 * @createDate 2015/12/5
 */
public class AlterDialogFragment extends DialogFragment implements DialogInterface.OnClickListener{
    /*【步骤1】：通过newInstance()创建实例，并返回，这里的处理和系统从save状态中re-create相同。
     * 1、通过缺省构造函数创建对象
     * 2、将传递的信息设置为fragment的参数
     * 3、返回对象
     * */
    public static AlterDialogFragment newInstance(String title, String message) {
        AlterDialogFragment adf = new AlterDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("alert-title", title);
        bundle.putString("alert-message", message);
        adf.setArguments(bundle);
        return adf;
    }

    private String getTitle(){
        return getArguments().getString("alert-title");
    }

    private String getMessage(){
        return getArguments().getString("alert-message");
    }

    /* 【步骤2】创建view可以通过两个途径，一是fragment中的onCreateView()，二是DialogFragment中的onCreateDialog()。
    * 前者适合对自定义的layout进行设置，具有更大的灵活性
    * 而后者适合对简单dialog进行处理，可以利用Dialog.Builder直接返回Dialog对象
    * 从生命周期的顺序而言，先执行onCreateDialog()，后执行oonCreateView()，我们不应同时使用两者。
    * */
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder b = new AlertDialog.Builder(getActivity())
                .setTitle(getTitle())
                .setMessage(getMessage())
                .setPositiveButton("OK", this)  //设置回调函数
                .setNegativeButton("Cancel",this); //设置回调函数
        return b.create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        boolean isCancel = false;
        if(which == AlertDialog.BUTTON_NEGATIVE){ //判断用户所按何键
            isCancel = true;
        }
        MainActivity1 act = (MainActivity1) getActivity();
        act.onDialogDone(getTag(), isCancel, "CLick OK, Alert dismissed");
    }
}
