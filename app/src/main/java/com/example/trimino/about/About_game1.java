package com.example.trimino.about;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.VideoView;
import com.example.trimino.MainActivity;
import com.example.trimino.R;
import com.example.trimino.Splash;

public class About_game1 extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private boolean isMediaPlayerRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_game1);

        View layout = findViewById(R.id.darkGreenLayout);

        VideoView videoView = findViewById(R.id.videoView);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.video1;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        videoView.start();

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false);
        boolean isGuestMode = sharedPreferences.getBoolean("isGuestMode", false);

        if (!isLoggedIn && !isGuestMode) {
            return;
        }

        // Check if we need to stop the music
        if (getIntent().getBooleanExtra("stopMusic", false)) {
            stopMusic();
        }

        Intent intent = getIntent();
        isMediaPlayerRunning = intent.getBooleanExtra("mediaPlayer", false);
        if (isMediaPlayerRunning) {
            mediaPlayer = MediaPlayer.create(this, R.raw.melodi);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
        }

        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    openMainActivity();
                    return true;
                }
                return false;
            }
        });
    }

    public void onSkipClick(View view) {
        openMainActivity();
    }

    private void openMainActivity() {
        Intent intent = new Intent(About_game1.this, MainActivity.class);
        intent.putExtra("mediaPlayer", isMediaPlayerRunning);  // передаем флаг в MainActivity
        startActivity(intent);
        finish();
    }

    private void stopMusic() {
        if (Splash.mediaPlayer != null && Splash.mediaPlayer.isPlaying()) {
            Splash.mediaPlayer.stop();
            Splash.mediaPlayer.release();
            Splash.mediaPlayer = null;
        }
    }
}
