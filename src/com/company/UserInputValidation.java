package com.company;

public class UserInputValidation {

    public boolean isInputValid(char[][] field, int x, int y) {
        return userInputValidation(x, y) && isChosenCellFree(field, x, y);
    }

    private boolean userInputValidation(int x, int y) {
        if (x >= 0 && x <= 2
                && y >= 0 && y <= 2) {
            return true;
        } else {
            System.out.println("You have entered incorrect data. Try again.");
            return false;
        }
    }

    private boolean isChosenCellFree(char[][] field, int x, int y) {
        if (field[x][y] == '-') {
            return true;
        } else {
            System.out.println("The chosen cell is already occupied. Please try again.");
            return false;
        }
    }


}
