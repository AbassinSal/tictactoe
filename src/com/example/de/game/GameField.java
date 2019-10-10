package com.example.de.game;

public class GameField {

    private static final int NUMBER_OF_ROWS = 3;
    private static final int NUMBER_OF_COLUMNS = 3;

    private char[][] field = new char[NUMBER_OF_COLUMNS][NUMBER_OF_ROWS];

    public void draw() {
        for (int column = 0; column < NUMBER_OF_COLUMNS; column++) {
            for (int row = 0; row < NUMBER_OF_ROWS; row++) {
                if (row == 1 || row == 2) {
                    System.out.print(" | ");
                }
                System.out.print(field[column][row]);
            }
            System.out.print("\n");
        }
    }

    public void turn(boolean playerOneMove, int column, int row) {

        char value;

        if (playerOneMove) {
            value = 'X';
        } else {
            value = 'Y';
        }
        field[column][row] = value;
    }

    public boolean checkIfWinner(char player) {

        if (field[0][0] == player && field[0][1] == player && field[0][2] == player ||
                field[1][0] == player && field[1][1] == player && field[1][2] == player ||
                field[2][0] == player && field[2][1] == player && field[2][2] == player ||
                field[0][0] == player && field[1][0] == player && field[2][0] == player ||
                field[0][1] == player && field[1][1] == player && field[2][1] == player ||
                field[0][2] == player && field[1][2] == player && field[2][2] == player ||
                field[0][0] == player && field[1][1] == player && field[2][2] == player ||
                field[2][2] == player && field[1][1] == player && field[0][2] == player) {
            return true;
        } else {
            return false;
        }
    }
}
