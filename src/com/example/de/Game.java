package com.example.de;

class Game {

    private boolean gameOver;
    private GameField gameField = new GameField();
    private boolean playerOneMove;
    private Player playerOne = new Player();
    private Player playerTwo = new Player();

    void start() {
        gameField.draw();
        playerOneMove = true;

        while(gameOver) {

            String input;

            if (playerOneMove) {
                System.out.println("Spieler " + playerOne.name + " ist am Zug");
                input = playerOne.turn();
                playerOneMove = false;
            } else {
                System.out.println("Spieler" + playerTwo.name + " ist am Zug");
                input = playerTwo.turn();
                playerOneMove = true;
            }

            gameField.update(input, playerOneMove);
        }
    }
}
