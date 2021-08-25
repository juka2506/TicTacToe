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
        String[][] field = createField();
        while (true) {
            printFieldToConsole(field);
            Move move0 = getNextMove();
            field[move0.getX()][move0.getY()] = "X";
            printFieldToConsole(field);
            System.out.println("----------------");
            if (isWinPosition(field, "X")) {
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
            randomMoveAI(field, "0"); // делаем рандомный ход = artificial intellect
            printFieldToConsole(field);
            System.out.println("----------------");
            if (isWinPosition(field, "0")) {
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
        String[][] field = createField();
        while (true) {
            printFieldToConsole(field);
            Move move0 = getNextMove();
            field[move0.getX()][move0.getY()] = "X";
            printFieldToConsole(field);
            System.out.println("----------------");
            if (isWinPosition(field, "X")) {
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
            //randomMoveAI(field, "0"); // делаем рандомный ход = artificial intellect
            printFieldToConsole(field);
            System.out.println("----------------");
            if (isWinPosition(field, "0")) {
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
        String[][] field = createField();
        while (true) {
            printFieldToConsole(field);
            Move move0 = getNextMove();
            field[move0.getX()][move0.getY()] = "X";
            printFieldToConsole(field);
            System.out.println("----------------");
            if (isWinPosition(field, "X")) {
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
            field[move1.getX()][move1.getY()] = "0";
            printFieldToConsole(field);
            System.out.println("----------------");
            if (isWinPosition(field, "0")) {
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

    public void randomMoveAI(String[][] field, String player) {
        while (true) {
            Move move1 = getNextRandomMove();
            if (field[move1.getX()][move1.getY()].equals("-")) {
                field[move1.getX()][move1.getY()] = player;
                break;
            }
        }
    }


    public String[][] createField() {
        String[][] field = new String[3][3];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) { //а через arrays.fill нельзя было?
                field[i][j] = "-";
            }
        }
        return field;
    }

    public void printFieldToConsole(String[][] field) {
        for (String[] strings : field) {
            for (String string : strings) {
                System.out.print(string + " ");
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

    public boolean isDraw(String[][] field) {
        return !isWin(field) && !isEmptySpots(field);
    }

    public boolean isEmptySpots(String[][] field) {
        String emptyToCheck = "-";
        for (String[] ints : field) {
            for (String anInt : ints) {
                if (anInt.equals(emptyToCheck)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isWin(String[][] field) {
        boolean winFor0 = isWinPosition(field, "X");
        boolean winFor1 = isWinPosition(field, "0");
        return winFor0 || winFor1;
    }

    public boolean isWinPosition(String[][] field, String playerToCheck) {
        boolean winHorizontals = isWinPositionForHorizontals(field, playerToCheck);
        boolean winVerticals = isWinPositionForVerticals(field, playerToCheck);
        boolean winDiagonals = isWinPositionForDiagonals(field, playerToCheck);
        return winHorizontals || winVerticals || winDiagonals;
    }

    public boolean isWinPositionForHorizontals(String[][] field, String playerToCheck) {
        return checkForHorizontals(field, playerToCheck);
    }

    public boolean isWinPositionForVerticals(String[][] field, String playerToCheck) {
        return checkForVerticals(field, playerToCheck);
    }

    public boolean isWinPositionForDiagonals(String[][] field, String playerToCheck) {
        return checkForDiagonals(field, playerToCheck);
    }

    public boolean checkForHorizontals(String[][] field, String playerToCheck) {
        for (String[] strings : field) {
            int count = 0;
            for (String anInt : strings) {
                if (anInt.equals(playerToCheck)) {
                    count++;
                }
                if (count == strings.length) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkForVerticals(String[][] field, String playerToCheck) {
        for (int i = 0; i < field.length; i++) {
            int count = 0;
            for (int j = 0; j < field[i].length; j++) {
                if (field[j][i].equals(playerToCheck)) {
                    count++;
                }
                if (count == field[i].length) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkForDiagonals(String[][] field, String playerToCheck) {
        boolean check1 = fromLeftCorner(field, playerToCheck);
        boolean check2 = fromRightCorner(field, playerToCheck);
        return check1 || check2;
    }

    public boolean fromLeftCorner(String[][] field, String playerToCheck) { //для диагонали слевого верхнего угла, в правый нижний угол
        int count = 0;
        int j = 0;
        for (String[] strings : field) {
            if (strings[j].equals(playerToCheck)) {
                count++;
            }
            j++;
            if (count == strings.length) {
                return true;
            }
        }
        return false;
    }

    public boolean fromRightCorner(String[][] field, String playerToCheck) { //для диагонали справого верхнего угла, в левый нижний угол
        int count = 0;
        int j = field.length - 1;
        for (String[] strings : field) {
            if (strings[j].equals(playerToCheck)) {
                count++;
            }
            j--;
            if (count == strings.length) {
                return true;
            }
        }
        return false;
    }



    /*public void play() {
        int[][] field = createField();
        while (true) {
            printFieldToConsole(field);
            Move move0 = getNextMove();
            field[move0.getX()][move0.getY()] = 0;
            printFieldToConsole(field);
            System.out.println("----------------");
            if (isWinPosition(field, 0)) {
                System.out.println("Player 0 WIN!");
                break;
            }
            if (isDraw(field)) {
                System.out.println("DRAW!");
                break;
            }

            printFieldToConsole(field);
            System.out.println("----------------");
            randomMoveAI(field, 1); // делаем рандомный ход = artificial intellect
            printFieldToConsole(field);
            System.out.println("----------------");
            if (isWinPosition(field, 1)) {
                System.out.println("Player 1 WIN!");
                break;
            }
            if (isDraw(field)) {
                System.out.println("DRAW!");
                break;
            }
        }
    }

    public void randomMoveAI(int[][] field, int player) {
        while (true) {
            Move move1 = getNextRandomMove();
            if (field[move1.getX()][move1.getY()] == -1) {
                field[move1.getX()][move1.getY()] = player;
                break;
            }
        }
    }


    public int[][] createField() {
        int[][] field = new int[3][3];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) { //а через arrays.fill нельзя было?
                field[i][j] = -1;
            }
        }
        return field;
    }

    public void printFieldToConsole(int[][] field) {
        for (int[] ints : field) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public Move getNextMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter Х coordinate for your next move: ");//// запросите у пользователя с консоли две координаты
        int x = scanner.nextInt();
        System.out.println("Please enter Y coordinate for your next move: ");
        int y = scanner.nextInt();
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

    public boolean isDraw(int[][] field) {
        return !isWin(field) && !isEmptySpots(field);
    }

    public boolean isEmptySpots(int[][] field) {
        int emptyToCheck = -1;
        for (int[] ints : field) {
            for (int anInt : ints) {
                if (anInt == emptyToCheck) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isWin(int[][] field) {
        boolean winFor0 = isWinPosition(field, 0);
        boolean winFor1 = isWinPosition(field, 1);
        return winFor0 || winFor1;
    }

    public boolean isWinPosition(int[][] field, int playerToCheck) {
        boolean winHorizontals = isWinPositionForHorizontals(field, playerToCheck);
        boolean winVerticals = isWinPositionForVerticals(field, playerToCheck);
        boolean winDiagonals = isWinPositionForDiagonals(field, playerToCheck);
        return winHorizontals || winVerticals || winDiagonals;
    }

    public boolean isWinPositionForHorizontals(int[][] field, int playerToCheck) {
        return checkForHorizontals(field, playerToCheck);
    }

    public boolean isWinPositionForVerticals(int[][] field, int playerToCheck) {
        return checkForVerticals(field, playerToCheck);
    }

    public boolean isWinPositionForDiagonals(int[][] field, int playerToCheck) {
        return checkForDiagonals(field, playerToCheck);
    }

    public boolean checkForHorizontals(int[][] field, int playerToCheck) {
        for (int[] ints : field) {
            int count = 0;
            for (int anInt : ints) {
                if (anInt == playerToCheck) {
                    count++;
                }
                if (count == ints.length) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkForVerticals(int[][] field, int playerToCheck) {
        for (int i = 0; i < field.length; i++) {
            int count = 0;
            for (int j = 0; j < field[i].length; j++) {
                if (field[j][i] == playerToCheck) {
                    count++;
                }
                if (count == field[i].length) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkForDiagonals(int[][] field, int playerToCheck) {
        boolean check1 = fromLeftCorner(field, playerToCheck);
        boolean check2 = fromRightCorner(field, playerToCheck);
        return check1 || check2;
    }

    public boolean fromLeftCorner(int[][] field, int playerToCheck) { //для диагонали слевого верхнего угла, в правый нижний угол
        int count = 0;
        int j = 0;
        for (int[] ints : field) {
            if (ints[j] == playerToCheck) {
                count++;
            }
            j++;
            if (count == ints.length) {
                return true;
            }
        }
        return false;
    }

    public boolean fromRightCorner(int[][] field, int playerToCheck) { //для диагонали справого верхнего угла, в левый нижний угол
        int count = 0;
        int j = field.length - 1;
        for (int[] ints : field) {
            if (ints[j] == playerToCheck) {
                count++;
            }
            j--;
            if (count == ints.length) {
                return true;
            }
        }
        return false;
    }*/
}

