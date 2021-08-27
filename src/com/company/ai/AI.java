package com.company.ai;

import com.company.Move;

public class AI {

    public void makeNextBeginnerAIMove(char[][] field, char player) {
        RandomMoveAI randomMoveAI = new RandomMoveAI();
        randomMoveAI.makeMove(field, player);
    }

    public void makeNextAdvancedAIMove(char[][] field, char player, char opponent) {
        Move move;
        MoveForVictoryInOneMove moveForVictoryInOneMove = new MoveForVictoryInOneMove();
        RandomMoveAI randomMoveAI = new RandomMoveAI();
        SecondMoveAI secondMoveAI = new SecondMoveAI();
        MoveInCenter moveInCenter = new MoveInCenter();
        MoveInCorners moveInCorners = new MoveInCorners();


        if (secondMoveAI.howManyMovesAreDone(field) == 1) { // check is it AI first move (second move in whole game)
            move = secondMoveAI.makeMove(field);    // If it is beginning, true no take center or, if center is not empty, take corners  (in random way)
            field[move.getX()][move.getY()] = player; // fill in chosen cell with player's sign (X or 0)
        } else if (moveForVictoryInOneMove.getMove(field, player).getX() != -1 // if it is not first move for AI, search for possibility to win in one move
                && moveForVictoryInOneMove.getMove(field, player).getY() != -1) {
            move = moveForVictoryInOneMove.getMove(field, player); // if such a possibility exists, identify this move
            field[move.getX()][move.getY()] = player;         // fill in this cell with player's sign (X or 0)
        } else if (moveForVictoryInOneMove.getMove(field, opponent).getX() != -1 // if it isn't AI first move, and victory for AI in one move isn't possible,
                && moveForVictoryInOneMove.getMove(field, opponent).getY() != -1) {  // check if opponent can win in one move
            move = moveForVictoryInOneMove.getMove(field, opponent); // identify opponent's move to win a game in one move
            field[move.getX()][move.getY()] = player;           // fill in this cell by player's sign (X or 0)
        } else if (moveInCenter.getMove(field).getX() != -1 // if previous conditions weren't met, try to take center cell
                && moveInCenter.getMove(field).getY() != -1) {
            move = moveInCenter.getMove(field);
            field[move.getX()][move.getY()] = player;
        } else if (moveInCorners.getMove(field).getX() != -1 // if previous conditions weren't met, try to take random empty corner
                && moveInCorners.getMove(field).getY() != -1) {
            move = moveInCorners.getMove(field);
            field[move.getX()][move.getY()] = player;
        } else {
            randomMoveAI.makeMove(field, player); // if previous conditions weren't met, just make random move
        }
    }

}
