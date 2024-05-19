package com.example.trimino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.trimino.glux1.F1;
import com.example.trimino.glux10.S1;
import com.example.trimino.glux2.G1;
import com.example.trimino.glux3.E1;
import com.example.trimino.glux4.B1;
import com.example.trimino.glux5.A1;
import com.example.trimino.glux6.C1;
import com.example.trimino.glux7.D1;
import com.example.trimino.glux8.I1;
import com.example.trimino.glux9.J1;

public class Stories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories);
        onPause();
    }
    public void goBack(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        onPause();
    }
    public void g1(View v){
        Intent intent = new Intent(this, F1.class);
        startActivity(intent);
        onPause();
    }
    public void g2(View v){
        Intent intent = new Intent(this, G1.class);
        startActivity(intent);
        onPause();
    }

    public void g3(View v){
        Intent intent = new Intent(this, E1.class);
        startActivity(intent);
        onPause();
    }


    public void g4(View v){
        Intent intent = new Intent(this, B1.class);
        startActivity(intent);
        onPause();
    }
    public void g5(View v){
        Intent intent = new Intent(this, A1.class);
        startActivity(intent);
        onPause();
    }
    public void g6(View v){
        Intent intent = new Intent(this, C1.class);
        startActivity(intent);
        onPause();
    }
    public void g7(View v){
        Intent intent = new Intent(this, D1.class);
        startActivity(intent);
        onPause();
    }

    public void g8(View v){
        Intent intent = new Intent(this, I1.class);
        startActivity(intent);
        onPause();
    }
    public void g9(View v){
        Intent intent = new Intent(this, J1.class);
        startActivity(intent);
        onPause();
    }

    public void g10(View v){
        Intent intent = new Intent(this, S1.class);
        startActivity(intent);
        onPause();
    }
}