package com.company.ai;

import com.company.Move;

public class VictoryInOneMoveFromRightCorner {

    public Move execute(char[][] field, char playerToCheck) { //from left upper corner to right lower corner
        int j = (field.length - 1);
        Move move = new Move(-1, -1);
        int countPlayerToCheck = 0;
        int countEmptyCells = 0;
        for (int i = 0; i < field.length; i++) {
            if (field[i][j] == playerToCheck) {
                countPlayerToCheck++;
            }
            if (field[i][j] == '-') {
                countEmptyCells++;
            }
            j--;
        }

        j = (field.length - 1);
        if (countPlayerToCheck == 2 && countEmptyCells == 1) { // there is possibility to win in one move in diagonal from upper right corner
            for (int i = 0; i < field.length; i++) {
                if (field[i][j] == '-') { // to identify coordinates of one left empty cell go through diagonal once again
                    move.setX(i);
                    move.setY(j);
                }
                j--;
            }
        }
        return move;
    }
}
