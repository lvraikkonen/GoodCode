package com.claus.DP;

public class NumMatrix_304 {

    /*
    题解：
    https://leetcode-cn.com/problems/range-sum-query-2d-immutable/solution/ru-he-qiu-er-wei-de-qian-zhui-he-yi-ji-y-6c21/
     */

    private int[][] preSum;

    public NumMatrix_304(int[][] matrix) {
        int rows = matrix.length;
        if (rows > 0) {
            int columns = matrix[0].length;
            preSum = new int[rows][columns];
            preSum[0][0] = matrix[0][0];
            for (int i = 1; i < rows; i++) {
                preSum[i][0] = preSum[i - 1][0] + matrix[i][0];
            }
            for (int i = 1; i < columns; i++) {
                preSum[0][i] = preSum[0][i - 1] + matrix[0][i];
            }
            for (int i = 1; i < rows; i++) {
                for (int j = 1; j < columns; j++) {
                    preSum[i][j] = matrix[i][j] + preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 == 0) {
            return preSum[row2][col2];
        } else if (row1 == 0) {
            return preSum[row2][col2] - preSum[row2][col1-1];
        } else if (col1 == 0) {
            return preSum[row2][col2] - preSum[row1-1][col2];
        }
        return preSum[row2][col2] - preSum[row1-1][col2] - preSum[row2][col1-1] + preSum[row1-1][col1-1];
    }

    public static void main(String[] args) {
        int[][] mat = {{3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}};
        NumMatrix_304 demo = new NumMatrix_304(mat);
        int res1 = demo.sumRegion(2, 1, 4, 3);
    }
}
