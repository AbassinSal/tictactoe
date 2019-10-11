package com.example.de.game;

import java.util.Arrays;

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

    public boolean turn(boolean playerOneMove, char column, int row) {

        char value;

        if (column == 'A' || column == 'a') {
            column = 0;
        } else if (column == 'B' || column == 'b') {
            column = 1;
        } else if (column == 'C' || column == 'c') {
            column = 2;
        }

        if (row == 1) {
            row = 0;
        } else if (row == 2) {
            row = 1;
        } else if (row == 3) {
            row = 2;
        }

        if (playerOneMove) {
            value = 'X';
        } else {
            value = 'Y';
        }
        if (playerOneMove && field[column][row] != 'Y' && field[column][row] != 'X') {
            field[column][row] = value;
            return true;
        } else if (!playerOneMove && field[column][row] != 'Y' && field[column][row] != 'X') {
            field[column][row] = value;
            return true;
        }
        return false;

    }

    public boolean checkIfWinner( boolean playerOneMove) {

        char player;
        if (playerOneMove) {
            player = 'X';
        } else {
            player = 'Y';
        }
        draw();

        return field[0][0] == player && field[0][1] == player && field[0][2] == player ||
                field[1][0] == player && field[1][1] == player && field[1][2] == player ||
                field[2][0] == player && field[2][1] == player && field[2][2] == player ||
                field[0][0] == player && field[1][0] == player && field[2][0] == player ||
                field[0][1] == player && field[1][1] == player && field[2][1] == player ||
                field[0][2] == player && field[1][2] == player && field[2][2] == player ||
                field[0][0] == player && field[1][1] == player && field[2][2] == player ||
                field[2][2] == player && field[1][1] == player && field[0][2] == player;
    }

    public void clearArray() {
        field = new char[NUMBER_OF_COLUMNS][NUMBER_OF_ROWS];
    }
}
