package com.company.tests;

import com.company.ai.AI;

public class TestVictoryInOneMoveInVerticals {
    int countTests = 1;
    AI AI = new AI();
    
    /*
        0;0 | 0;1 | 0;2
        ---------------
        1;0 | 1;1 | 1;2
        ---------------
        2;0 | 2;1 | 2;2
     */
/*
    public static void main(String[] args) {
        TestVictoryInOneMoveInVerticals testVictoryInOneMoveInVerticals = new TestVictoryInOneMoveInVerticals();
        testVictoryInOneMoveInVerticals.test1();
        testVictoryInOneMoveInVerticals.test2();
        testVictoryInOneMoveInVerticals.test3();
        testVictoryInOneMoveInVerticals.test4();
        testVictoryInOneMoveInVerticals.test5();
        testVictoryInOneMoveInVerticals.test6();
        testVictoryInOneMoveInVerticals.test7();
        testVictoryInOneMoveInVerticals.test8();
        testVictoryInOneMoveInVerticals.test9();
        testVictoryInOneMoveInVerticals.test10();
        testVictoryInOneMoveInVerticals.test11();
    }

    private void test1() {
        char[][] strings = {{'-', '-', '-'},{'-', '-','-'},{'-', '-', '-'}};
        Move realResult = AI.victoryInOneMoveInVerticals(strings, 'X');
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
        Move realResult = AI.victoryInOneMoveInVerticals(strings, 'X');
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
        char[][] strings = {{'-', '-', '-'},{'X', '-','-'},{'X', '-', '-'}};
        Move realResult = AI.victoryInOneMoveInVerticals(strings, 'X');
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
        char[][] strings = {{'X', '-', '-'},{'-', '-','X'},{'X', 'X', '-'}};
        Move realResult = AI.victoryInOneMoveInVerticals(strings, 'X');
        Move expectedResult = new Move(1, 0);
        if(checkMove(realResult, expectedResult)) {
            System.out.println("Test " + countTests + " OK");
        }
        else {
            System.out.println("Test " + countTests + " FAILS");
        }
        countTests++;
    }

    private void test5() {
        char[][] strings = {{'X', '-', '-'},{'X', '-','X'},{'-', 'X', '-'}};
        Move realResult = AI.victoryInOneMoveInVerticals(strings, 'X');
        Move expectedResult = new Move(2, 0);
        if(checkMove(realResult, expectedResult)) {
            System.out.println("Test " + countTests + " OK");
        }
        else {
            System.out.println("Test " + countTests + " FAILS");
        }
        countTests++;
    }

    private void test6() {
        char[][] strings = {{'-', '-', '-'},{'-', 'X','X'},{'-', 'X', '-'}};
        Move realResult = AI.victoryInOneMoveInVerticals(strings, 'X');
        Move expectedResult = new Move(0, 1);
        if(checkMove(realResult, expectedResult)) {
            System.out.println("Test " + countTests + " OK");
        }
        else {
            System.out.println("Test " + countTests + " FAILS");
        }
        countTests++;
    }

    private void test7() {
        char[][] strings = {{'-', 'X', '-'},{'X', '-','X'},{'-', 'X', '-'}};
        Move realResult = AI.victoryInOneMoveInVerticals(strings, 'X');
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
        char[][] strings = {{'X', 'X', '-'},{'-', 'X','-'},{'-', '-', '-'}};
        Move realResult = AI.victoryInOneMoveInVerticals(strings, 'X');
        Move expectedResult = new Move(2, 1);
        if(checkMove(realResult, expectedResult)) {
            System.out.println("Test " + countTests + " OK");
        }
        else {
            System.out.println("Test " + countTests + " FAILS");
        }
        countTests++;
    }

    private void test9() {
        char[][] strings = {{'X', '-', '-'},{'-', '-','X'},{'-', 'X', 'X'}};
        Move realResult = AI.victoryInOneMoveInVerticals(strings, 'X');
        Move expectedResult = new Move(0, 2);
        if(checkMove(realResult, expectedResult)) {
            System.out.println("Test " + countTests + " OK");
        }
        else {
            System.out.println("Test " + countTests + " FAILS");
        }
        countTests++;
    }

    private void test10() {
        char[][] strings = {{'X', '-', 'X'},{'-', '-','-'},{'-', '-', 'X'}};
        Move realResult = AI.victoryInOneMoveInVerticals(strings, 'X');
        Move expectedResult = new Move(1, 2);
        if(checkMove(realResult, expectedResult)) {
            System.out.println("Test " + countTests + " OK");
        }
        else {
            System.out.println("Test " + countTests + " FAILS");
        }
        countTests++;
    }

    private void test11() {
        char[][] strings = {{'-', '-', 'X'},{'-', '-','X'},{'-', 'X', '-'}};
        Move realResult = AI.victoryInOneMoveInVerticals(strings, 'X');
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
    }*/
}
