package com.example.trimino.glux9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.example.trimino.R;
import com.example.trimino.Stories;
import com.example.trimino.glux8.I1;
import com.example.trimino.glux8.I2;

public class J1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_j1);
        View layout = findViewById(R.id.darkGreenLayout);
        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Intent intent = new Intent(J1.this, J2.class);
                    startActivity(intent);
                    finish();
                    return true;
                }
                return false;
            }
        });
    }

    public void back(View v) {
        Intent intent = new Intent(this, Stories.class);
        startActivity(intent);
        finish();
    }
}