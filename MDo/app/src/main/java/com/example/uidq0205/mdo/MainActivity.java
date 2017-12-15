package com.example.uidq0205.mdo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public  static  String TAG="MainActivity";
    private Button mMoBtn;
    private IDoService iDoService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMoBtn=findViewById(R.id.tMoBtn);
        mMoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    iDoService.pting();
                }catch (Exception es){
                    es.printStackTrace();
                }

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart ");
        Intent sIntent=new Intent(MainActivity.this,DoService.class);
        this.bindService(sIntent,serviceConnection,BIND_AUTO_CREATE);
    }

    private ServiceConnection serviceConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            iDoService=IDoService.Stub.asInterface(iBinder);
            Log.d(TAG, "serviceConnection: onServiceConnected ");
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            iDoService=null;
            Log.d(TAG, "serviceConnection: onServiceDisconnected ");
        }
    };
}
