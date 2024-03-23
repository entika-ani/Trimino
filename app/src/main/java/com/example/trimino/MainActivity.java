package com.example.trimino;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startNEWActivity(View v){
        Intent intent = new Intent(this, games.class);
        startActivity(intent);
        onPause();
    }

    public void openWheel(View v){
        Intent intent = new Intent(this, Wheeel.class);
        startActivity(intent);
        onPause();
    }

    public void startStories(View v){
        Intent intent = new Intent(this, Stories.class);
        startActivity(intent);
        onPause();

    }

    public void game(View v){
        Intent intent = new Intent(this, GamePlay1.class);
        startActivity(intent);
        onPause();

    }

    public void startAbout(View v){
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
        onPause();

    }

    public void startLetters(View v){
        Intent intent = new Intent(this, Tellephone.class);
        startActivity(intent);
        onPause();

    }

}