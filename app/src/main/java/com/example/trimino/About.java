package com.example.trimino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class About extends AppCompatActivity {

    public void back(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        onPause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }
}