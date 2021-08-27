package com.company.ai;

import com.company.Move;

public class VictoryInOneMoveInVerticals {

    public Move execute(char[][] field, char playerToCheck) {
        Move move = new Move(-1, -1);
        for (int i = 0; i < field.length; i++) {
            int countPlayerToCheck = 0;
            int countEmptyCells = 0;
            for (int j = 0; j < field[i].length; j++) {
                if (field[j][i] == playerToCheck) {
                    countPlayerToCheck++;
                }
                if (field[j][i] == '-') {
                    countEmptyCells++;
                }
                if (countPlayerToCheck == 2 && countEmptyCells == 1) { // Victory in one move is possible in this column.
                    move.setY(i); // we found column there victory is possible, set it to Y value for next move
                }
                if (move.getY() != -1) { //if initial value of column was changed, find row with empty spot going through rows once again (one more loop)
                    for (int k = 0; k < field.length; k++) {
                        if (field[k][move.getY()] == '-') {
                            move.setX(k); // set row for our next move
                        }
                    }
                }
            }
        }
        return move;
    }
}
