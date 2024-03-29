package com.example.trimino;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class GamePlay1 extends AppCompatActivity implements View.OnClickListener {

    private Button[][] buttons = new Button[4][4];
    private char[][] board = new char[4][4];
    private boolean isPlayerXTurn = true; // Первый ходит игрок X
    private int xCount = 0; // Количество размещенных символов X
    private int oCount = 0; // Количество размещенных символов O
    private int lastPlacedRow = -1; // Последний размещенный ряд
    private int lastPlacedCol = -1; // Последний размещенный столбец

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_play1);

        // Инициализация кнопок игрового поля и установка слушателей нажатий
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                String buttonID = "button_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this);
                board[i][j] = ' '; // Инициализация пустых клеток
            }
        }
    }

    @Override
    public void onClick(View v) {
        Button clickedButton = (Button) v;

        // Получение позиции нажатой кнопки
        int row = Character.getNumericValue(clickedButton.getTag().toString().charAt(0));
        int col = Character.getNumericValue(clickedButton.getTag().toString().charAt(1));

        // Проверка, занята ли клетка
        if (!clickedButton.getText().toString().isEmpty()) {
            Toast.makeText(this, "Cell already occupied!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Установка символа на кнопку
        if (isPlayerXTurn) {
            if (xCount < 2) {
                clickedButton.setText("X");
                board[row][col] = 'X';
                xCount++;
            } else {
                Toast.makeText(this, "Player O's turn!", Toast.LENGTH_SHORT).show();
                return;
            }
        } else {
            if (oCount < 2) {
                clickedButton.setText("O");
                board[row][col] = 'O';
                oCount++;
            } else {
                Toast.makeText(this, "Player X's turn!", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        // Проверка, стоят ли две буквы рядом по вертикали или горизонтали
        if ((isPlayerXTurn && xCount == 2) || (!isPlayerXTurn && oCount == 2)) {
            if (!checkAdjacent(row, col)) {
                Toast.makeText(this, "Two letters must be adjacent vertically or horizontally!", Toast.LENGTH_SHORT).show();
                // Удаляем только второй ход, если он недопустим
                clickedButton.setText("");
                board[row][col] = ' ';
                return;
            }
            // Переключение хода, если размещены нолики
            isPlayerXTurn = !isPlayerXTurn;
            xCount = 0; // Сброс счетчика для X
            oCount = 0; // Сброс счетчика для O
        }

        // Сохраняем позицию последней размещенной клетки
        lastPlacedRow = row;
        lastPlacedCol = col;

        // Проверка на победу или ничью
        if (checkForWin(row, col) || isDraw()) {
            if (checkForWin(row, col)) {
                Toast.makeText(this, isPlayerXTurn ? "Player X wins!" : "Player O wins!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Draw!", Toast.LENGTH_SHORT).show();
            }
            disableButtons();
        }
    }

    private void disableButtons() {
        // Отключение всех кнопок после завершения игры
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }

    private boolean checkAdjacent(int row, int col) {
        // Проверка соседних клеток по вертикали или горизонтали
        char symbol = isPlayerXTurn ? 'X' : 'O';

        // Проверка соседней клетки сверху
        if (row > 0 && board[row - 1][col] == symbol) {
            return true;
        }
        // Проверка соседней клетки снизу
        if (row < 3 && board[row + 1][col] == symbol) {
            return true;
        }
        // Проверка соседней клетки слева
        if (col > 0 && board[row][col - 1] == symbol) {
            return true;
        }
        // Проверка соседней клетки справа
        if (col < 3 && board[row][col + 1] == symbol) {
            return true;
        }
        return false;
    }

    private boolean isDraw() {
        // Проверка на ничью
        return !hasAdjacentCells() && isLastMovesSequential();
    }

    private boolean hasAdjacentCells() {
        // Проверка наличия соседних ячеек по вертикали или горизонтали
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (!buttons[i][j].getText().toString().isEmpty()) {
                    if (i > 0 && !buttons[i - 1][j].getText().toString().isEmpty()) {
                        return true;
                    }
                    if (i < 3 && !buttons[i + 1][j].getText().toString().isEmpty()) {
                        return true;
                    }
                    if (j > 0 && !buttons[i][j - 1].getText().toString().isEmpty()) {
                        return true;
                    }
                    if (j < 3 && !buttons[i][j + 1].getText().toString().isEmpty()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isLastMovesSequential() {
        // Проверка последовательных ходов
        return (xCount == 2 && oCount == 2) || (xCount == 0 && oCount == 0);
    }

    private boolean checkForWin(int row, int col) {
        // Проверка на победу
        char symbol = board[row][col];

        // Проверка горизонталей
        if (board[row][(col + 1) % 4] == symbol && board[row][(col + 2) % 4] == symbol && board[row][(col + 3) % 4] == symbol) {
            return true;
        }

        // Проверка вертикалей
        if (board[(row + 1) % 4][col] == symbol && board[(row + 2) % 4][col] == symbol && board[(row + 3) % 4][col] == symbol) {
            return true;
        }

        return false;
    }
}
