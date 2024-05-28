package com.example.trimino.random_facts.sylfa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.trimino.MainActivity;
import com.example.trimino.R;
import com.example.trimino.random_facts.luna.L_fact1;

public class S_fact1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sfact1);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(S_fact1.this, MainActivity.class);
                i.putExtra("stopMusic", true);
                startActivity(i);
                finish();
            }
        }, 4000);
    }
}