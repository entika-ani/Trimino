package com.example.trimino.glux8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.trimino.R;
import com.example.trimino.Stories;
import com.example.trimino.glux6.C9;

public class I6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i6);
    }

    public void back(View v){
        Intent intent = new Intent(this, Stories.class);
        startActivity(intent);
        finish();
    }

    public void ah(View v) {
        Intent intent = new Intent(this, I7.class);
        startActivity(intent);
        finish();
    }

    public void ash(View v){
        Intent intent = new Intent(this, I7.class);
        startActivity(intent);
        finish();
    }
}