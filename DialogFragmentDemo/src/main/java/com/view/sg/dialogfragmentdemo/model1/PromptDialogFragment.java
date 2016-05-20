package com.view.sg.dialogfragmentdemo.model1;

import android.app.DialogFragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.view.sg.dialogfragmentdemo.MainActivity1;
import com.view.sg.dialogfragmentdemo.R;

/**
 * @author sg
 * @version 1.0
 * @description 自定义布局提示框
 * @createDate 2015/12/5
 */
public class PromptDialogFragment extends DialogFragment {

    private EditText et = null;

    public static PromptDialogFragment newInstance(String prompt) {
        PromptDialogFragment pdf = new PromptDialogFragment();
        Bundle b = new Bundle();
        b.putString("prompt-message", prompt);
        pdf.setArguments(b);
        return pdf;
    }

    private String getPrompt(){
        Bundle b = getArguments();
        return b.getString("prompt-message");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.prompt_dialog, container, false);

        TextView tv = (TextView)v.findViewById(R.id.prompt_message);
        tv.setText(getPrompt());

        et = (EditText)v.findViewById(R.id.input_text);
        if(savedInstanceState != null){
            CharSequence text = savedInstanceState.getCharSequence("input");
            et.setText(text == null ? "" : text);
        }

        MainActivity1 act = (MainActivity1)getActivity();

        v.findViewById(R.id.button_save).setOnClickListener(view -> {
            act.onDialogDone(getTag(), false, "[save]" + et.getText()); //调用activity的onDialogDone()，通过Toast显示相关信息
            dismiss(); //关闭对话框，并触发onDismiss()回调函数
        });
        v.findViewById(R.id.button_dismiss).setOnClickListener(view -> {
            act.onDialogDone(getTag(), true, null);  //调用activity的onDialogDone()，通过Toast显示相关信息
            dismiss();  //关闭对话框，并触发onDismiss()回调函数。
        });
        v.findViewById(R.id.button_help).setOnClickListener(view -> {
            FragmentTransaction ft  = getFragmentManager().beginTransaction();
             /* 如果不执行remove()，prompt dailog在下层，跟踪状态，
             系统即不会进入onDismiss()状态。主要考虑美观的问题，如果下面prompt对话框大于帮助框，视觉效果不好。
             对于Dialog，container为0或者null。 */
            ft.remove(this);
             /* 将当前的PromptDialogFragment加入到回退堆栈，当用户按返回键，
             或者通过按帮助框的Close按钮dismiss帮助框是，重新显示提示框。
             对于back stack的处理，系统具有一定的智能。
             例如：执行两次addToStackStack()，实际不会重复压栈。
             又例如：注释掉remove()语句，即提示框不消失，而是在帮助框的下面，由于提示框存在，
             我们并不需要将提示框键入到back stack，但是在实验中发现是否有addToBackStack()都不会结果有影响，
             系统能够分析到对象存在，不需要压栈。没有去查源代码，猜测通过mBackStackId比对来进行智能处理。*/
            ft.addToBackStack(null);
            HelpDialogFragment hdf = new HelpDialogFragment();
        /* 对fragment的处理是通过fragment transaction，与在activity弹框一样，通过show()方式实现。 在此之前，我们已经通过transaction将当前的fragment加入到back stack中。*/
            hdf.show(ft, MainActivity1.HELP_DIALOG_TAG);
        });

        return v;
    }

    @Override //在onCreate中设置对话框的风格、属性等
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //如果setCancelable()中参数为true，若点击dialog覆盖不到的activity的空白或者按返回键，则进行cancel，状态检测依次onCancel()和onDismiss()。如参数为false，则按空白处或返回键无反应。缺省为true
        setCancelable(true);
        //可以设置dialog的显示风格，如style为STYLE_NO_TITLE，将被显示title。遗憾的是，我没有在DialogFragment中找到设置title内容的方法。theme为0，表示由系统选择合适的theme。
        int style = DialogFragment.STYLE_NO_TITLE, theme = 0;
        setStyle(style, theme);
    }

    @Override //仅用于状态跟踪
    public void onCancel(DialogInterface dialog) {
        showInfo("onCancel() is called");
        super.onCancel(dialog);
    }

    @Override  //仅用户状态跟踪
    public void onDismiss(DialogInterface dialog) {
        showInfo("onDismiss() is called");
        super.onDismiss(dialog);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putCharSequence("input", et.getText());
        super.onSaveInstanceState(outState);
    }

    private void showInfo(String s){
        Log.d("PromptDialogFragment", s);
    }
}
