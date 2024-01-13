package com.example.trimino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Letters extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letters);
    }

    public void goBack(View v){
        Intent intent = new Intent(this, com.example.trimino.MainActivity.class);
        startActivity(intent);
        finish();
    }
}