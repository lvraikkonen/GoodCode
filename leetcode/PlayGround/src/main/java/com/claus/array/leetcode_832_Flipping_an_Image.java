package com.claus.array;

public class leetcode_832_Flipping_an_Image {
    public static int[][] flipAndInvertImage(int[][] A) {
        int length = A.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j * 2 < length; j++) {
                //对称位置相同的，都会变
                if (A[i][j] == A[i][length - j - 1]) {
                    A[i][j] = A[i][length - j - 1] ^= 1;
                }
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,1,0},{1,0,1},{0,0,0}};
        int[][] res = flipAndInvertImage(mat);
    }
}
