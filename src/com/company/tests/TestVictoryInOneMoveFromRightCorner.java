package com.company.tests;

import com.company.Move;
import com.company.ai.VictoryInOneMoveFromRightCorner;

public class TestVictoryInOneMoveFromRightCorner {
   int countTests = 1;
    VictoryInOneMoveFromRightCorner victoryInOneMoveFromRightCorner = new VictoryInOneMoveFromRightCorner();

    /*
        0;0 | 0;1 | 0;2
        ---------------
        1;0 | 1;1 | 1;2
        ---------------
        2;0 | 2;1 | 2;2
     */

    public static void main(String[] args) {
        TestVictoryInOneMoveFromRightCorner testVictoryInOneMoveFromRightCorner = new TestVictoryInOneMoveFromRightCorner();
        testVictoryInOneMoveFromRightCorner.test1();
        testVictoryInOneMoveFromRightCorner.test2();
        testVictoryInOneMoveFromRightCorner.test3();
        testVictoryInOneMoveFromRightCorner.test4();
        testVictoryInOneMoveFromRightCorner.test5();
    }

    private void test1() {
        char[][] strings = {{'-', '-', '-'},{'-', '-','-'},{'-', '-', '-'}};
        Move realResult = victoryInOneMoveFromRightCorner.execute(strings, 'X');
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
        Move realResult = victoryInOneMoveFromRightCorner.execute(strings, 'X');
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
        char[][] strings = {{'-', '-', '-'},{'-', 'X','-'},{'X', '-', '-'}};
        Move realResult = victoryInOneMoveFromRightCorner.execute(strings, 'X');
        Move expectedResult = new Move(0, 2);
        if(checkMove(realResult, expectedResult)) {
            System.out.println("Test " + countTests + " OK");
        }
        else {
            System.out.println("Test " + countTests + " FAILS");
        }
        countTests++;
    }

    private void test4() {
        char[][] strings = {{'-', '-', 'X'},{'-', '-','-'},{'X', '-', 'X'}};
        Move realResult = victoryInOneMoveFromRightCorner.execute(strings, 'X');
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
        char[][] strings = {{'-', '-', 'X'},{'-', 'X','-'},{'-', 'X', '-'}};
        Move realResult = victoryInOneMoveFromRightCorner.execute(strings, 'X');
        Move expectedResult = new Move(2, 0);
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
