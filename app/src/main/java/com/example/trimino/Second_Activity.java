package com.example.trimino;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
public class Second_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        onPause();
    }
    public void goBack(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        onPause();
    }
    public void startFirst(View v){
        Intent intent = new Intent(this, First.class);
        startActivity(intent);
        onPause();
    }
    public void startF(View v){
        Intent intent = new Intent(this, First.class);
        startActivity(intent);
        onPause();
    }
    public void startW(View v){
        Intent intent = new Intent(this, First.class);
        startActivity(intent);
        onPause();
    }

    public void startWind(View v){
        Intent intent = new Intent(this, First.class);
        startActivity(intent);
        onPause();
    }

    public void startAll(View v){
        Intent intent = new Intent(this, First.class);
        startActivity(intent);
        onPause();
    }

}