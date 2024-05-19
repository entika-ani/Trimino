package com.example.trimino;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

public class Telefono extends AppCompatActivity {

    private EditText passwordField;
    private StringBuilder password = new StringBuilder();
    private static final String CORRECT_PASSWORD = "17250322";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telefono);

        passwordField = findViewById(R.id.password_field);

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
            Intent intent = new Intent(Telefono.this, Tellephone.class);
            intent.putExtra("proceedToTellephone", 1); // Передаем значение 1, чтобы открыть Tellephone
            startActivity(intent);
            finish(); // Закрываем Telefono
        } else {
            showMessage("Password is incorrect!");
        }
        Log.d("Password", "Entered password: " + enteredPassword);
    }

    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
