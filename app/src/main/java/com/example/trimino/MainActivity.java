package com.example.trimino;

import static com.example.trimino.Syu1_verj.x;
import static com.example.trimino.Wheeel.again;
import static com.example.trimino.Wheeel.total;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView sumTextView;
    private int initialSum = 100;


    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Получаем сумму приза из Intent, если она была передана
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("prize")) {
            int prize = intent.getIntExtra("prize", 0); // Получаем сумму приза, значение по умолчанию - 0
            // Добавляем сумму приза к общей сумме монет в MainActivity
            total += prize;
            // Обновляем отображение суммы монет в вашем пользовательском интерфейсе
            TextView sumTextView = findViewById(R.id.sumTextView);
            sumTextView.setText("Coins: " + total);
        }

        Intent intentch = getIntent();
        if (intentch != null && intent.hasExtra("coins")) {
            int coins = intent.getIntExtra("coins", 0); // Получаем количество монет, значение по умолчанию - 0
            // Добавляем количество монет к общей сумме в MainActivity
            total += coins;
            // Обновляем отображение суммы монет в вашем пользовательском интерфейсе
            TextView sumTextView = findViewById(R.id.sumTextView);
            sumTextView.setText("Coins: " + total);
        }
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

    public void openWheel(View v) {
        if (again == true){
            Intent intent = new Intent(this, Wheeel.class);
            startActivity(intent);
        }else {
            Intent intent = new Intent(this, Wait.class);
            startActivity(intent);
        }
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
                saveInitialSum(initialSum); // Сохраняем новую сумму в SharedPreferences
                sumTextView.setText("Coins: " + initialSum); // Обновляем отображение суммы монет
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
}
