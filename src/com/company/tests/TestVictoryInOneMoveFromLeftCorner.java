package com.company.tests;

import com.company.ai.VictoryInOneMoveFromLeftCorner;
import com.company.Move;

public class TestVictoryInOneMoveFromLeftCorner {
    int countTests = 1;
    VictoryInOneMoveFromLeftCorner victoryInOneMoveFromLeftCorner = new VictoryInOneMoveFromLeftCorner();

    /*
        0;0 | 0;1 | 0;2
        ---------------
        1;0 | 1;1 | 1;2
        ---------------
        2;0 | 2;1 | 2;2
     */

    public static void main(String[] args) {
        TestVictoryInOneMoveFromLeftCorner testVictoryInOneMoveFromLeftCorner = new TestVictoryInOneMoveFromLeftCorner();
        testVictoryInOneMoveFromLeftCorner.test1();
        testVictoryInOneMoveFromLeftCorner.test2();
        testVictoryInOneMoveFromLeftCorner.test3();
        testVictoryInOneMoveFromLeftCorner.test4();
        testVictoryInOneMoveFromLeftCorner.test5();
    }

    private void test1() {
        char[][] strings = {{'-', '-', '-'},{'-', '-','-'},{'-', '-', '-'}};
        Move realResult = victoryInOneMoveFromLeftCorner.execute(strings, 'X');
        Move expectedResult = new Move(-1, -1);
        if(checkMove(realResult, expectedResult)) {
            System.out.println("Test " + countTests + " OK");
        }
        else {
            System.out.println("Test " + countTests + " FAILS");
        }
        countTests++;
    }

    private void test2() {
        char[][] strings = {{'X', '-', '-'},{'-', '-','X'},{'-', 'X', '-'}};
        Move realResult = victoryInOneMoveFromLeftCorner.execute(strings, 'X');
        Move expectedResult = new Move(-1, -1);
        if(checkMove(realResult, expectedResult)) {
            System.out.println("Test " + countTests + " OK");
        }
        else {
            System.out.println("Test " + countTests + " FAILS");
        }
        countTests++;
    }

    private void test3() {
        char[][] strings = {{'-', '-', '-'},{'-', 'X','-'},{'-', '-', 'X'}};
        Move realResult = victoryInOneMoveFromLeftCorner.execute(strings, 'X');
        Move expectedResult = new Move(0, 0);
        if(checkMove(realResult, expectedResult)) {
            System.out.println("Test " + countTests + " OK");
        }
        else {
            System.out.println("Test " + countTests + " FAILS");
        }
        countTests++;
    }

    private void test4() {
        char[][] strings = {{'X', '-', '-'},{'-', '-','-'},{'-', '-', 'X'}};
        Move realResult = victoryInOneMoveFromLeftCorner.execute(strings, 'X');
        Move expectedResult = new Move(1, 1);
        if(checkMove(realResult, expectedResult)) {
            System.out.println("Test " + countTests + " OK");
        }
        else {
            System.out.println("Test " + countTests + " FAILS");
        }
        countTests++;
    }

    private void test5() {
        char[][] strings = {{'X', '-', '-'},{'-', 'X','X'},{'-', 'X', '-'}};
        Move realResult = victoryInOneMoveFromLeftCorner.execute(strings, 'X');
        Move expectedResult = new Move(2, 2);
        if(checkMove(realResult, expectedResult)) {
            System.out.println("Test " + countTests + " OK");
        }
        else {
            System.out.println("Test " + countTests + " FAILS");
        }
        countTests++;
    }

    public boolean checkMove(Move realResult, Move expectedResult) {
        return realResult.equals(expectedResult);
    }
}
