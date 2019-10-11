package com.example.de.game;

import java.util.Scanner;
public class GameController {

    private boolean gameOver = false;

    private GameField gameField = new GameField();

    private Scanner scanner = new Scanner(System.in);

    public void start() {
        gameField.draw();

        boolean playerOneMove = true;
        while (!gameOver) {
            String input;

            if (playerOneMove) {
                System.out.println("Eingabe Spieler Eins: ");
                input = scanner.nextLine();

                boolean correctInput = true;
                while(correctInput) {

                    while (!input.matches("[a-c]+[1-3]")) {

                        System.out.println("Eingabe nicht korrekt");
                        System.out.println("Eingabe Spieler Eins: ");
                        input = scanner.nextLine();
                    }

                    if (input.length() > 1 && input.length() < 3) {
                        char column = input.charAt(0);
                        int row = Integer.parseInt(String.valueOf(input.charAt(1)));

                        correctInput = gameField.turn(true, column, row);

                        if (correctInput) {
                            endOfGame(playerOneMove);
                            playerOneMove = false;
                        }
                    }
                }
            } else {
                System.out.println("Eingabe Spieler Zwei: ");
                input = scanner.nextLine();

                boolean correctInput = true;
                while (correctInput) {
                    while (!input.matches("([a-c]+[1-3])")) {

                        System.out.println("Eingabe nicht korrekt");
                        System.out.println("Eingabe Spieler Zwei: ");
                        input = scanner.nextLine();
                    }

                    if (input.length() > 1 && input.length() < 3) {
                        char column = input.charAt(0);
                        int row = Integer.parseInt(String.valueOf(input.charAt(1)));

                        correctInput = gameField.turn(false, column, row);

                        if (correctInput) {
                            endOfGame(playerOneMove);
                            playerOneMove = true;
                        }
                    }
                }
            }
        }
    }

        void endOfGame(boolean playerOneMove) {
            if (gameField.checkIfWinner(playerOneMove)) {
                if (playerOneMove){
                    System.out.println("Spieler Eins hat gewonnen");
                } else if (!playerOneMove) {
                    System.out.println("Spieler Zwei hat gewonnen");
                }
                System.out.println("Spiel beenden?\n[neu]\n[ende]");
                String restartInput = scanner.nextLine();
                if (restartInput.equals("neu")) {
                    gameField.clearArray();
                    start();
                } else if (restartInput.equals("ende")) {
                    gameOver = true;
                }
            }
        }
}
