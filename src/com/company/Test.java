package com.company;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        char[][] strings = {{'-', '-', '-'},{'-', 'X','-'},{'-', '-', '-'}};
        System.out.println(Arrays.deepToString(strings));
        System.out.println(ticTacToe.aiForSecondMove(strings));

    }
}
