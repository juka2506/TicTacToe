package com.company.ai;

import com.company.Move;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MoveInCorners {

    public Move getMove(char[][] field) {

        Move move = new Move(-1, -1); // -1;-1 - random values, no meaning for them here, just something for constructor
        List<Move> possibleCornerMoves = new ArrayList<>();

        int x1 = 0; //Corner 1 - upper right corner 0;0
        int y1 = 0;
        int x2 = 0; //Corner 2 - upper left corner 0;2
        int y2 = 2;
        int x3 = 2; //Corner 3 - left lower corner 2;0
        int y3 = 0;
        int x4 = 2; //Corner 3 - right lower corner 2;2
        int y4 = 2;

        if (isCornerFree(field, x1, y1)) {
            possibleCornerMoves.add(new Move(x1, y1));
        } else if (isCornerFree(field, x2, y2)) {
            possibleCornerMoves.add(new Move(x2, y2));
        } else if (isCornerFree(field, x3, y3)) {
            possibleCornerMoves.add(new Move(x3, y3));
        } else if (isCornerFree(field, x4, y4)) {
            possibleCornerMoves.add(new Move(x4, y4));
        }
        Random random = new Random();
        if(possibleCornerMoves.size() > 0) {
            int randomCorner = random.nextInt(possibleCornerMoves.size());
            move = possibleCornerMoves.get(randomCorner);
        }
        return move;
    }

    private boolean isCornerFree(char[][] field, int x, int y) {
        if (field[x][y] == '-') {
            return true;
        } else {
            return false;
        }
    }
}
