package com.company;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private int scoreForXPlayer;
    private int scoreFor0Player;

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.beginning();
    }

    private void beginning() {
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
            case 1 -> beginning();
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

    public void playWithComputerBeginnerLevel() {
        char[][] field = createField();
        while (true) {
            printFieldToConsole(field);
            Move move0 = getNextMove();
            field[move0.getX()][move0.getY()] = 'X';
            printFieldToConsole(field);
            System.out.println("----------------");
            if (isWinPosition(field, 'X')) {
                System.out.println("Player X WIN!");
                scoreForXPlayer++;
                System.out.println("Player X " + scoreForXPlayer + " - " + scoreFor0Player + " Player Y");
                end();
                break;
            }
            if (isDraw(field)) {
                System.out.println("DRAW!");
                end();
                break;
            }

            printFieldToConsole(field);
            System.out.println("----------------");
            randomMoveAI(field, '0'); // делаем рандомный ход = artificial intellect
            printFieldToConsole(field);
            System.out.println("----------------");
            if (isWinPosition(field, '0')) {
                System.out.println("Player 0 WIN!");
                scoreFor0Player++;
                System.out.println("Player X " + scoreForXPlayer + " - " + scoreFor0Player + " Player Y");
                end();
                break;
            }
            if (isDraw(field)) {
                System.out.println("DRAW!");
                end();
                break;
            }
        }
    }

    public void playWithComputerAdvancedLevel() {
        char[][] field = createField();
        while (true) {
            printFieldToConsole(field);
            Move move0 = getNextMove();
            field[move0.getX()][move0.getY()] = 'X';
            printFieldToConsole(field);
            System.out.println("----------------");
            if (isWinPosition(field, 'X')) {
                System.out.println("Player X WIN!");
                scoreForXPlayer++;
                System.out.println("Player X " + scoreForXPlayer + " - " + scoreFor0Player + " Player Y");
                end();
                break;
            }
            if (isDraw(field)) {
                System.out.println("DRAW!");
                end();
                break;
            }

            printFieldToConsole(field);
            System.out.println("----------------");
            //randomMoveAI(field, '0'); // делаем рандомный ход = artificial intellect
            printFieldToConsole(field);
            System.out.println("----------------");
            if (isWinPosition(field, '0')) {
                System.out.println("Player 0 WIN!");
                scoreFor0Player++;
                System.out.println("Player X " + scoreForXPlayer + " - " + scoreFor0Player + " Player Y");
                end();
                break;
            }
            if (isDraw(field)) {
                System.out.println("DRAW!");
                end();
                break;
            }
        }
    }

    public void playWithYourFriend() {
        char[][] field = createField();
        while (true) {
            printFieldToConsole(field);
            Move move0 = getNextMove();
            field[move0.getX()][move0.getY()] = 'X';
            printFieldToConsole(field);
            System.out.println("----------------");
            if (isWinPosition(field, 'X')) {
                System.out.println("Player X WIN!");
                scoreForXPlayer++;
                System.out.println("Player X " + scoreForXPlayer + " - " + scoreFor0Player + " Player Y");
                end();
                break;
            }
            if (isDraw(field)) {
                System.out.println("DRAW!");
                end();
                break;
            }
            printFieldToConsole(field);
            System.out.println("----------------");
            Move move1 = getNextMove();
            field[move1.getX()][move1.getY()] = '0';
            printFieldToConsole(field);
            System.out.println("----------------");
            if (isWinPosition(field, '0')) {
                System.out.println("Player 0 WIN!");
                scoreFor0Player++;
                System.out.println("Player X " + scoreForXPlayer + " - " + scoreFor0Player + " Player Y");
                end();
                break;
            }
            if (isDraw(field)) {
                System.out.println("DRAW!");
                end();
                break;
            }
        }
    }

    public void randomMoveAI(char[][] field, char player) {
        while (true) {
            Move move1 = getNextRandomMove();
            if (field[move1.getX()][move1.getY()] == ('-')) {
                field[move1.getX()][move1.getY()] = player;
                break;
            }
        }
    }

    public char[][] createField() {
        char[][] field = new char[3][3];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) { //а через arrays.fill нельзя было?
                field[i][j] = '-';
            }
        }
        return field;
    }

    public void printFieldToConsole(char[][] field) {
        for (char[] ch : field) {
            for (char c : ch) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public Move getNextMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter row (1-3) for your next move: ");//// запросите у пользователя с консоли две координаты
        int x = (scanner.nextInt() - 1);
        System.out.print("Please enter column (1-3) for your next move: ");
        int y = (scanner.nextInt() - 1);
        Move move = new Move(x, y);
        return move;
    }

    public Move getNextRandomMove() {
        Random random = new Random();
        int x = random.nextInt(3); //заменили вместо ввода на использование рандомных значений для определения индекса элемента
        int y = random.nextInt(3);
        Move move = new Move(x, y);
        return move;
    }

    public boolean isDraw(char[][] field) {
        return !isWin(field) && !isEmptySpots(field);
    }

    public boolean isEmptySpots(char[][] field) {
        char emptyToCheck = '-';
        for (char[] ints : field) {
            for (char anInt : ints) {
                if (anInt == (emptyToCheck)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isWin(char[][] field) {
        boolean winFor0 = isWinPosition(field, 'X');
        boolean winFor1 = isWinPosition(field, '0');
        return winFor0 || winFor1;
    }

    public boolean isWinPosition(char[][] field, char playerToCheck) {
        boolean winHorizontals = isWinPositionForHorizontals(field, playerToCheck);
        boolean winVerticals = isWinPositionForVerticals(field, playerToCheck);
        boolean winDiagonals = isWinPositionForDiagonals(field, playerToCheck);
        return winHorizontals || winVerticals || winDiagonals;
    }

    public boolean isWinPositionForHorizontals(char[][] field, char playerToCheck) {
        return checkForHorizontals(field, playerToCheck);
    }

    public boolean isWinPositionForVerticals(char[][] field, char playerToCheck) {
        return checkForVerticals(field, playerToCheck);
    }

    public boolean isWinPositionForDiagonals(char[][] field, char playerToCheck) {
        return checkForDiagonals(field, playerToCheck);
    }

    public boolean checkForHorizontals(char[][] field, char playerToCheck) {
        for (char[] chars : field) {
            int count = 0;
            for (char anInt : chars) {
                if (anInt == (playerToCheck)) {
                    count++;
                }
                if (count == chars.length) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkForVerticals(char[][] field, char playerToCheck) {
        for (int i = 0; i < field.length; i++) {
            int count = 0;
            for (int j = 0; j < field[i].length; j++) {
                if (field[j][i] == (playerToCheck)) {
                    count++;
                }
                if (count == field[i].length) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkForDiagonals(char[][] field, char playerToCheck) {
        boolean check1 = fromLeftCorner(field, playerToCheck);
        boolean check2 = fromRightCorner(field, playerToCheck);
        return check1 || check2;
    }

    public boolean fromLeftCorner(char[][] field, char playerToCheck) { //для диагонали слевого верхнего угла, в правый нижний угол
        int count = 0;
        int j = 0;
        for (char[] chars : field) {
            if (chars[j] == (playerToCheck)) {
                count++;
            }
            j++;
            if (count == chars.length) {
                return true;
            }
        }
        return false;
    }

    public boolean fromRightCorner(char[][] field, char playerToCheck) { //для диагонали справого верхнего угла, в левый нижний угол
        int count = 0;
        int j = field.length - 1;
        for (char[] chars : field) {
            if (chars[j] == (playerToCheck)) {
                count++;
            }
            j--;
            if (count == chars.length) {
                return true;
            }
        }
        return false;
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

    public Move aiForSecondMove(char[][] field) {
        int xFirstMove = -1;
        int yFirstMove = -1;
        Move move = new Move(-1, -1);
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == ('X')) {
                    xFirstMove = i;
                    yFirstMove = j;
                }
            }
        }
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

}

