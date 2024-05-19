package com.example.trimino;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity2 extends AppCompatActivity {

    private static final int SPLASH_DISPLAY_LENGTH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                int proceedToTellephone = getIntent().getIntExtra("proceedToTellephone", 0);
                Intent mainIntent;
                if (proceedToTellephone == 1) {
                    mainIntent = new Intent(SplashActivity2.this, Tellephone.class);
                } else {
                    mainIntent = new Intent(SplashActivity2.this, Telefono.class);
                }
                startActivity(mainIntent);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
