package com.claus.array;

public class leetcode_867_Transpose_Matrix {

    public static int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] res = new int[col][row];
        for (int i=0; i < row; i++) {
            for (int j=0; j < col; j++) {
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6}};
        int[][] res = transpose(mat);
    }
}
