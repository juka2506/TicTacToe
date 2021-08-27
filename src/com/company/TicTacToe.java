package com.company;

import com.company.ai.AI;
import com.company.result.Result;

import java.util.Scanner;

public class TicTacToe {

     /*
        0;0 | 0;1 | 0;2
        ---------------
        1;0 | 1;1 | 1;2
        ---------------
        2;0 | 2;1 | 2;2
     */

    private int scoreForXPlayer;
    private int scoreFor0Player;

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.play();
    }

    private void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Game menu: ");
        System.out.println("Press 1 if you would like to play with computer.");
        System.out.println("Press 2 if you would like to play with your friend.");
        System.out.println("Press 3 for Exit.");
        System.out.print("Your choice: ");
        int userInput = scanner.nextInt();
        switch (userInput) {
            case 1 -> computerMenu();
            case 2 -> playWithYourFriend();
            case 3 -> System.exit(0);
        }
    }

    private void end() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to play once again? ");
        System.out.println("Press 1 if yes.");
        System.out.println("Press 2 if no.");
        System.out.print("Your choice: ");
        int userInput = scanner.nextInt();
        switch (userInput) {
            case 1 -> play();
            case 2 -> System.exit(0);
        }
    }

    private void computerMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Difficulty menu: ");
        System.out.println("Press 1 for beginner level.");
        System.out.println("Press 2 for advanced level.");
        System.out.print("Your choice: ");
        int userInput = scanner.nextInt();
        switch (userInput) {
            case 1 -> playWithComputerBeginnerLevel();
            case 2 -> playWithComputerAdvancedLevel();
        }
        System.out.println();
    }

    private void playWithComputerBeginnerLevel() {
        FieldService fieldService = new FieldService();
        char[][] field = fieldService.createField();
        AI ai = new AI();
        Result result = new Result();
        fieldService.printFieldToConsole(field);
        while (true) {
            Move move0 = getNextMove();
            field[move0.getX()][move0.getY()] = 'X';
            fieldService.printFieldToConsole(field);
            if (result.isWinPosition(field, 'X')) {
                System.out.println("Player X WIN!");
                scoreForXPlayer++;
                System.out.println("Player X " + scoreForXPlayer + " - " + scoreFor0Player + " Player Y");
                end();
                break;
            }
            if (result.isDraw(field)) {
                System.out.println("DRAW!");
                end();
                break;
            }

            ai.makeNextBeginnerAIMove(field, '0');
            fieldService.printFieldToConsole(field);
            if (result.isWinPosition(field, '0')) {
                System.out.println("Player 0 WIN!");
                scoreFor0Player++;
                System.out.println("Player X " + scoreForXPlayer + " - " + scoreFor0Player + " Player Y");
                end();
                break;
            }
            if (result.isDraw(field)) {
                System.out.println("DRAW!");
                end();
                break;
            }
        }
    }

    private void playWithComputerAdvancedLevel() {
        FieldService fieldService = new FieldService();
        char[][] field = fieldService.createField();
        AI ai = new AI();
        Result result = new Result();
        fieldService.printFieldToConsole(field);
        while (true) {
            Move move0 = getNextMove();
            field[move0.getX()][move0.getY()] = 'X';
            fieldService.printFieldToConsole(field);
            if (result.isWinPosition(field, 'X')) {
                System.out.println("Player X WIN!");
                scoreForXPlayer++;
                System.out.println("Player X " + scoreForXPlayer + " - " + scoreFor0Player + " Player Y");
                end();
                break;
            }
            if (result.isDraw(field)) {
                System.out.println("DRAW!");
                end();
                break;
            }

            ai.makeNextAdvancedAIMove(field, '0', 'X');
            fieldService.printFieldToConsole(field);
            if (result.isWinPosition(field, '0')) {
                System.out.println("Player 0 WIN!");
                scoreFor0Player++;
                System.out.println("Player X " + scoreForXPlayer + " - " + scoreFor0Player + " Player Y");
                end();
                break;
            }
            if (result.isDraw(field)) {
                System.out.println("DRAW!");
                end();
                break;
            }
        }
    }

    private void playWithYourFriend() {
        FieldService fieldService = new FieldService();
        char[][] field = fieldService.createField();
        Result result = new Result();
        fieldService.printFieldToConsole(field);
        while (true) {
            Move move0 = getNextMove();
            field[move0.getX()][move0.getY()] = 'X';
            fieldService.printFieldToConsole(field);
            if (result.isWinPosition(field, 'X')) {
                System.out.println("Player X WIN!");
                scoreForXPlayer++;
                System.out.println("Player X " + scoreForXPlayer + " - " + scoreFor0Player + " Player Y");
                end();
                break;
            }
            if (result.isDraw(field)) {
                System.out.println("DRAW!");
                end();
                break;
            }

            Move move1 = getNextMove();
            field[move1.getX()][move1.getY()] = '0';
            fieldService.printFieldToConsole(field);
            if (result.isWinPosition(field, '0')) {
                System.out.println("Player 0 WIN!");
                scoreFor0Player++;
                System.out.println("Player X " + scoreForXPlayer + " - " + scoreFor0Player + " Player Y");
                end();
                break;
            }
            if (result.isDraw(field)) {
                System.out.println("DRAW!");
                end();
                break;
            }
        }
    }

    private Move getNextMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter row (1-3) for your next move: ");//// запросите у пользователя с консоли две координаты
        int x = (scanner.nextInt() - 1);
        System.out.print("Please enter column (1-3) for your next move: ");
        int y = (scanner.nextInt() - 1);
        Move move = new Move(x, y);
        return move;
    }

}

