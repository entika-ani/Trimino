package com.example.trimino;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GamePlay1 extends AppCompatActivity implements View.OnClickListener {

    private Button[][] buttons = new Button[3][3];
    private boolean player1Turn = true;
    private List<Button> availableButtons;

    private int player1Points;

    private int roundCount;
    private int player2Points;
    private TextView textViewPlayer1;
    private TextView textViewPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_play1);

        availableButtons = new ArrayList<>();

        // Finding and initializing buttons
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int id = getResources().getIdentifier("button" + (i * 3 + j + 1), "id", getPackageName());
                Button button = findViewById(id);
                button.setOnClickListener(this);
                buttons[i][j] = button;
                availableButtons.add(button);
            }
        }

        initializeGame();
    }

    private void initializeGame() {
        // Resetting all buttons
        for (Button button : availableButtons) {
            button.setText("");
            button.setClickable(true);
            button.setBackgroundColor(Color.WHITE); // Initial color is light gray
        }
        player1Turn = true;
    }

    @Override
    public void onClick(View v) {
        Button clickedButton = (Button) v;

        // Check if the clicked button is available
        if (!availableButtons.contains(clickedButton)) {
            Toast.makeText(this, "This cell is already filled.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Set color for current player
        int currentPlayerColor = player1Turn ? Color.LTGRAY : Color.BLUE;
        clickedButton.setBackgroundColor(currentPlayerColor);

        // Set text for current player
        clickedButton.setText(player1Turn ? "X" : "O");

        // Remove clicked button from available buttons
        availableButtons.remove(clickedButton);

        // Fill one adjacent cell
        fillAdjacentCell(clickedButton);

        // Check for winner
        if (checkForWin()) {
            String winner = player1Turn ? "Player 1" : "Player 2";
            showWinnerDialog(winner + " wins!");
            initializeGame();
        } else {
            player1Turn = !player1Turn;
        }
    }

    private void fillAdjacentCell(Button clickedButton) {
        Random random = new Random();
        int clickedButtonId = clickedButton.getId();

        // Determine adjacent button's ID
        int[] adjacentIds = {clickedButtonId - 1, clickedButtonId + 1,
                clickedButtonId - 3, clickedButtonId + 3};

        // Fill one random adjacent button on the same line
        List<Button> adjacentButtons = new ArrayList<>();
        for (int id : adjacentIds) {
            Button adjacentButton = findButtonById(id);
            if (adjacentButton != null && availableButtons.contains(adjacentButton)) {
                adjacentButtons.add(adjacentButton);
            }
        }

        if (!adjacentButtons.isEmpty()) {
            Button randomButton = adjacentButtons.get(random.nextInt(adjacentButtons.size()));
            randomButton.setBackgroundColor(player1Turn ? Color.LTGRAY : Color.BLUE);
            randomButton.setText(player1Turn ? "X" : "O");
            availableButtons.remove(randomButton);
        }
    }

    private Button findButtonById(int id) {
        for (Button[] row : buttons) {
            for (Button button : row) {
                if (button.getId() == id) {
                    return button;
                }
            }
        }
        return null;
    }

    private boolean checkForWin() {
        for (Button button : availableButtons) {
            int buttonId = button.getId();
            int[] adjacentIds = {buttonId - 1, buttonId + 1,
                    buttonId - 3, buttonId + 3};
            boolean hasAdjacentFreeCell = false;
            for (int id : adjacentIds) {
                Button adjacentButton = findButtonById(id);
                if (adjacentButton != null && availableButtons.contains(adjacentButton)) {
                    hasAdjacentFreeCell = true;
                    break;
                }
            }
            if (!hasAdjacentFreeCell) {
                return true;
            }
        }
        return false;
    }

    private void player1Wins() {
        player1Points++;
        Toast.makeText(this, "Player 1 wins!", Toast.LENGTH_SHORT).show();
        updatePointsText();
        resetBoard();
    }
    private void player2Wins() {
        player2Points++;
        Toast.makeText(this, "Player 2 wins!", Toast.LENGTH_SHORT).show();
        updatePointsText();
        resetBoard();
    }

    private void updatePointsText() {
        textViewPlayer1.setText("Player 1: " + player1Points);
        textViewPlayer2.setText("Player 2: " + player2Points);
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
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("roundCount", roundCount);
        outState.putInt("player1Points", player1Points);
        outState.putInt("player2Points", player2Points);
        outState.putBoolean("player1Turn", player1Turn);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        roundCount = savedInstanceState.getInt("roundCount");
        player1Points = savedInstanceState.getInt("player1Points");
        player2Points = savedInstanceState.getInt("player2Points");
        player1Turn = savedInstanceState.getBoolean("player1Turn");
    }

    private void showWinnerDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message)
                .setPositiveButton("OK", null)
                .show();
    }

    public void goBack(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        onPause();
    }
}