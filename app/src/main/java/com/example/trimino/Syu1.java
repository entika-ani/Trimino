package com.example.trimino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Syu1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syu1);
    }
    public void back(View v){
        Intent intent = new Intent(this, Stories.class);
        startActivity(intent);
       finish();
    }
}