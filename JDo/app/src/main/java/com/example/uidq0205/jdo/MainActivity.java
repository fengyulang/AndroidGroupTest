package com.example.uidq0205.jdo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.printer_activity);
        Intent itoC=new Intent();
        itoC.setClass(MainActivity.this,BinderClientActivity.class);
        startActivity(itoC);
        Log.d("MainActivity", "onCreate: ");
    }
}
