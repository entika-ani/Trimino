package com.example.trimino;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private TextView sumTextView;
    private int initialSum = 100;
    private SharedPreferences sharedPreferences;
    private int total = 0;
    private MediaPlayer mediaPlayer;
    private boolean isMediaPlayerRunning = false;
    private boolean isMusicPaused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        sumTextView = findViewById(R.id.sumTextView);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        total = sharedPreferences.getInt("total", 0);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("coins")) {
            int coins = intent.getIntExtra("coins", 0);
            total += coins;
            saveTotal(total);
        }

        sumTextView.setText("Coins: " + total);

        isMediaPlayerRunning = intent.getBooleanExtra("mediaPlayer", false);
        if (isMediaPlayerRunning) {
            mediaPlayer = MediaPlayer.create(this, R.raw.melodi);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
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
    protected void onResume() {
        super.onResume();
        if (isMediaPlayerRunning && isMusicPaused) {
            mediaPlayer.start();
            isMusicPaused = false;
        }
    }



    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
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

    public void toggleMusic(View view) {
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                isMusicPaused = true;
            } else if (isMusicPaused) {
                mediaPlayer.start();
                isMusicPaused = false;
            }
        }
    }

    public void ah(View view) {
        initialSum += 50;
        total += 50;
        saveTotal(total);
        sumTextView.setText("Coins: " + total);
    }

    public void ahh(View view) {
        initialSum += 100;
        total += 100;
        saveTotal(total);
        sumTextView.setText("Coins: " + total);
    }

    public void openWheel(View v) {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        isMediaPlayerRunning = true;
        Intent intent = new Intent(this, Wheeel.class);
        intent.putExtra("totalCoins", total);
        startActivity(intent);
    }

    public void startStories(View v) {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        isMediaPlayerRunning = true;
        Intent intent = new Intent(this, Stories.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            int selectedValue = data.getIntExtra("selectedValue", 0);
            initialSum += selectedValue;
            total += selectedValue;
            saveTotal(total);
            sumTextView.setText("Coins: " + total);
        }
    }

    public void startAbout(View v) {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        isMediaPlayerRunning =true;
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }

    public void startLetters(View v) {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        isMediaPlayerRunning = true;
        Intent intent = new Intent(this, SplashActivity2.class);
        startActivity(intent);
    }

    public void startNEWActivity(View v) {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        isMediaPlayerRunning = true;

        Intent intent = new Intent(this, Foniqar.class);
        startActivity(intent);
    }

    private void saveTotal(int total) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("total", total);
        editor.apply();
    }




    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isLoggedIn", false);
        editor.apply();
        finish();

        Intent intent = new Intent(this, Login.class);
        intent.putExtra("GuestMode", Login.GuestMode);
        startActivity(intent);
        finish();
    }
}
