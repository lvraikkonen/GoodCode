package com.claus.binarySearch;

public class leetcode_240_Search_a_2D_Matrix_II {
    public static boolean searchMatrix(int[][] matrix, int target) {
        // 从右上角开始搜索
        // > target, 左移
        // < target, 下移
        int row = 0, column = matrix[0].length-1;
        while (row<=matrix.length-1 && column>=0) {
            if (target == matrix[row][column]) {
                return true;
            } else if (matrix[row][column] > target) {
                column -= 1;
            } else {
                row += 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,4,7,11,15},{2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}};
        boolean res = searchMatrix(mat, 14);
    }
}
