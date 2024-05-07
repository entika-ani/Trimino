package com.example.trimino.place;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trimino.MainActivity;
import com.example.trimino.R;

public class Place4x4 extends AppCompatActivity implements View.OnClickListener {
    private final Button[][] buttons = new Button[4][4];
    private boolean player1Turn = true;
    private int roundCount;
    private int player1Points;
    private int player2Points;
    private TextView textViewPlayer1;
    private TextView textViewPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place4x4);

        textViewPlayer1 = findViewById(R.id.text_view_p1);
        textViewPlayer2 = findViewById(R.id.text_view_p2);

        Button buttonReset = findViewById(R.id.button_reset);
        buttonReset.setOnClickListener(v -> resetGame());

        int[][] buttonIds = {
                {R.id.button_01, R.id.button_02, R.id.button_03, R.id.button_04},
                {R.id.button_11, R.id.button_12, R.id.button_13, R.id.button_14},
                {R.id.button_21, R.id.button_22, R.id.button_23, R.id.button_24},
                {R.id.button_31, R.id.button_32, R.id.button_33, R.id.button_34},
                {R.id.button_41, R.id.button_42, R.id.button_43, R.id.button_44},
        };

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                buttons[i][j] = findViewById(buttonIds[i][j]);
                buttons[i][j].setOnClickListener(this);
            }
        }
    }


    @Override
    public void onClick(View v) {
        Button clickedButton = (Button) v;

        if (!clickedButton.getText().toString().isEmpty()) {
            return;
        }

        if (player1Turn) {
            clickedButton.setText("X");
            clickedButton.setTextColor(Color.BLACK);
        } else {
            clickedButton.setText("O");
            clickedButton.setTextColor(Color.BLACK);
        }

        roundCount++;

        if (checkForWin()) {
            if (player1Turn) {
                player1Wins();
            } else {
                player2Wins();
            }
        } else if (roundCount == 16) {
            draw();
        } else {
            player1Turn = !player1Turn;
        }
    }

    private boolean checkForWin() {
        String[][] field = new String[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                field[i][j] = buttons[i][j].getText().toString();
            }
        }


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                String current = field[i][j];
                if (!current.isEmpty()) {

                    if (j + 2 < 4 && current.equals(field[i][j + 1]) && current.equals(field[i][j + 2])) {
                        return true;
                    }

                    if (i + 2 < 4 && current.equals(field[i + 1][j]) && current.equals(field[i + 2][j])) {
                        return true;
                    }

                    if (i + 2 < 4 && j + 2 < 4 && current.equals(field[i + 1][j + 1]) && current.equals(field[i + 2][j + 2])) {
                        return true;
                    }

                    if (i + 2 < 4 && j - 2 >= 0 && current.equals(field[i + 1][j - 1]) && current.equals(field[i + 2][j - 2])) {
                        return true;
                    }
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

    private void updatePointsText() {
        String player1Text = "Player 1: " + player1Points;
        String player2Text = "Player 2: " + player2Points;
        SpannableString spannablePlayer1 = new SpannableString(player1Text);
        SpannableString spannablePlayer2 = new SpannableString(player2Text);
        textViewPlayer1.setText(spannablePlayer1);
        textViewPlayer2.setText(spannablePlayer2);
    }

    private void resetBoard() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                buttons[i][j].setText("");
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

    private void showWinnerMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void checkGameEnd1() {
        if (player1Points == 4 || player2Points == 4) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("coins", 50);
            startActivity(intent);
            finish();
        }
    }

}
