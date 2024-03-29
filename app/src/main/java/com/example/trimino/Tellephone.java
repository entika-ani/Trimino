package com.example.trimino;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trimino.ActivityH1;
import com.example.trimino.ActivityH2;
import com.example.trimino.ActivityH3;
import com.example.trimino.ActivityH4;
import com.example.trimino.R;

public class Tellephone extends AppCompatActivity {

    private int selectedButtonId = -1; // Идентификатор выбранной кнопки, -1 означает, что ни одна кнопка не выбрана

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tellephone);

        Button h1 = findViewById(R.id.h1);
        Button h2 = findViewById(R.id.h2);
        Button h3 = findViewById(R.id.h3);
        Button h4 = findViewById(R.id.h4);

        h1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedButtonId = R.id.h1;
            }
        });

        h2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedButtonId = R.id.h2;
            }
        });

        h3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedButtonId = R.id.h3;
            }
        });

        h4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedButtonId = R.id.h4;
            }
        });
    }

  /*  // Метод для обработки нажатия кнопки "START"
   public void startSelectedActivity(View view) {
        if (selectedButtonId != -1) { // Проверяем, была ли выбрана кнопка
            // В зависимости от выбранной кнопки, запускаем соответствующую активность
            switch (selectedButtonId) {
                case R.id.h1:
                    startActivity(new Intent(this, ActivityH1.class));
                    break;
                case R.id.h2:
                    startActivity(new Intent(this, ActivityH2.class));
                    break;
                case R.id.h3:
                    startActivity(new Intent(this, ActivityH3.class));
                    break;
                case R.id.h4:
                    startActivity(new Intent(this, ActivityH4.class));
                    break;
            }
        }
    }*/
}


