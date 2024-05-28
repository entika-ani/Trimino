package com.example.trimino.glux4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.trimino.R;
import com.example.trimino.Stories;
import com.example.trimino.Syu1_1_1;
import com.example.trimino.Syu1_1_2;

public class B1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b1);
    }

    public void back(View v){
        Intent intent = new Intent(this, Stories.class);
        startActivity(intent);
        finish();
    }

    public void ah(View v) {
        Intent intent = new Intent(this, B2.class);
        startActivity(intent);
        finish();
    }

    public void ash(View v){
        Intent intent = new Intent(this, B7.class);
        startActivity(intent);
        finish();
    }
}