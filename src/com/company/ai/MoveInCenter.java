package com.company.ai;

import com.company.Move;

public class MoveInCenter {

    public Move getMove(char[][] field) {

        Move move = new Move(-1, -1); // -1;-1 - random values, no meaning for them here, just something for constructor
        if (isCenterFree(field)) { //center is free - take it
            move.setX(1);
            move.setY(1);

        }
        return move;
    }

    private boolean isCenterFree(char[][] field) {
        if (field[1][1] == '-') {
            return true;
        } else {
            return false;
        }
    }

}
