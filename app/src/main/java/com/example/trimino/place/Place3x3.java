package com.example.trimino.place;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trimino.MainActivity;
import com.example.trimino.R;

public class Place3x3 extends AppCompatActivity implements View.OnClickListener {
    private final Button[][] buttons = new Button[3][3];
    private boolean player1Turn = true;
    private int roundCount;
    private int player1Points;
    private int player2Points;
    private TextView textViewPlayer1;
    private TextView textViewPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place3x3);

        textViewPlayer1 = findViewById(R.id.text_view_p1);
        textViewPlayer2 = findViewById(R.id.text_view_p2);

        initializeButtons();

        Button buttonReset = findViewById(R.id.button_reset);
        buttonReset.setOnClickListener(v -> resetGame());
    }

    private void initializeButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonID = "button_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this);}
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
            clickedButton.setTextColor(getResources().getColor(android.R.color.black)); // Черный цвет текста для X
        } else {
            clickedButton.setText("O");
            clickedButton.setTextColor(getResources().getColor(android.R.color.black)); // Черный цвет текста для O
        }

        roundCount++;

        if (checkForWin()) {
            if (player1Turn) {
                player1Wins();
            } else {
                player2Wins();
            }
        } else if (roundCount == 9) {
            draw();
        } else {
            player1Turn = !player1Turn;
        }
    }

    private boolean checkForWin() {
        String[][] field = new String[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = buttons[i][j].getText().toString();
            }
        }

        for (int i = 0; i < 3; i++) {

            if (field[i][0].equals(field[i][1]) && field[i][0].equals(field[i][2]) && !field[i][0].isEmpty()) {
                return true;
            }

            if (field[0][i].equals(field[1][i]) && field[0][i].equals(field[2][i]) && !field[0][i].isEmpty()) {
                return true;
            }
        }


        if (field[0][0].equals(field[1][1]) && field[0][0].equals(field[2][2]) && !field[0][0].isEmpty()) {
            return true;
        }


        if (field[0][2].equals(field[1][1]) && field[0][2].equals(field[2][0]) && !field[0][2].isEmpty()) {
            return true;
        }

        return false;
    }

    private void player1Wins() {
        player1Points++;
        updatePointsText();
        showWinnerMessage("Player 1 wins!");
        resetBoard();
        checkGameEnd();
    }

    private void player2Wins() {
        player2Points++;
        updatePointsText();
        showWinnerMessage("Player 2 wins!");
        resetBoard();
        checkGameEnd();
    }

    private void draw() {
        showWinnerMessage("Draw!");
        resetBoard();
        checkGameEnd();
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
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
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

    private void checkGameEnd() {
        if (player1Points == 2 || player2Points == 2) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("coins", 20);
            startActivity(intent);
            finish();
        }
    }

}
