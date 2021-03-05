package com.claus.math;

import java.util.Arrays;

public class leetcode_976_Largest_Perimeter_Triangle {
    public static int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; --i) {
            if (A[i - 2] + A[i - 1] > A[i]) { // 合法的三角形，两边之和大于第三边
                return A[i - 2] + A[i - 1] + A[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {3,6,2,3};
        int res = largestPerimeter(nums);
    }
}
