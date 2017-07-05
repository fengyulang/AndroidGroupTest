package com.ll.fy.ftoast;

import android.content.Context;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by uidq0205 on 2017/6/21.
 */

public class FylToast {
    private Toast mToast;
    private static long lastTime=0;
    private int showDuration;
    private static CharSequence lastText;
    private static CharSequence nowText;

    private FylToast(Context context, CharSequence text, int duration) {
        View v = LayoutInflater.from(context).inflate(R.layout.fyl_toast, null);
        TextView textView = (TextView) v.findViewById(R.id.textToast);
        textView.setText(text);
        showDuration=duration;
        if (duration==0){
            showDuration=2000;
        }
        if (duration==1){
            showDuration=4000;
        }
        nowText=text;
        mToast = new Toast(context);
        mToast.setDuration(duration);
        mToast.setView(v);
    }

    public static FylToast makeText(Context context, CharSequence text, int duration) {
        return new FylToast(context, text, duration);
    }

    public void show() {
        Log.d("0205", "show: "+lastText+" "+lastTime+" "+ nowText+" "+System.currentTimeMillis()+" "+showDuration);
        if (!nowText.equals(lastText) && mToast!=null){
            Log.d("0205+", "show: 1");
            mToast.show();
            lastTime=System.currentTimeMillis();
            lastText=nowText;
        }else {
            if((System.currentTimeMillis()-lastTime)>showDuration && mToast != null){
                Log.d("0205+", "show: 2");
                mToast.show();
                lastTime=System.currentTimeMillis();
                lastText=nowText;
            }
        }
    }

    public void setGravity(int gravity, int xOffset, int yOffset) {
        if (mToast != null) {
            mToast.setGravity(gravity, xOffset, yOffset);
        }
    }
}