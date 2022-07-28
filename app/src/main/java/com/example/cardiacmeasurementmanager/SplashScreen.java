package com.example.cardiacmeasurementmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {
    private ProgressBar p;
    int pv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        p=(ProgressBar) findViewById(R.id.progressBarID);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                progress();
            }
        });
        thread.start();

        try{
            getSupportActionBar().hide();
        }catch (Exception e)
        {

        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this, MainActivity.class));
                finish();
            }
        },2000);
    }

    public void progress(){

        for(pv=1;pv<=100;pv++) {
            try{
                Thread.sleep(20);
                p.setProgress(pv);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}