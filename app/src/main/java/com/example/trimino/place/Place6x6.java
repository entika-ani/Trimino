package com.example.trimino.place;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.graphics.Color;

import com.example.trimino.MainActivity;
import com.example.trimino.R;
import com.example.trimino.Splash2;

public class Place6x6 extends AppCompatActivity implements View.OnClickListener {
    private final Button[][] b = new Button[6][6];
    private boolean player1Turn = true;
    private int roundCount;
    private int player1Points;
    private int player2Points;
    private TextView textViewPlayer1;
    private TextView textViewPlayer2;

    private MediaPlayer mediaPlayer;
    private boolean isMediaPlayerRunning = false;
    private boolean isMusicPaused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place6x6);

        textViewPlayer1 = findViewById(R.id.text_view_p1);
        textViewPlayer2 = findViewById(R.id.text_view_p2);

        Button musicButton = findViewById(R.id.button8); // Assuming this is the button for music control
        musicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleMusic(v);
            }
        });


        int[][] buttonIds = {
                {R.id.button_01, R.id.button_02, R.id.button_03, R.id.button_04, R.id.button_05, R.id.button_06},
                {R.id.button_11, R.id.button_12, R.id.button_13, R.id.button_14, R.id.button_15, R.id.button_16},
                {R.id.button_21, R.id.button_22, R.id.button_23, R.id.button_24, R.id.button_25, R.id.button_26},
                {R.id.button_31, R.id.button_32, R.id.button_33, R.id.button_34, R.id.button_35, R.id.button_36},
                {R.id.button_41, R.id.button_42, R.id.button_43, R.id.button_44, R.id.button_45, R.id.button_46},
                {R.id.button_51, R.id.button_52, R.id.button_53, R.id.button_54, R.id.button_55, R.id.button_56}
        };

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                b[i][j] = findViewById(buttonIds[i][j]);
                b[i][j].setOnClickListener(this);
            }
        }

        Button buttonReset = findViewById(R.id.button_reset);
        buttonReset.setOnClickListener(v -> resetGame());
        Intent intent = getIntent();
        isMediaPlayerRunning = intent.getBooleanExtra("mediaPlayer", false);
        if (isMediaPlayerRunning) {
            mediaPlayer = MediaPlayer.create(this, R.raw.krak);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
        }
    }

    public void toggleMusic(View view) {
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                isMusicPaused = true;
            } else {
                mediaPlayer.start();
                isMusicPaused = false;
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isMediaPlayerRunning && isMusicPaused) {
            mediaPlayer.start();
            isMusicPaused = false;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            isMusicPaused = true;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    public void onClick(View v) {
        if (!((Button) v).getText().toString().equals("")) {
            return;
        }
        Button clickedButton = (Button) v;

        if (player1Turn) {
            clickedButton.setText("X");
            clickedButton.setTextSize(50);
            clickedButton.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
        } else {
            clickedButton.setText("O");
            clickedButton.setTextSize(50);
            clickedButton.setTextColor(getResources().getColor(android.R.color.holo_orange_dark));
        }

        roundCount++;

        if (checkForWin()) {
            if (player1Turn) {
                player1Wins();
            } else {
                player2Wins();
            }
        } else if (roundCount == 36) {
            draw();
        } else {
            player1Turn = !player1Turn;
        }
    }

    private boolean checkForWin() {
        String[][] field = new String[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                field[i][j] = b[i][j].getText().toString();
            }
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                if (!field[i][j].isEmpty() &&
                        field[i][j].equals(field[i][j + 1]) &&
                        field[i][j].equals(field[i][j + 2]) &&
                        field[i][j].equals(field[i][j + 3])) {
                    return true;
                }
            }
        }
        for (int j = 0; j < 6; j++) {
            for (int i = 0; i < 3; i++) {
                if (!field[i][j].isEmpty() &&
                        field[i][j].equals(field[i + 1][j]) &&
                        field[i][j].equals(field[i + 2][j]) &&
                        field[i][j].equals(field[i + 3][j])) {
                    return true;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!field[i][j].isEmpty() &&
                        field[i][j].equals(field[i + 1][j + 1]) &&
                        field[i][j].equals(field[i + 2][j + 2]) &&
                        field[i][j].equals(field[i + 3][j + 3])) {
                    return true;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 6; j++) {
                if (!field[i][j].isEmpty() &&
                        field[i][j].equals(field[i + 1][j - 1]) &&
                        field[i][j].equals(field[i + 2][j - 2]) &&
                        field[i][j].equals(field[i + 3][j - 3])) {
                    return true;
                }
            }
        }
        return false;
    }

    private void player1Wins() {
        player1Points++;
        updatePointsText();
        showWinnerMessage("Player 1 wins!");
        resetBoard();
        checkGameEnd1();
    }

    private void player2Wins() {
        player2Points++;
        updatePointsText();
        showWinnerMessage("Player 2 wins!");
        resetBoard();
        checkGameEnd1();
    }

    private void draw() {
        showWinnerMessage("Draw!");
        resetBoard();
        checkGameEnd1();
    }

    private void showWinnerMessage(String s) {
    }

    private void checkGameEnd1() {
        if (player1Points == 6 || player2Points == 6) {
            Intent intent = new Intent(this, Splash2.class);
            intent.putExtra("gridSize", 6);
            startActivity(intent);
            finish();
        }
    }

    private void updatePointsText() {
        String player1Text = "Player 1: " + player1Points;
        String player2Text = "Player 2: " + player2Points;
        SpannableString spannablePlayer1 = new SpannableString(player1Text);
        SpannableString spannablePlayer2 = new SpannableString(player2Text);
        textViewPlayer1.setText(spannablePlayer1);
        textViewPlayer2.setText(spannablePlayer2);
    }

    private void resetBoard() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                b[i][j].setText("");
            }
        }
        roundCount = 0;
        player1Turn = true;
    }

    private void resetGame() {
        player1Points = 0;
        player2Points = 0;
        updatePointsText();
        resetBoard();
    }
}
