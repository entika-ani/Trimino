package com.example.trimino;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Wheeel extends AppCompatActivity {
    ImageView wheel, arrow;
    int rotation = 0, rotationSpeed = 5;
    int[] stopPosition = {720, 780, 840, 900, 960, 1020};
    int[] winPoints = {50, 10, 20, 100, 90, 70};
    int randPosition = 0;
    private boolean canSpin = true;
    static boolean again = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheeel);
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("total")) {
            int total = intent.getIntExtra("total", 0);
            intent.putExtra("coins", total); // Передаем значение total обратно в MainActivity
            startActivity(intent);
            again = false;
        }
        wheel = findViewById(R.id.wheel);
        arrow = findViewById(R.id.arrow);

        arrow.setOnClickListener(view -> {
            if (canSpin && again) {
                randPosition = new Random().nextInt(5 - 0) + 0;
                startSpin();

                new CountDownTimer(120000, 1000) {
                    public void onTick(long millisUntilFinished) {}

                    public void onFinish() {
                        canSpin = true;
                        again = true;
                    }
                }.start();

                canSpin = false;
                again = false;
            }
        });
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
                    showPopup(String.valueOf(winPoints[randPosition]));
                } else {
                    startSpin();
                }
            }
        }, 1);
    }

    public void showPopup(String points) {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.win_popup);
        dialog.setCancelable(true);
        dialog.show();

        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setGravity(Gravity.CENTER);

        TextView winText = dialog.findViewById(R.id.win_text);
        winText.setText("You won " + points + " points");

        int point = Integer.parseInt(points);
        // Используем контекст приложения для получения SharedPreferences
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        int total = sharedPreferences.getInt("total", 0);
        total += point; // Обновляем значение total
        // Сохраняем обновленное значение total в S
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("total", total);
        editor.apply();

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
