package com.example.trimino;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.trimino.heraxos.DarkGreen3;
import com.example.trimino.heraxos.Dark_green;

public class Tellephone extends AppCompatActivity {

    private int selectedButtonId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tellephone);

        Intent intent = getIntent();
        int proceedToTellephone = intent.getIntExtra("proceedToTellephone", 0);
        Log.d("ProceedToTellephone", "Value: " + proceedToTellephone);

        LinearLayout h11 = findViewById(R.id.row1);
        LinearLayout h22 = findViewById(R.id.row2);
        LinearLayout h33 = findViewById(R.id.row3);
        LinearLayout h44 = findViewById(R.id.row4);

        h11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedButtonId = 1;
                h11.setBackgroundResource(R.drawable.button_background_green);
                h22.setBackgroundResource(R.drawable.button_background);
                h33.setBackgroundResource(R.drawable.button_background);
                h44.setBackgroundResource(R.drawable.button_background);
            }
        });

        h22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedButtonId = 2;
                h11.setBackgroundResource(R.drawable.button_background);
                h22.setBackgroundResource(R.drawable.button_background_green);
                h33.setBackgroundResource(R.drawable.button_background);
                h44.setBackgroundResource(R.drawable.button_background);
            }
        });

        h33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedButtonId = 3;
                h11.setBackgroundResource(R.drawable.button_background);
                h22.setBackgroundResource(R.drawable.button_background);
                h33.setBackgroundResource(R.drawable.button_background_green);
                h44.setBackgroundResource(R.drawable.button_background);
            }
        });

        h44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedButtonId = 4;
                h11.setBackgroundResource(R.drawable.button_background);
                h22.setBackgroundResource(R.drawable.button_background);
                h33.setBackgroundResource(R.drawable.button_background);
                h44.setBackgroundResource(R.drawable.button_background_green);
            }
        });
    }

    public void select(View v) {
        if (selectedButtonId == 1) {
            Intent intent = new Intent(this, Dark_green.class);
            startActivity(intent);
        } else if (selectedButtonId == 2) {
            Intent intent = new Intent(this, Dark_green.class);
            startActivity(intent);
        } else if (selectedButtonId == 3) {
            Intent intent = new Intent(this, ActivityH3.class);
            startActivity(intent);
        } else if (selectedButtonId == 4) {
            Intent intent = new Intent(this, ActivityH4.class);
            startActivity(intent);
        }
    }

    public void goBack(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
