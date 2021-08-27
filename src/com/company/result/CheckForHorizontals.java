package com.company.result;

public class CheckForHorizontals {

    public boolean execute(char[][] field, char playerToCheck) {
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
}
