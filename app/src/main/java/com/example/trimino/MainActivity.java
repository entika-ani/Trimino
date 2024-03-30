package com.example.trimino;

import static com.example.trimino.Syu1_verj.x;
import static com.example.trimino.Wheeel.again;
import static com.example.trimino.Wheeel.total;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView sumTextView;
    private int initialSum = 100;


    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sumTextView = findViewById(R.id.sumTextView);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        initialSum = sharedPreferences.getInt("initialSum", 100); // Значение по умолчанию - 100
        sumTextView.setText("Coins: " + initialSum);

        // Получаем количество монет из SharedPreferences
        SharedPreferences prefs = getSharedPreferences("coin_prefs", MODE_PRIVATE);
        int coinsFromSy1_1 = prefs.getInt("coins_sy1_1", 0); // Получаем количество монет из Syu1.1
        int coinsFromSy1_2 = prefs.getInt("coins_sy1_2", 0); // Получаем количество монет из Syu1.2
        // Вычисляем общее количество монет
        if (x == true){
            initialSum = 150;
        }
        else {
            initialSum = 0;
        }
        initialSum += total;
        total = 0;

        sumTextView.setText("Coins: " + initialSum);
    }

    // Метод для сохранения initialSum в SharedPreferences
    private void saveInitialSum(int sum) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("initialSum", sum);
        editor.apply();
    }

    // Ваши методы обработки нажатия кнопок
    public void ah(View view) {
        initialSum += 50;
        saveInitialSum(initialSum);
        sumTextView.setText("Coins: " + initialSum);
    }

    public void ahh(View view) {
        initialSum += 100;
        saveInitialSum(initialSum);
        sumTextView.setText("Coins: " + initialSum);
    }




    public void startNEWActivity(View v) {
        Intent intent = new Intent(this, games.class);
        startActivity(intent);
    }

    public void openWheel(View v) {
        if (again == true){
            Intent intent = new Intent(this, Wheeel.class);
            startActivity(intent);
        }
        else{

        }


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


}
