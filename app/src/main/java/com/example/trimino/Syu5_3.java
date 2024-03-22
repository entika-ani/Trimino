package com.example.trimino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Syu5_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syu53);
    }

    public void back(View v){
        Intent intent = new Intent(this, Stories.class);
        startActivity(intent);
        finish();
    }

    public void araj(View v){
        Intent intent = new Intent(this,Syu1_verj.class);
        startActivity(intent);
        onPause();
    }

    public void  mi_hatHet(View v){
        Intent intent = new Intent(this,Syu5_2.class);
        startActivity(intent);
        finish();
    }
}