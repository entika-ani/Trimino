package com.example.trimino;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Wheeel extends AppCompatActivity {
    ImageView wheel, arrow;
    int rotation = 0, rotationSpeed = 5;
    int[] stopPosition = {720, 780, 840, 900, 960, 1020};

    private MediaPlayer mediaPlayer;
    private boolean isMediaPlayerRunning = false;
    private boolean isMusicPaused = false;
    String[] messages = {
            "There's nothing shameful about being different from others.",
            "The most important person for you is yourself.",
            "If the path is chosen, move forward.",
            "To be a genius, repeat. To create miracles, believe.",
            "They say life begins today.",
            "It's hard to defeat a person who never gives up.",
            "Like it or not, you're not alone.",
            "To achieve perfection, one must forget about it.",
            "Everything will end someday, but today let's work even harder.",
            "Everything in this life has its time.",
            "Truly happy is not the one who smiles at the end, but the one who smiles as often as possible.",
            "With the realization that there are those who care about them nearby, people will never be alone.",
            "Behind sadness always comes happiness.",
            "Sometimes you need to take a step back in order to then take two forward.",
            "It hurts the most when you can't follow your heart.",
            "Try, create, but never give up",
            "When you feel sad, look at the stars.",
            "Mistakes lead to success."
    };
    int randPosition = 0;
    private boolean canSpin = true;
    static boolean again = true;

    private static final String SHARED_PREFS = "sharedPrefs";
    private static final String LAST_SPUN_TIME = "lastSpunTime";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheeel);

        wheel = findViewById(R.id.wheel);
        arrow = findViewById(R.id.arrow);

        arrow.setOnClickListener(view -> {
            if (canSpin && again) {
                long lastSpunTime = getLastSpunTime();
                long currentTime = System.currentTimeMillis();

                if (currentTime - lastSpunTime >= 24 * 60 * 60 * 1000) {
                    randPosition = new Random().nextInt(6);
                    startSpin();
                    saveLastSpunTime(currentTime);

                    canSpin = false;
                    again = false;
                }
            }
        });
        Intent intent = getIntent();
        isMediaPlayerRunning = intent.getBooleanExtra("mediaPlayer", false);
        if (isMediaPlayerRunning) {
            mediaPlayer = MediaPlayer.create(this, R.raw.aniv);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
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
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    private long getLastSpunTime() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        return sharedPreferences.getLong(LAST_SPUN_TIME, 0);
    }

    private void saveLastSpunTime(long time) {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(LAST_SPUN_TIME, time);
        editor.apply();
    }

    public void startSpin() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                wheel.setRotation(rotation);
                if (rotation >= 300) {
                    rotationSpeed = 4;
                }
                if (rotation >= 400) {
                    rotationSpeed = 3;
                }
                if (rotation >= 500) {
                    rotationSpeed = 2;
                }

                rotation = rotation + rotationSpeed;
                if (rotation >= stopPosition[randPosition]) {
                    showPopup();
                } else {
                    startSpin();
                }
            }
        }, 1);
    }

    public void showPopup() {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.win_popup);
        dialog.setCancelable(true);
        dialog.show();

        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setGravity(Gravity.CENTER);

        TextView winText = dialog.findViewById(R.id.win_text);
        Random random = new Random();
        String message = messages[random.nextInt(messages.length)]; // Выбор случайного сообщения
        winText.setText(message);

        Button btn = dialog.findViewById(R.id.button);
        btn.setOnClickListener(view -> {
            dialog.cancel();
            rotation = 0;
            rotationSpeed = 5;
            randPosition = 0;
        });
    }

    public void back(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        again = false;
        finish();
    }
}

