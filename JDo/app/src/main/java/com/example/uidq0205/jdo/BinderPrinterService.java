package com.example.uidq0205.jdo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by uidq0205 on 2017-12-14.
 */

public class BinderPrinterService extends Service {
    private static final String TAG = "BinderPrinterService";
    private IBinder mBinder;

    @Override
    public void onCreate() {
        mBinder = new ProxyService(this);
        Log.d("BinderPrinterService", "onCreate: ");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public void print(String msg, TextView tv) {
        try {
            Log.e(TAG, "Preparing printer...");
            tv.setText("Preparing printer...");
            Thread.sleep(1000);
            Log.e(TAG, "Connecting printer...");
            tv.setText("Connecting printer...");
            Thread.sleep(1000);
            Log.e(TAG, "Printing.... " + msg);
            tv.setText("Printing.... ");
            Thread.sleep(1000);
            Log.e(TAG, "Done");
        } catch (InterruptedException e) {
        }
        tv.setText(msg);
        Toast.makeText(this, "Printing is done.", Toast.LENGTH_SHORT).show();
    }
}

class ProxyService extends Binder {
    private BinderPrinterService mService;

    public ProxyService(BinderPrinterService svc) {
        mService = svc;
    }

    public void print(String msg, TextView tv) {
        mService.print(msg, tv);
    }
}
