package com.company.ai;

import com.company.Move;

import java.util.Random;

public class RandomMoveAI {

    public void makeMove(char[][] field, char player) {
        while (true) {
            Move move1 = getNextRandomMove();
            if (field[move1.getX()][move1.getY()] == ('-')) {
                field[move1.getX()][move1.getY()] = player;
                break;
            }
        }
    }

    private Move getNextRandomMove() {
        Random random = new Random();
        int x = random.nextInt(3); //заменили вместо ввода на использование рандомных значений для определения индекса элемента
        int y = random.nextInt(3);
        Move move = new Move(x, y);
        return move;
    }
}
