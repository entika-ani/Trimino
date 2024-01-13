package com.example.trimino;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startNEWActivity(View v){
        Intent intent = new Intent(this, Second_Activity.class);
        startActivity(intent);
        finish();
    }

    public void startStories(View v){
        Intent intent = new Intent(this, Stories.class);
        startActivity(intent);
        finish();
    }

    public void startLetters(View v){
        Intent intent = new Intent(this, Letters.class);
        startActivity(intent);
        finish();
    }

}