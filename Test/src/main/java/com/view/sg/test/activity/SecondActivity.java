package com.view.sg.test.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import com.view.sg.test.Constant;
import com.view.sg.test.R;
import com.view.sg.test.service.MyService;

public class SecondActivity extends BaseActivity {

    Intent intent;

    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(Constant.TAG, "SecondActivity onCreate ...");
        intent = new Intent(this, MyService.class);
        findViewById(R.id.btn_start_service).setOnClickListener(v -> startService(intent));
        findViewById(R.id.btn_stop_service).setOnClickListener(v -> stopService(intent));
        findViewById(R.id.btn_bind_service).setOnClickListener(v -> bindService(intent, conn, BIND_AUTO_CREATE));
        findViewById(R.id.btn_unbind_service).setOnClickListener(v -> unbindService(conn));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(Constant.TAG, "SecondActivity onStart ...");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(Constant.TAG, "SecondActivity onRestart ...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(Constant.TAG, "SecondActivity onResume ...");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(Constant.TAG, "SecondActivity onPause ...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(Constant.TAG, "SecondActivity onStop ...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(Constant.TAG, "SecondActivity onDestroy ...");
    }
}
