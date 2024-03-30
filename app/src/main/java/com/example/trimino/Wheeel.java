package com.example.trimino;



import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
import android.widget.Toast;

import com.example.trimino.R;

import java.util.ArrayList;
import java.util.Random;

public class Wheeel extends AppCompatActivity {
    ImageView wheel, arrow;
    int rotation = 0, rotationSpeed = 5;
    int[] stopPosition = {720, 780, 840, 900, 960, 1020}; // 780 position = 10 points
    int[] winPoints = {50, 10, 20, 100, 90, 70};
    int randPosition = 0;
    static boolean again = true;

    static int total = 0;
    private boolean canSpin = true;
    static ArrayList<Integer> coins = new ArrayList<>();
    static int point = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheeel);

        wheel = findViewById(R.id.wheel);
        arrow = findViewById(R.id.arrow);

        arrow.setOnClickListener(view -> {
            again = true;
            if (canSpin && again == true) {
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
                // Control the wheel spinning speed
                if (rotation >= 300) {
                    // slow the wheel
                    rotationSpeed = 4;
                }
                if (rotation >= 400) {
                    // slow the wheel
                    rotationSpeed = 3;
                }
                if (rotation >= 500) {
                    // slow the wheel
                    rotationSpeed = 2;
                }

                rotation = rotation + rotationSpeed;
                if (rotation >= stopPosition[randPosition]) {
                    // Stop the wheel
                    showPopup(String.valueOf(winPoints[randPosition]));
                } else {
                    startSpin(); // Loop this function in order to change wheel rotation
                }
            }
        }, 1); // This timer will run every one milliseconds
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
        point = Integer.parseInt(points);
        coins.add(point);

        for (int i = 0; i < coins.size(); i++) {
            total += coins.get(i);

        }






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
