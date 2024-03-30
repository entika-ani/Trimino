package com.example.trimino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Syu1_2y extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syu12y);

        SharedPreferences sharedPreferences = getSharedPreferences("coin_prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("coins_sy1_2", 100); // Сохраняем 100 монет
        editor.apply(); // Применяем изменения
    }


    public void back(View v){
        Intent intent = new Intent(this, Stories.class);
        startActivity(intent);
        finish();
    }
    public void  mi_hatHet(View v){
        Intent intent = new Intent(this,Syu4_2.class);
        startActivity(intent);
        finish();
    }

    public void  ahh(View v){
        Intent intent = new Intent(this,Syu1_2_1.class);
        startActivity(intent);
        finish();
    }

    public void  ashh(View v){
        Intent intent = new Intent(this,Syu1_2_2.class);
        startActivity(intent);
        finish();
    }
}