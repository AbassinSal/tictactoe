package com.example.de;

class GameField {

    int[][] coordinates = new int[3][3];


    void draw() {

        //Head
        System.out.println("   A   B   C ");

        //Body
        for (int coordinateY = 1; coordinateY < 4; coordinateY++) {
            String columns = coordinateY + "    |   |   ";
            String rows = "  -- + - + --";
            System.out.println(columns);
            if (coordinateY != 3) {
                System.out.println(rows);
            }
        }
    }

    boolean update(String userInput, boolean playerOneMove) {





        //TODO woher wissen wir ob X oder O
        //TODO darf der Spieler setzen? Gewonnen, beendet oder belegt
    }

    boolean isGameOver() {

        for (int i = 0; i < 3; i++) {


            int[] row = new int[3];

            for (int j = 0; j < 3; j++) {
                row[j] = coordinates[j][i];
            }

            int sumRow = 0;

            for (int j = 0; j < 3; j++) {
                sumRow = sumRow + row[j];
            }

            if (sumRow == 3 || sumRow == 15) {
                return true;
            }
        }

//        for (int i = 0; i < 3; i++) {
//
//            int[] col = new int[3];
//
//            for (int j = 0; j < 3; j++) {
//                col[j] = coordinates[j][i];
//            }
//
//            int sumCol = 0;
//
//            for (int j = 0; j < 3; j++) {
//               sumCol = sumCol + col[j];
//            }
//
//            if (sumCol == 3 || sumCol == 15) {
//                return true;
//            }
//
//        }


    }
}
