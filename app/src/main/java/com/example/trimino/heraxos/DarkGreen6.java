package com.example.trimino.heraxos;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.trimino.R;

public class DarkGreen6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dark_green6);
        View layout = findViewById(R.id.darkGreenLayout);
        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Intent intent = new Intent(DarkGreen6.this, DarkGreen7.class);
                    startActivity(intent);
                    finish();
                    return true;
                }
                return false;
            }
        });
    }
}
