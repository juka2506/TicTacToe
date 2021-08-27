package com.company.tests;

import com.company.Move;
import com.company.ai.VictoryInOneMoveInHorizontals;

public class TestVictoryInOneMoveInHorizontals {
    int countTests = 1;
    VictoryInOneMoveInHorizontals victoryInOneMoveInHorizontals = new VictoryInOneMoveInHorizontals();

    /*
        0;0 | 0;1 | 0;2
        ---------------
        1;0 | 1;1 | 1;2
        ---------------
        2;0 | 2;1 | 2;2
     */

    public static void main(String[] args) {
        TestVictoryInOneMoveInHorizontals testVictoryInOneMoveInHorizontals = new TestVictoryInOneMoveInHorizontals();
        testVictoryInOneMoveInHorizontals.test1();
        testVictoryInOneMoveInHorizontals.test2();
        testVictoryInOneMoveInHorizontals.test3();
        testVictoryInOneMoveInHorizontals.test4();
        testVictoryInOneMoveInHorizontals.test5();
        testVictoryInOneMoveInHorizontals.test6();
        testVictoryInOneMoveInHorizontals.test7();
        testVictoryInOneMoveInHorizontals.test8();
        testVictoryInOneMoveInHorizontals.test9();
        testVictoryInOneMoveInHorizontals.test10();
        testVictoryInOneMoveInHorizontals.test11();
    }

    private void test1() {
        char[][] strings = {{'-', '-', '-'},{'-', '-','-'},{'-', '-', '-'}};
        Move realResult = victoryInOneMoveInHorizontals.execute(strings, 'X');
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
        Move realResult = victoryInOneMoveInHorizontals.execute(strings, 'X');
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
        char[][] strings = {{'X', '-', 'X'},{'-', '-','X'},{'-', 'X', '-'}};
        Move realResult = victoryInOneMoveInHorizontals.execute(strings, 'X');
        Move expectedResult = new Move(0, 1);
        if(checkMove(realResult, expectedResult)) {
            System.out.println("Test " + countTests + " OK");
        }
        else {
            System.out.println("Test " + countTests + " FAILS");
        }
        countTests++;
    }

    private void test4() {
        char[][] strings = {{'-', 'X', 'X'},{'-', '-','X'},{'-', 'X', '-'}};
        Move realResult = victoryInOneMoveInHorizontals.execute(strings, 'X');
        Move expectedResult = new Move(0, 0);
        if(checkMove(realResult, expectedResult)) {
            System.out.println("Test " + countTests + " OK");
        }
        else {
            System.out.println("Test " + countTests + " FAILS");
        }
        countTests++;
    }

    private void test5() {
        char[][] strings = {{'X', 'X', '-'},{'-', '-','X'},{'-', 'X', '-'}};
        Move realResult = victoryInOneMoveInHorizontals.execute(strings, 'X');
        Move expectedResult = new Move(0, 2);
        if(checkMove(realResult, expectedResult)) {
            System.out.println("Test " + countTests + " OK");
        }
        else {
            System.out.println("Test " + countTests + " FAILS");
        }
        countTests++;
    }

    private void test6() {
        char[][] strings = {{'X', '-', '-'},{'-', 'X','X'},{'-', 'X', '-'}};
        Move realResult = victoryInOneMoveInHorizontals.execute(strings, 'X');
        Move expectedResult = new Move(1, 0);
        if(checkMove(realResult, expectedResult)) {
            System.out.println("Test " + countTests + " OK");
        }
        else {
            System.out.println("Test " + countTests + " FAILS");
        }
        countTests++;
    }

    private void test7() {
        char[][] strings = {{'X', '-', '-'},{'X', '-','X'},{'-', 'X', '-'}};
        Move realResult = victoryInOneMoveInHorizontals.execute(strings, 'X');
        Move expectedResult = new Move(1, 1);
        if(checkMove(realResult, expectedResult)) {
            System.out.println("Test " + countTests + " OK");
        }
        else {
            System.out.println("Test " + countTests + " FAILS");
        }
        countTests++;
    }

    private void test8() {
        char[][] strings = {{'X', '-', '-'},{'X', 'X','-'},{'-', 'X', '-'}};
        Move realResult = victoryInOneMoveInHorizontals.execute(strings, 'X');
        Move expectedResult = new Move(1, 2);
        if(checkMove(realResult, expectedResult)) {
            System.out.println("Test " + countTests + " OK");
        }
        else {
            System.out.println("Test " + countTests + " FAILS");
        }
        countTests++;
    }

    private void test9() {
        char[][] strings = {{'X', '-', '-'},{'-', '-','-'},{'-', 'X', 'X'}};
        Move realResult = victoryInOneMoveInHorizontals.execute(strings, 'X');
        Move expectedResult = new Move(2, 0);
        if(checkMove(realResult, expectedResult)) {
            System.out.println("Test " + countTests + " OK");
        }
        else {
            System.out.println("Test " + countTests + " FAILS");
        }
        countTests++;
    }

    private void test10() {
        char[][] strings = {{'X', '-', '-'},{'-', '-','-'},{'X', '-', 'X'}};
        Move realResult = victoryInOneMoveInHorizontals.execute(strings, 'X');
        Move expectedResult = new Move(2, 1);
        if(checkMove(realResult, expectedResult)) {
            System.out.println("Test " + countTests + " OK");
        }
        else {
            System.out.println("Test " + countTests + " FAILS");
        }
        countTests++;
    }

    private void test11() {
        char[][] strings = {{'X', '-', '-'},{'-', '-','-'},{'X', 'X', '-'}};
        Move realResult = victoryInOneMoveInHorizontals.execute(strings, 'X');
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
