package com.claus.binarySearch;

public class leetcode_74_Search_a_2D_Matrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        // 将二维数组转换为有序的一维数组
        if (matrix.length == 0) {
            return false;
        }
        //行数
        int row = matrix.length;
        //列数
        int col = matrix[0].length;
        int left = 0;
        //行数乘列数 - 1，右指针
        int right = row * col - 1;
        while (left <= right) {
            int mid = left + ((right-left)>>1);
            // 将一维坐标转换为二维坐标
            int rownum = mid / col;
            int colnum = mid % col;
            if (matrix[rownum][colnum] == target) {
                return true;
            } else if (matrix[rownum][colnum] > target) {
                right = mid - 1;
            } else if (matrix[rownum][colnum] < target) {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,2,3}, {4,5,6}, {7,8,9}};
        boolean res = searchMatrix(mat, 6);
    }
}
