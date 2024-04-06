package com.example.trimino;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.preference.PreferenceManager;

public class MainActivity extends AppCompatActivity {
    private TextView sumTextView;
    private int initialSum = 100;
    private SharedPreferences sharedPreferences;
    private int total = 0; // Используем локальную переменную для хранения общего значения монет

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sumTextView = findViewById(R.id.sumTextView);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        total = sharedPreferences.getInt("total", 0); // Восстанавливаем значение total из SharedPreferences

        // Получаем значение total из интента, если оно было передано
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("coins")) {
            int coins = intent.getIntExtra("coins", 0);
            total += coins;
            saveTotal(total); // Сохраняем значение total в SharedPreferences
        }

        // Обновляем отображение суммы монет
        sumTextView.setText("Coins: " + total);
    }

    // Ваши методы обработки нажатия кнопок
    public void ah(View view) {
        initialSum += 50;
        total += 50; // Обновляем общую сумму монет
        saveTotal(total); // Сохраняем значение total в SharedPreferences
        sumTextView.setText("Coins: " + total); // Обновляем отображение суммы монет
    }

    public void ahh(View view) {
        initialSum += 100;
        total += 100; // Обновляем общую сумму монет
        saveTotal(total); // Сохраняем значение total в SharedPreferences
        sumTextView.setText("Coins: " + total); // Обновляем отображение суммы монет
    }

    public void openWheel(View v) {
        Intent intent = new Intent(this, Wheeel.class);
        intent.putExtra("totalCoins", total);
        startActivity(intent);
    }


    public void startStories(View v) {
        Intent intent = new Intent(this, Stories.class);
        startActivityForResult(intent, 1); // Запуск активности с ожиданием результата
    }

    // Метод, который будет вызван при возвращении результата из другой активности
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) { // Проверяем, что результат пришел от нужной активности
            if (resultCode == RESULT_OK) { // Проверяем успешность выполнения активности
                int selectedValue = data.getIntExtra("selectedValue", 0); // Получаем выбранное значение из активности
                initialSum += selectedValue; // Добавляем выбранное значение к общей сумме монет
                total += selectedValue; // Обновляем общую сумму монет
                saveTotal(total); // Сохраняем значение total в SharedPreferences
                sumTextView.setText("Coins: " + total); // Обновляем отображение суммы монет
            }
        }
    }

    public void startAbout(View v) {
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }

    public void startLetters(View v) {
        Intent intent = new Intent(this, Tellephone.class);
        startActivity(intent);
    }

    public void startNEWActivity(View v) {
        Intent intent = new Intent(this, games.class);
        startActivity(intent);
    }

    // Метод для сохранения значения total в SharedPreferences
    private void saveTotal(int total) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("total", total);
        editor.apply();
    }
}
