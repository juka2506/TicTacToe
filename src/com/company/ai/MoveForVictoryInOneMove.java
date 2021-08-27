package com.company.ai;

import com.company.Move;

public class MoveForVictoryInOneMove {

    public Move getMove(char[][] field, char playerToCheck) {
        VictoryInOneMoveInHorizontals victoryInOneMoveInHorizontals = new VictoryInOneMoveInHorizontals();
        VictoryInOneMoveInVerticals victoryInOneMoveInVerticals = new VictoryInOneMoveInVerticals();
        VictoryInOneMoveFromLeftCorner victoryInOneMoveFromLeftCorner = new VictoryInOneMoveFromLeftCorner();
        VictoryInOneMoveFromRightCorner victoryInOneMoveFromRightCorner = new VictoryInOneMoveFromRightCorner();

        Move move = new Move(-1, -1);
        if (victoryInOneMoveInHorizontals.execute(field, playerToCheck).getX() != -1   //if there was identified move in horizontal - use this move
                && victoryInOneMoveInHorizontals.execute(field, playerToCheck).getY() != -1) {
            move = victoryInOneMoveInHorizontals.execute(field, playerToCheck);
        } else if (victoryInOneMoveInVerticals.execute(field, playerToCheck).getX() != -1     //if there was identified move in verticals - use this move
                && victoryInOneMoveInVerticals.execute(field, playerToCheck).getY() != -1) {
            move = victoryInOneMoveInVerticals.execute(field, playerToCheck);
        } else if (victoryInOneMoveFromLeftCorner.execute(field, playerToCheck).getX() != -1     //if there was identified move in diagonal from left corner - use this move
                && victoryInOneMoveFromLeftCorner.execute(field, playerToCheck).getY() != -1) {
            move = victoryInOneMoveFromLeftCorner.execute(field, playerToCheck);
        } else if (victoryInOneMoveFromRightCorner.execute(field, playerToCheck).getX() != -1     //if there was identified move in diagonal from right corner - use this move
                && victoryInOneMoveFromRightCorner.execute(field, playerToCheck).getY() != -1) {
            move = victoryInOneMoveFromRightCorner.execute(field, playerToCheck);
        }
        return move;
    }
}
