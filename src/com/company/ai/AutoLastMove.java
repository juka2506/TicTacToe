package com.company.ai;

public class AutoLastMove {

    public boolean execute(char[][] field, char playerToCheck) {
        if (emptyCells(field) == 1) {
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    if (field[i][j] == '-') {
                        System.out.println("There is only one free cell left. Auto move was generated on " + (i+1) + " row and " + (j+1) + " column.");
                        field[i][j] = playerToCheck;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private int emptyCells(char[][] field) {
        int countEmpty = 0;
        for (char[] chars : field) {
            for (char aChar : chars) {
                if (aChar == '-') {
                    countEmpty++;
                }
            }
        }
        return countEmpty;
    }

}
