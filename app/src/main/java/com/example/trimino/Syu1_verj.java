package com.example.trimino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Syu1_verj extends AppCompatActivity {
    static  boolean x = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syu1_verj);
    }

    public void back(View v){
        Intent intent = new Intent(this, Stories.class);
        startActivity(intent);
        finish();
    }
    public void araj(View v){
        Intent intent = new Intent(this,Stories.class);
        startActivity(intent);
        x = true;
        finish();
    }

    public void  mi_hatHet(View v){
        Intent intent = new Intent(this,Syu5_3.class);
        startActivity(intent);
        finish();
    }
}