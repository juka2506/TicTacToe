package com.company.ai;

import com.company.Move;

import java.util.Random;

public class SecondMoveAI {

    public Move makeMove(char[][] field) {
        int xFirstMove = -1;
        int yFirstMove = -1;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == ('X')) {
                    xFirstMove = i;
                    yFirstMove = j;
                }
            }
        }
        Move move = new Move(-1, -1); // -1;-1 - random values, no meaning for them here, just something for constructor
        if (xFirstMove != 1 || yFirstMove != 1) { //center is free - take it
            move.setX(1);
            move.setY(1);
        } else { //first move was not in the center, take any corner randomly
            Random random = new Random();
            int randomCorner = random.nextInt(4);
            //0 - for left upper corner (0; 0); 1 - for right upper corner (0; 2);
            // 2 - for left lower corner (2; 0); 3 - for right lower corner (2; 2);
            switch (randomCorner) {
                case 0 -> {
                    move.setX(0);
                    move.setY(0);
                }
                case 1 -> {
                    move.setX(0);
                    move.setY(2);
                }
                case 2 -> {
                    move.setX(2);
                    move.setY(0);
                }
                case 3 -> {
                    move.setX(2);
                    move.setY(2);
                }
            }
        }
        return move;
    }

    public int howManyMovesAreDone(char[][] field) {
        int count = 0;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == ('-')) {
                    count++;
                }
            }
        }

        return (9 - count);
    }
}
