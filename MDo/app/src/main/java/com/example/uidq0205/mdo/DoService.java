package com.example.uidq0205.mdo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by uidq0205 on 2017-12-15.
 */

public class DoService extends Service {
    private static final String TAG = "DoService";
    private String mainKey="F8HM9HGH0HL";
    public DoService() {
        super();
    }

    IDoService.Stub mBinder=new IDoService.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {
            
        }

        @Override
        public void pting() throws RemoteException {
            Log.d(TAG, "pting: i am aidl pting "+mainKey);
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
