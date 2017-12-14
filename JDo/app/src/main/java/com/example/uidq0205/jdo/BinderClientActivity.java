package com.example.uidq0205.jdo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by uidq0205 on 2017-12-14.
 */

public class BinderClientActivity extends Activity {
    private static final String TAG = "BinderClientActivity";
    ProxyService mService;
    private Button cBtn;
    private TextView mStatusPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.printer_activity);
        setTitle("Binder client Activity");
        mStatusPanel =  findViewById(R.id.status);
        cBtn= findViewById(R.id.play);
        cBtn.setText("Print via extending Binder");
        cBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: null");
                if (mService == null) {
                    return;
                }
                Log.d(TAG, "onClick: ");
                mService.print("Tree of liberty must be refreshed from time to time with blood of patroits and tyrants",
                        mStatusPanel);
            }
        });
        Log.d(TAG, "onCreate: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        doBindService();
    }

    private void doBindService() {
        Intent intent = new Intent(this, BinderPrinterService.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
        Log.d(TAG, "doBindService: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        doUnbindService();
    }

    private void doUnbindService() {
        if (mService != null) {
            unbindService(mConnection);
        }
    }

    private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            mService = (ProxyService) iBinder;
            Log.d(TAG, "mConnection: ");
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            mService = null;
        }
    };
}
