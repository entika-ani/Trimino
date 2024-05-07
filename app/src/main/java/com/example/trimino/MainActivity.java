package com.example.trimino;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.preference.PreferenceManager;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private boolean isSoundOn = true;
    private TextView sumTextView;

    private SharedPreferences sharedPreferences;
    private int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Start the MusicService
        Intent serviceIntent = new Intent(this, MusicService.class);
        startService(serviceIntent);

        sumTextView = findViewById(R.id.sumTextView);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        total = sharedPreferences.getInt("total", 0); // Restore the total value from SharedPreferences

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("coins")) {
            int coins = intent.getIntExtra("coins", 0);
            total += coins;
            saveTotal(total);
        }

        sumTextView.setText("Coins: " + total);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("coins")) {
            int coins = intent.getIntExtra("coins", 0);
            total += coins;
            saveTotal(total);
            sumTextView.setText("Coins: " + total);
        }
    }


    // Your button click handling methods
    public void ah(View view) {
        total += 50; // Update the total coin sum
        saveTotal(total); // Save the total value in SharedPreferences
        sumTextView.setText("Coins: " + total); // Update the display of the coin sum
    }

    public void ahh(View view) {
        total += 100; // Update the total coin sum
        saveTotal(total); // Save the total value in SharedPreferences
        sumTextView.setText("Coins: " + total); // Update the display of the coin sum
    }

    public void openWheel(View v) {
        overridePendingTransition(0, 0);
        Intent intent = new Intent(this, Wheeel.class);
        intent.putExtra("totalCoins", total);
        startActivity(intent);
    }

    public void startStories(View v) {
        overridePendingTransition(0, 0);
        Intent intent = new Intent(this, Stories.class);
        startActivityForResult(intent, 1); // Start the activity and wait for result
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) { // Check if the result is from the desired activity
            if (resultCode == RESULT_OK) { // Check if the activity was successful
                int selectedValue = data.getIntExtra("selectedValue", 0); // Get the selected value from the activity
                total += selectedValue; // Update the total coin sum
                saveTotal(total); // Save the total value in SharedPreferences
                sumTextView.setText("Coins: " + total); // Update the display of the coin sum
            }
        }
    }

    public void startAbout(View v) {
        overridePendingTransition(0, 0);
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }

    public void startLetters(View v) {
        overridePendingTransition(0, 0);
        Intent intent = new Intent(this, Tellephone.class);
        startActivity(intent);
    }

    public void startNEWActivity(View v) {
        overridePendingTransition(0, 0);
        Intent intent = new Intent(this, Foniqar.class);
        startActivity(intent);
    }

    private void saveTotal(int total) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("total", total);
        editor.apply();
    }
    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isLoggedIn", false);
        editor.apply();

        Intent intent = new Intent(this, Login.class);
        intent.putExtra("GuestMode", Login.GuestMode);
        startActivity(intent);
        finish();
    }

}
