package com.claus.math;

public class leetcode_400_Nth_Digit {

    public int findNthDigit(int n) {
        int len = 1;
        int base = 1;
        while (n > (long)len * 9 * base) {
            n -= len * 9 * base;
            len++;
            base *= 10;
        }

        long start = (long) Math.pow(10, len-1); // 当前范围最小值
        long num = start + (n-1)/len; // 找出这个数字
        int idx = (n - 1)%len; // 找出在这个数字中的索引
        char[] arr = String.valueOf(num).toCharArray();
        return arr[idx] - '0';
    }

    public static void main(String[] args) {
        int n = 197;
        leetcode_400_Nth_Digit s = new leetcode_400_Nth_Digit();
        int res = s.findNthDigit(n);
    }
}
