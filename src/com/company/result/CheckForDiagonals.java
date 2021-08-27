package com.company.result;

public class CheckForDiagonals {

    public boolean execute(char[][] field, char playerToCheck) {
        boolean check1 = fromLeftCorner(field, playerToCheck);
        boolean check2 = fromRightCorner(field, playerToCheck);
        return check1 || check2;
    }

    private boolean fromLeftCorner(char[][] field, char playerToCheck) { //for diagonal from left upper corner
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

    private boolean fromRightCorner(char[][] field, char playerToCheck) { //for diagonal from right upper corner
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

}
