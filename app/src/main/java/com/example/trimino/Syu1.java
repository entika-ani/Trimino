package com.example.trimino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class Syu1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syu1);

        View layout = findViewById(R.id.darkGreenLayout);
        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Intent intent = new Intent(Syu1.this, Syu1_1.class);
                    startActivity(intent);
                    finish();
                    return true;
                }
                return false;
            }
        });
    }
    public void back(View v){
        Intent intent = new Intent(this, Stories.class);
        startActivity(intent);
       finish();
    }

}