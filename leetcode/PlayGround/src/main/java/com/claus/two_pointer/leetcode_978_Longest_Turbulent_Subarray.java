package com.claus.two_pointer;

public class leetcode_978_Longest_Turbulent_Subarray {
    //

    public static int maxTurblenceSize(int[] arr) {
        // 波浪形
        // 湍流子数组： 数<数>数<数>数 或 数>数<数>数<数,
        // 即两数之间比较的符号为间隔为大于或小于符号
        int res = 0;
        int left=0, right=0;

        while (right < arr.length-1) {
            if (left == right) {
                if (arr[left] == arr[left+1]) {
                    left += 1;
                }
                right += 1;
            } else {
                if (arr[right-1] < arr[right] && arr[right] > arr[right+1]) {
                    right += 1;
                } else if (arr[right-1] > arr[right] && arr[right] < arr[right+1]) {
                    right += 1;
                } else {
                    left = right;
                }
            }
            res = Math.max(res, right-left+1);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {9,4,2,10,7,8,8,1,9};
        int res = maxTurblenceSize(arr);
    }
}
