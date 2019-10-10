package com.example.de;

import com.example.de.game.GameController;

public class GameApplication {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.start();
    }
}
