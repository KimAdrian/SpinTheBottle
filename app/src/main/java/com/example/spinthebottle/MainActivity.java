package com.example.spinthebottle;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView bottle;
    private final Random random = new Random();
    private int lastDir;
    private boolean spinning;
    AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize ad id
        MobileAds.initialize(this, initializationStatus -> {
        });

        bottle = findViewById(R.id.bottle);
        bottle.setOnClickListener(v -> spinbottle());

        adView = findViewById(R.id.adView);
        //Test Id
        //TODO: Exchange with adUnitId production before release
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

    }

    private void spinbottle() {
        if (!spinning) {
            int newDir = random.nextInt(1800);
            float X = bottle.getWidth() / 2;
            float Y = bottle.getHeight() / 2;

            Animation rotate = new RotateAnimation(lastDir, newDir, X, Y);
            rotate.setDuration(3000);
            rotate.setFillAfter(true);
            rotate.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    spinning = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    spinning = false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

            lastDir = newDir;
            bottle.startAnimation(rotate);

        }
    }
}