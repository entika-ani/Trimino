package com.example.trimino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.trimino.place.Place3x3;
import com.example.trimino.place.Place4x4;
import com.example.trimino.place.Place5x5;
import com.example.trimino.place.Place6x6;

public class Foniqar extends AppCompatActivity {

    private int selectedButtonId = 0;

    public boolean h111 = false;
    public boolean h222 = false;
    public boolean h333 = false;
    public boolean h444 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foniqar);

        Button h1 = findViewById(R.id.h1);
        Button h2 = findViewById(R.id.h2);
        Button h3 = findViewById(R.id.h3);
        Button h4 = findViewById(R.id.h4);
        LinearLayout h11 = findViewById(R.id.h11);
        LinearLayout h22 = findViewById(R.id.h22);
        LinearLayout h33 = findViewById(R.id.h33);
        LinearLayout h44 = findViewById(R.id.h44);


        h1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                h222 = false;
                h333 = false;
                h444 = false;
                h111 = true;
                if (h111 == true){
                    h11.setBackgroundResource(R.drawable.button_background_green);
                    h22.setBackgroundResource(R.drawable.button_background);
                    h33.setBackgroundResource(R.drawable.button_background);
                    h44.setBackgroundResource(R.drawable.button_background);
                }
                else{
                    h11.setBackgroundResource(R.drawable.button_background);
                }

                selectedButtonId = 1;

            }
        });



        h2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedButtonId = 2;
                h222 = true;
                h333 = false;
                h444 = false;
                h111 = false;
                if (h222 == true){
                    h22.setBackgroundResource(R.drawable.button_background_green);
                    h11.setBackgroundResource(R.drawable.button_background);
                    h33.setBackgroundResource(R.drawable.button_background);
                    h44.setBackgroundResource(R.drawable.button_background);
                }
                else{
                    h22.setBackgroundResource(R.drawable.button_background);
                }
            }
        });

        h3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedButtonId =3;
                h222 = false;
                h333 = true;
                h444 = false;
                h111 = false;
                if (h333 == true){
                    h33.setBackgroundResource(R.drawable.button_background_green);
                    h22.setBackgroundResource(R.drawable.button_background);
                    h11.setBackgroundResource(R.drawable.button_background);
                    h44.setBackgroundResource(R.drawable.button_background);
                }
                else{
                    h33.setBackgroundResource(R.drawable.button_background);
                }
            }
        });

        h4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedButtonId = 4;
                h222 = false;
                h333 = true;
                h444 = true;
                h111 = false;
                if (h444 == true){
                    h44.setBackgroundResource(R.drawable.button_background_green);
                    h22.setBackgroundResource(R.drawable.button_background);
                    h33.setBackgroundResource(R.drawable.button_background);
                    h11.setBackgroundResource(R.drawable.button_background);
                }
                else{
                    h44.setBackgroundResource(R.drawable.button_background);
                }
            }
        });
    }


    public void Help_us(View v){
        if (selectedButtonId == 1){
            Intent intent = new Intent(this, Splash_fast.class);
            startActivity(intent);
            onPause();
        } else if (selectedButtonId == 2) {
            Intent intent = new Intent(this, Splash_butterfly.class);
            startActivity(intent);
            onPause();
        }else if (selectedButtonId == 3) {
            Intent intent = new Intent(this, Splash_sea.class);
            startActivity(intent);
            onPause();
        }
        else{
            Intent intent = new Intent(this,Splash_slow.class);
            startActivity(intent);
            onPause();
        }

    }
}