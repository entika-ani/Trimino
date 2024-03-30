package com.example.trimino;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Syu1_1y extends AppCompatActivity {

    private Button lastClickedButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syu11y);

        final Button button1 = findViewById(R.id.vibor1);
        final Button button2 = findViewById(R.id.vibor2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setSelected(true);
                button2.setSelected(false);
                lastClickedButton = button1;
                ah(v);
            }
        });

        SharedPreferences sharedPreferences = getSharedPreferences("coin_prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("coins_sy1_1", 50); // Сохраняем 50 монет
        editor.apply(); // Применяем изменения


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setSelected(false);
                button2.setSelected(true);
                lastClickedButton = button2;
                ash(v);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (lastClickedButton != null) {
            lastClickedButton.setSelected(true);
        }
    }


    public void back(View v){
        Intent intent = new Intent(this, Stories.class);
        startActivity(intent);
        finish();
    }
    public void  mi_hatHet(View v){
        Intent intent = new Intent(this,Syu2_3.class);
        startActivity(intent);
        finish();
    }

    public void  ah(View v){
        Intent intent = new Intent(this,Syu1_1_1.class);
        startActivity(intent);
        finish();
    }

    public void  ash(View v){
        Intent intent = new Intent(this,Syu1_1_2.class);
        startActivity(intent);
        finish();
    }
}
