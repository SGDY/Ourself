package com.view.sg.aidlservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class CalculateService extends Service {
    public CalculateService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    private CalculateInterface.Stub mBinder = new CalculateInterface.Stub() {
        @Override
        public double doCalculate(double a, double b) throws RemoteException {
            return a + b;
        }
    };
}
