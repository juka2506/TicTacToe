package com.company.result;

public class Result {

    public boolean isWin(char[][] field) {
        boolean winFor0 = isWinPosition(field, 'X');
        boolean winFor1 = isWinPosition(field, '0');
        return winFor0 || winFor1;
    }

    public boolean isWinPosition(char[][] field, char playerToCheck) {
        CheckForHorizontals checkForHorizontals = new CheckForHorizontals();
        CheckForVerticals checkForVerticals = new CheckForVerticals();
        CheckForDiagonals checkForDiagonals = new CheckForDiagonals();
        return checkForHorizontals.execute(field, playerToCheck)
                || checkForVerticals.execute(field, playerToCheck)
                || checkForDiagonals.execute(field, playerToCheck);
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

}
