package com.example.trimino.random_facts.luna;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.trimino.MainActivity;
import com.example.trimino.R;

public class L_fact3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lfact3);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(L_fact3.this, MainActivity.class);
                i.putExtra("stopMusic", true);
                startActivity(i);
                finish();
            }
        }, 4000);
    }
}