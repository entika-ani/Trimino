package com.example.trimino;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.preference.PreferenceManager;

public class Syu1_2y extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syu12y);

    }

    public void back(View v){
        Intent intent = new Intent(this, Stories.class);
        startActivity(intent);
        finish();
    }


    public void ahh(View v){
        Intent intent = new Intent(this, Syu1_2_1.class);
        startActivity(intent);
        finish();
    }

    public void ashh(View v){
        Intent intent = new Intent(this, Syu1_2_2.class);
        startActivity(intent);
        finish();
    }
}
