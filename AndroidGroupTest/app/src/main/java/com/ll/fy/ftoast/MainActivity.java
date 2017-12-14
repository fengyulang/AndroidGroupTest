package com.ll.fy.ftoast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private Toast fylToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.btn_toast);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fylToast=Toast.makeText(getApplicationContext(),"Hello fengyulang",5000);
                fylToast.setGravity(Gravity.LEFT,100,-100);
                fylToast.show();
            }
        });
    }
}
