package com.example.trimino;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.example.trimino.about.About_game1;

public class Splash extends AppCompatActivity {
    TextView appname;
    public static MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        appname = findViewById(R.id.appname);
        appname.animate().translationY(-2000).setDuration(3000).setStartDelay(3);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Splash.this, About_game1.class);
                startActivity(i);
                finish();
            }
        }, 4000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
