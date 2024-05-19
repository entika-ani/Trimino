package com.example.trimino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class Splash extends AppCompatActivity {
    TextView appname;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        appname = findViewById(R.id.appname);
        appname.animate().translationY(-1300).setDuration(2700).setStartDelay(3);
        mediaPlayer = MediaPlayer.create(this, R.raw.hero);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Splash.this, Login.class);
                i.putExtra("mediaPlayer", true);
                startActivity(i);
                finish();
            }
        }, 4000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
