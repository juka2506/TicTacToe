package com.company.ai;

import com.company.Move;

public class VictoryInOneMoveInHorizontals {

    public Move execute(char[][] field, char playerToCheck) {
        Move move = new Move(-1, -1);
        for (int i = 0; i < field.length; i++) {
            int countPlayerToCheck = 0;
            int countEmptyCells = 0;
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == playerToCheck) {
                    countPlayerToCheck++;
                }
                if (field[i][j] == '-') {
                    countEmptyCells++;
                }
                if (countPlayerToCheck == 2 && countEmptyCells == 1) { // Victory in one move is possible in this row. It looks as XX- or X-X or -XX
                    move.setX(i); // set row for our next move
                }
                if (move.getX() != -1) { //if initial value of row was changed, find column with empty spot going through columns once again (one more loop)
                    for (int k = 0; k < field.length; k++) {
                        if (field[move.getX()][k] == '-') {
                            move.setY(k); // set column for our next move
                        }
                    }
                }
            }
        }
        return move;
    }
}
