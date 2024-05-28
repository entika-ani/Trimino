package com.example.trimino;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import com.example.trimino.place.Place5x5;

public class Splash_sea extends AppCompatActivity {

    private static final int SPLASH_DISPLAY_LENGTH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_sea);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Splash_sea.this, Place5x5.class);
                i.putExtra("mediaPlayer", true);
                startActivity(i);
                finish();
            }
        }, 3000);
    }
}
