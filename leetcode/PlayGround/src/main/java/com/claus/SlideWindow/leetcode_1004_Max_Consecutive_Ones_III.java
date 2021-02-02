package com.claus.SlideWindow;

public class leetcode_1004_Max_Consecutive_Ones_III {
    public static int longestOnes(int[] A, int k) {
        int len = A.length;
        int left = 0, right = 0;
        int count1 = 0; // 窗口内1的数量
        int res = 0;
        while (right < len) {
            if (A[right] == 1) {
                count1 += 1;
            }
            // 窗口同时保证窗口内0的个数小于等于k
            if (right-left+1 -count1> k) {
                // 窗口不符合条件
                if (A[left] == 1) {
                    count1 -= 1;
                }
                left += 1;
            }
            right += 1;
            res = Math.max(res, right-left);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int result = longestOnes(nums, 2);
    }
}
