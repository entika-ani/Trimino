package com.example.trimino;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import com.example.trimino.random_facts.elion.E_fact1;
import com.example.trimino.random_facts.elion.E_fact2;
import com.example.trimino.random_facts.elion.E_fact3;
import com.example.trimino.random_facts.faira.F_fact1;
import com.example.trimino.random_facts.faira.F_fact2;
import com.example.trimino.random_facts.faira.F_fact3;
import com.example.trimino.random_facts.luna.L_fact1;
import com.example.trimino.random_facts.luna.L_fact2;
import com.example.trimino.random_facts.luna.L_fact3;
import com.example.trimino.random_facts.sylfa.S_fact1;
import com.example.trimino.random_facts.sylfa.S_fact2;
import com.example.trimino.random_facts.sylfa.S_fact3;


import java.util.Random;

public class Splash2 extends AppCompatActivity {
    private static final int SPLASH_DISPLAY_LENGTH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash3);

        int gridSize = getIntent().getIntExtra("gridSize", 3);

        new Handler().postDelayed(() -> {
            Intent intent = null;
            Random random = new Random();
            int randomNumber = random.nextInt(4); 

            switch (gridSize) {
                case 3:
                    switch (randomNumber) {
                        case 0:
                            intent = new Intent(this, E_fact1.class);
                            break;
                        case 1:
                            intent = new Intent(this, E_fact2.class);
                            break;
                        case 2:
                            intent = new Intent(this, E_fact3.class);
                            break;
                       
                    }
                    break;
                case 4:
                    switch (randomNumber) {
                        case 0:
                            intent = new Intent(this, S_fact1.class);
                            break;
                        case 1:
                            intent = new Intent(this, S_fact2.class);
                            break;
                        case 2:
                            intent = new Intent(this, S_fact3.class);
                            break;
                    }
                    break;
                case 5:
                    switch (randomNumber) {
                        case 0:
                            intent = new Intent(this, L_fact1.class);
                            break;
                        case 1:
                            intent = new Intent(this, L_fact2.class);
                            break;
                        case 2:
                            intent = new Intent(this, L_fact3.class);
                            break;
                    }
                    break;
                case 6:
                    switch (randomNumber) {
                        case 0:
                            intent = new Intent(this, F_fact1.class);
                            break;
                        case 1:
                            intent = new Intent(this, F_fact2.class);
                            break;
                        case 2:
                            intent = new Intent(this, F_fact3.class);
                            break;
                    }
                    break;
            }
            startActivity(intent);
            finish();
        }, SPLASH_DISPLAY_LENGTH);
    }
}
