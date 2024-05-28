package com.example.trimino;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

public class Telefono extends AppCompatActivity {
    static boolean Yes = false;
    private EditText passwordField;
    private StringBuilder password = new StringBuilder();
    private static final String CORRECT_PASSWORD = "17250322";
    private ImageView gaxtnabar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telefono);

        passwordField = findViewById(R.id.password_field);
        gaxtnabar = findViewById(R.id.gaxtnabar); // Получаем ссылку на изображение

        // Устанавливаем изначально видимость невидимым
        gaxtnabar.setVisibility(View.INVISIBLE);

        for (int i = 0; i <= 9; i++) {
            String buttonTag = String.valueOf(i);
            Button button = findButtonByTag(buttonTag);
            if (button != null) {
                button.setOnClickListener(this::onButtonClick);
                Log.d("ButtonSetup", "Button with tag " + buttonTag + " is set up.");
            } else {
                Log.e("ButtonSetup", "Button with tag " + buttonTag + " not found.");
            }
        }

        Button enterButton = findViewById(R.id.btn_enter);
        if (enterButton != null) {
            enterButton.setOnClickListener(v -> verifyPassword());
        } else {
            Log.e("ButtonSetup", "Enter button not found.");
        }

        Button clearButton = findViewById(R.id.btn_clear);
        if (clearButton != null) {
            clearButton.setOnClickListener(v -> {
                password.setLength(0);
                passwordField.setText("");
            });
        } else {
            Log.e("ButtonSetup", "Clear button not found.");
        }

        // Проверяем, был ли пароль ранее верно введен
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        boolean isPasswordVerified = sharedPreferences.getBoolean("PasswordVerified", false);
        if (isPasswordVerified) {
            gaxtnabar.setVisibility(View.VISIBLE);
        }
    }

    private Button findButtonByTag(String tag) {
        GridLayout keypad = findViewById(R.id.keypad);
        for (int i = 0; i < keypad.getChildCount(); i++) {
            View child = keypad.getChildAt(i);
            if (tag.equals(child.getTag())) {
                return (Button) child;
            }
        }
        return null;
    }

    @SuppressLint("NonConstantResourceId")
    private void onButtonClick(View view) {
        if (view instanceof Button) {
            Button clickedButton = (Button) view;
            String buttonText = clickedButton.getText().toString();

            Log.d("ButtonClick", "Button text: " + buttonText);

            if (password.length() < 8) {
                password.append(buttonText);
                passwordField.setText(password.toString());
                Log.d("Password", "Current password: " + password.toString());
            }
        }
    }

    private void verifyPassword() {
        String enteredPassword = password.toString();
        if (enteredPassword.equals(CORRECT_PASSWORD)) {
            showMessage("Password is correct!");
            Yes = true;

            // Сохраняем состояние проверки пароля
            SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("PasswordVerified", true);
            editor.apply();

            // Показываем изображение, когда пароль введен правильно
            gaxtnabar.setVisibility(View.VISIBLE);

            Intent intent = new Intent(Telefono.this, Tellephone.class);
            startActivity(intent);
            finish();
        } else {
            showMessage("Password is incorrect!");
        }
        Log.d("Password", "Entered password: " + enteredPassword);
    }

    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
