package com.view.sg.test.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.util.Log;
import android.widget.TextView;

import com.view.sg.test.Constant;
import com.view.sg.test.R;
import com.view.sg.test.service.MyService;

public class MainActivity extends BaseActivity {

    Intent intent;
    TextView tv;


    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(Constant.TAG, "onServiceConnected ...");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(Constant.TAG, "MainActivity onCreate ..." + this.toString());


        tv = (TextView) findViewById(R.id.tv);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append("Hello");
        spannableStringBuilder.insert(0, "\b\b\b\b", 0, 4);
        Drawable drawable = ContextCompat.getDrawable(this, R.mipmap.blue);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        ImageSpan span = new ImageSpan(drawable, ImageSpan.ALIGN_BASELINE);
        spannableStringBuilder.setSpan(span,0,1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        spannableStringBuilder.insert(0, "\b\b\b\b", 0, 4);
        Drawable drawable2 = ContextCompat.getDrawable(this, R.mipmap.blue);
        drawable2.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        ImageSpan span2 = new ImageSpan(drawable2, ImageSpan.ALIGN_BASELINE);
        spannableStringBuilder.setSpan(span2,0,1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv.setText(spannableStringBuilder);

        intent = new Intent(this, MyService.class);

        findViewById(R.id.btn_start_service).setOnClickListener(v -> startService(intent));
        findViewById(R.id.btn_stop_service).setOnClickListener(v -> stopService(intent));
        findViewById(R.id.btn_bind_service).setOnClickListener(v -> bindService(intent, conn, BIND_AUTO_CREATE));
        findViewById(R.id.btn_unbind_service).setOnClickListener(v -> unbindService(conn));
        findViewById(R.id.btn_start_activity).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, SecondActivity.class)));
        findViewById(R.id.btn_test_activity).setOnClickListener(v -> startActivity(new Intent(MainActivity.this,TestActivity.class)));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(Constant.TAG, "MainActivity onStart ...");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(Constant.TAG, "MainActivity onRestart ...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(Constant.TAG, "MainActivity onResume ...");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(Constant.TAG, "MainActivity onPause ...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(Constant.TAG, "MainActivity onStop ...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(Constant.TAG, "MainActivity onDestroy ...");
    }
}
