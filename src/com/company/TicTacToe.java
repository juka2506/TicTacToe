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
    private char player;
    private char opponent;

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.play();
    }

    private void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--=Welcome to TIC-TAC-TOE=--");
        System.out.println("Press 1 if you would like to play with computer.");
        System.out.println("Press 2 if you would like to play with your friend.");
        System.out.println("Press 3 for Exit.");
        System.out.print("Your choice: ");
        int userInput = scanner.nextInt();
        switch (userInput) {
            case 1 -> computerMenu();
            case 2 -> playWithYourFriend();
            case 3 -> System.exit(0);
            default -> {
                System.out.println("Invalid input. Please try again.");
                play();
            }
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
            default -> {
                System.out.println("Invalid input. Please try again.");
                end();
            }
        }
    }

    private void computerMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Difficulty level: ");
        System.out.println("Press 1 for beginner level.");
        System.out.println("Press 2 for advanced level.");
        System.out.print("Your choice: ");
        int userInput = scanner.nextInt();
        switch (userInput) {
            case 1 -> playWithComputerBeginnerLevel();
            case 2 -> playWithComputerAdvancedLevel();
            default -> {
                System.out.println("Invalid input. Please try again.");
                computerMenu();
            }
        }
        System.out.println();
    }

    private void playWithComputerBeginnerLevel() {
        chooseYourSign();
        FieldService fieldService = new FieldService();
        char[][] field = fieldService.createField();
        AI ai = new AI();
        fieldService.printFieldToConsole(field);
        while (true) {
            if (player == 'X') {
                if (!ai.wasAutoLastMoveMade(field, 'X')) {
                    makeNextMove(field, 'X');
                }
                fieldService.printFieldToConsole(field);
                if(isGameOver(field, 'X')){
                    break;
                }

                if (!ai.wasAutoLastMoveMade(field, '0')) {
                    ai.makeNextBeginnerAIMove(field, '0');
                }
            } else {
                if (!ai.wasAutoLastMoveMade(field, 'X')) {
                    ai.makeNextBeginnerAIMove(field, 'X');
                }
                fieldService.printFieldToConsole(field);
                if(isGameOver(field, 'X')){
                    break;
                }

                if (!ai.wasAutoLastMoveMade(field, '0')) {
                    makeNextMove(field, '0');
                }
            }
            fieldService.printFieldToConsole(field);
            if(isGameOver(field, '0')){
                break;
            }
        }
    }

    private void playWithComputerAdvancedLevel() {
        chooseYourSign();
        FieldService fieldService = new FieldService();
        char[][] field = fieldService.createField();
        AI ai = new AI();
        fieldService.printFieldToConsole(field);
        while (true) {
            if (player == 'X') {
                if (!ai.wasAutoLastMoveMade(field, 'X')) {
                    makeNextMove(field, 'X');
                }
                fieldService.printFieldToConsole(field);
                if(isGameOver(field, 'X')){
                    break;
                }

                if (!ai.wasAutoLastMoveMade(field, '0')) {
                    ai.makeNextAdvancedAIMove(field, '0', 'X');
                }
            } else {
                if (!ai.wasAutoLastMoveMade(field, 'X')) {
                    ai.makeNextAdvancedAIMove(field, 'X', '0');
                }
                fieldService.printFieldToConsole(field);
                if(isGameOver(field, 'X')){
                    break;
                }
                if (!ai.wasAutoLastMoveMade(field, '0')) {
                    makeNextMove(field, '0');
                }
            }
            fieldService.printFieldToConsole(field);
            if(isGameOver(field, '0')){
                break;
            }
        }
    }

    private void playWithYourFriend() {
        chooseYourSign();
        FieldService fieldService = new FieldService();
        char[][] field = fieldService.createField();
        AI ai = new AI();
        fieldService.printFieldToConsole(field);
        while (true) {
            if (!ai.wasAutoLastMoveMade(field, 'X')) {
                makeNextMove(field, 'X');
            }
            fieldService.printFieldToConsole(field);
            if(isGameOver(field, 'X')){
                break;
            }

            if (!ai.wasAutoLastMoveMade(field, '0')) {
                makeNextMove(field, '0');
            }
            fieldService.printFieldToConsole(field);
            if(isGameOver(field, '0')){
                break;
            }
        }
    }

    private void chooseYourSign() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose your sign: ");
        System.out.println("Press 1 for X");
        System.out.println("Press 2 for 0");
        System.out.println("X always goes first");
        System.out.print("Your choice: ");
        int userInput = scanner.nextInt();
        switch (userInput) {
            case 1 -> {
                player = 'X';
                opponent = '0';
                System.out.println("The choice is made. You play with X.");
            }
            case 2 -> {
                player = '0';
                opponent = 'X';
                System.out.println("The choice is made. You play with 0.");
            }
            default -> {
                System.out.println("Invalid input. Please try again.");
                chooseYourSign();
            }
        }
    }

    private void makeNextMove(char[][] field, char player) {
        UserInputValidation userInputValidation = new UserInputValidation();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter row (1-3) for your next move: ");//// запросите у пользователя с консоли две координаты
        int x = (scanner.nextInt() - 1);
        System.out.print("Please enter column (1-3) for your next move: ");
        int y = (scanner.nextInt() - 1);
        if (userInputValidation.isInputValid(field, x, y)) {
            field[x][y] = player;
        } else {
            makeNextMove(field, player);
        }
    }

    private boolean isGameOver(char[][] field, char playerToCheck) {
        Result result = new Result();
        if (result.isWinPosition(field, playerToCheck)) {
            System.out.println("PLAYER " + playerToCheck + " WINS! CONGRATULATIONS!");
            if (playerToCheck == 'X') {
                scoreForXPlayer++;
            } else {
                scoreFor0Player++;
            }
            System.out.println("Player X " + scoreForXPlayer + " - " + scoreFor0Player + " Player Y");
            end();
            return true;
        }
        if (result.isDraw(field)) {
            System.out.println("DRAW!");
            System.out.println("Player X " + scoreForXPlayer + " - " + scoreFor0Player + " Player Y");
            end();
            return true;
        }
        return false;
    }
}

