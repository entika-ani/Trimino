package com.example.trimino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Syu1_2_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syu122);
    }

    public void araj(View v){
        Intent intent = new Intent(this,Syu5_1.class);
        startActivity(intent);
    }
    public void  mi_hatHet(View v){
        Intent intent = new Intent(this,Syu1_2y.class);
        startActivity(intent);
        finish();
    }

    public void back(View v){
        Intent intent = new Intent(this, Stories.class);
        startActivity(intent);
        finish();
    }
}