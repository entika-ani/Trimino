package com.example.trimino;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView sumTextView;
    private int initialSum = 100; // Изначальная сумма

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sumTextView = findViewById(R.id.sumTextView);
        sumTextView.setText("Coins: " + initialSum);
    }

    public void startNEWActivity(View v) {
        Intent intent = new Intent(this, games.class);
        startActivity(intent);
    }

    public void openWheel(View v) {
        Intent intent = new Intent(this, Wheeel.class);
        startActivity(intent);
    }

    public void startStories(View v) {
        Intent intent = new Intent(this, Stories.class);
        startActivity(intent);
    }

    public void game(View v) {
        Intent intent = new Intent(this, GamePlay1.class);
        startActivity(intent);
    }

    public void startAbout(View v) {
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }

    public void startLetters(View v) {
        Intent intent = new Intent(this, Tellephone.class);
        startActivity(intent);
    }

    public void ah(View view) {
        initialSum += 50; // Добавляем 50 к изначальной сумме
        sumTextView.setText("Coins: " + initialSum); // Обновляем текст в TextView
    }

    public void ahh(View view) {
        initialSum += 100; // Добавляем 100 к изначальной сумме
        sumTextView.setText("Coins: " + initialSum); // Обновляем текст в TextView
    }
}
