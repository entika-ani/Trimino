package com.example.trimino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityH4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h4);
    }
    public void goBack(View v){
        Intent intent = new Intent(this, Tellephone.class);
        startActivity(intent);
        onPause();
    }
}