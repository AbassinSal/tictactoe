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

                while (input.equals("")) {
                        System.out.println("Eingabe darf nicht leer sein");
                        input = scanner.nextLine();
                    }
                    while (Integer.parseInt(String.valueOf(input.charAt(0))) >= 3 ||
                            Integer.parseInt(String.valueOf(input.charAt(1))) >= 3)
                        if (input.charAt(0) >= 3 || input.charAt(1) >= 3) {
                            System.out.println("Eingabe darf nicht über 2 liegen");
                            System.out.println("Eingabe Spieler Eins: ");
                            input = scanner.nextLine();
                        }


                if (input.length() > 1 && input.length() < 3) {
                    int column = Integer.parseInt(String.valueOf(input.charAt(0)));
                    int row = Integer.parseInt(String.valueOf(input.charAt(1)));

                    gameField.turn(true, column, row);

                    playerOneMove = false;
                }
            } else {
                System.out.println("Eingabe Spieler Zwei: ");
                input = scanner.nextLine();

                if (!input.equals("")) {
                    while(Integer.parseInt(String.valueOf(input.charAt(0))) >= 3 ||
                            Integer.parseInt(String.valueOf(input.charAt(1)))  >= 3)
                    if (input.charAt(0) >= 3 || input.charAt(1) >= 3) {
                        System.out.println("Eingabe darf nicht über 2 liegen");
                        System.out.println("Eingabe Spieler Zwei: ");
                        input = scanner.nextLine();
                    }
                }

                if(input.length() > 1 && input.length() < 3) {
                    int column = Integer.parseInt(String.valueOf(input.charAt(0)));
                    int row = Integer.parseInt(String.valueOf(input.charAt(1)));

                    gameField.turn(false, column, row);

                    playerOneMove = true;
                }
            }
            gameField.draw();

        }
    }
}
