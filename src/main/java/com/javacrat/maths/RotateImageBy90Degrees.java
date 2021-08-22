package com.javacrat.maths;

public class RotateImageBy90Degrees {

    public static void main(String[] args) {
        RotateImageBy90Degrees program = new RotateImageBy90Degrees();
        int[][] matrix = new int[4][4];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[0][3] = 4;
        matrix[1][0] = 5;
        matrix[1][1] = 6;
        matrix[1][2] = 7;
        matrix[1][3] = 8;
        matrix[2][0] = 9;
        matrix[2][1] = 10;
        matrix[2][2] = 11;
        matrix[2][3] = 12;
        matrix[3][0] = 13;
        matrix[3][1] = 14;
        matrix[3][2] = 15;
        matrix[3][3] = 16;
        program.rotate(matrix);
    }

    public void rotate(int[][] matrix) {
        int length = matrix[0].length-1;
        for(int i=0; i<length; i++) {
            for(int j=0+i; j<length-i; j++) {
                int temp1 = matrix[i][j];
                int temp2 = matrix[j][length-i];
                int temp3 = matrix[length-i][length-j];
                int temp4 = matrix[length-j][i];
                matrix[j][length-i] = temp1;
                matrix[length-i][length-j] = temp2;
                matrix[length-j][i] = temp3;
                matrix[i][j] = temp4;
            }
        }
    }

}
