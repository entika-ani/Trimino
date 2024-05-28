package com.example.trimino;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.trimino.about.About_game1;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private boolean isMusicPaused = false;
    private static final String PREFS_NAME = "MyPrefs";
    private static final String MUSIC_STATE = "musicState";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        boolean shouldPlayMusic = sharedPreferences.getBoolean(MUSIC_STATE, true);

        if (shouldPlayMusic) {
            startMusic();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isMusicPaused) {
            mediaPlayer.start();
            isMusicPaused = false;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            isMusicPaused = true;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        releaseMediaPlayer();
    }

    public void toggleMusic(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                isMusicPaused = true;
                editor.putBoolean(MUSIC_STATE, false);
            } else if (isMusicPaused) {
                mediaPlayer.start();
                isMusicPaused = false;
                editor.putBoolean(MUSIC_STATE, true);
            }
        } else {
            startMusic();
            editor.putBoolean(MUSIC_STATE, true);
        }
        editor.apply();
    }

    private void startMusic() {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this, R.raw.melodi);
            mediaPlayer.setLooping(true);
        }
        mediaPlayer.start();
    }

    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    public void openWheel(View v) {
        stopMediaPlayer();
        Intent intent = new Intent(this, Splash_wheel.class);
        startActivity(intent);
    }

    public void startStories(View v) {
        stopMediaPlayer();
        Intent intent = new Intent(this, Stories.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
        }
    }

    public void startAbout(View v) {
        stopMediaPlayer();
        Intent intent = new Intent(this, About_game1.class);
        startActivity(intent);
    }

    public void startLetters(View v) {
        stopMediaPlayer();
        Intent intent = new Intent(this, SplashActivity2.class);
        startActivity(intent);
    }

    public void startNEWActivity(View v) {
        stopMediaPlayer();
        Intent intent = new Intent(this, Foniqar.class);
        startActivity(intent);
    }

    private void stopMediaPlayer() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        isMusicPaused = false;  // Reset the pause state
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(MUSIC_STATE, false);
        editor.apply();
    }
}
