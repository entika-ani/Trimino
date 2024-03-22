package com.example.trimino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Stories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories);
        onPause();
    }
    public void goBack(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        onPause();
    }
    public void newej(View v){
        Intent intent = new Intent(this, Syu1.class);
        startActivity(intent);
        onPause();
    }
    public void syu2(View v){
        Intent intent = new Intent(this, Syu2.class);
        startActivity(intent);
        onPause();
    }
}