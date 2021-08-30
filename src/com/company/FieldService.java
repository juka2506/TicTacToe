package com.company;

public class FieldService {

    public char[][] createField() {
        char[][] field = new char[3][3];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) { //а через arrays.fill нельзя было?
                field[i][j] = '-';
            }
        }
        return field;
    }

    public void printFieldToConsole(char[][] field) {
        System.out.println("\n");
        System.out.println(field[0][0] + " | " + field[0][1] + " | " + field[0][2]);
        System.out.println("---------");
        System.out.println(field[1][0] + " | " + field[1][1] + " | " + field[1][2]);
        System.out.println("---------");
        System.out.println(field[2][0] + " | " + field[2][1] + " | " + field[2][2]);
        System.out.println("\n");
    }
}
