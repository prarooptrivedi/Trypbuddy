package com.example.praroop.trypbuddycom.Views;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.praroop.trypbuddycom.R;

import java.util.Timer;
import java.util.TimerTask;

import cc.cloudist.acplibrary.ACProgressConstant;
import cc.cloudist.acplibrary.ACProgressFlower;

public class Splash_Activity extends AppCompatActivity {
    ACProgressFlower dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        dialog = new ACProgressFlower.Builder(Splash_Activity.this)
                .direction(ACProgressConstant.DIRECT_CLOCKWISE)
                .themeColor(Color.WHITE)
                .text("Loading...")
                .fadeColor(Color.DKGRAY).build();
        dialog.show();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent i=new Intent(Splash_Activity.this,Activity_Register.class);
                startActivity(i);
                finish();
            }
        };
        Timer t = new Timer();
        t.schedule(task,2000);
    }
}
