package com.example.trimino.glux6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.trimino.R;
import com.example.trimino.Stories;
import com.example.trimino.glux4.B2;
import com.example.trimino.glux4.B7;

public class C8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c8);
    }

    public void back(View v){
        Intent intent = new Intent(this, Stories.class);
        startActivity(intent);
        finish();
    }

    public void ah(View v) {
        Intent intent = new Intent(this, C9.class);
        startActivity(intent);
        finish();
    }

    public void ash(View v){
        Intent intent = new Intent(this, C9.class);
        startActivity(intent);
        finish();
    }
}