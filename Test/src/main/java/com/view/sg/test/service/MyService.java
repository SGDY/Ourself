package com.view.sg.test.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import com.view.sg.test.Constant;

public class MyService extends Service {

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(Constant.TAG, "onCreate ...");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(Constant.TAG, "onStartCommand ...");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(Constant.TAG, "onDestroy ...");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(Constant.TAG, "onBind ...");
        return new MyBinder();
    }

    @Override
    public void onRebind(Intent intent) {
        Log.d(Constant.TAG, "onRebind ...");
        super.onRebind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(Constant.TAG, "onUnbind ...");
//        return super.onUnbind(intent);
        //默认返回false 但是onRebind()不会执行；返回true，在此绑定会执行onRebind(),必须startService和bindService都执行后，此方法才会调用
        return true;
    }

    class MyBinder extends Binder {
        public MyBinder() {
            Log.d(Constant.TAG, "MyBinder...");
        }
    }
}
