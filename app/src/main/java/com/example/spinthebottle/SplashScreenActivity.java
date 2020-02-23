package com.example.spinthebottle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splash = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(splash);
                overridePendingTransition(R.transition.fade_in,R.transition.fade_out);
                finish();
            }
        },1000);
    }
}
