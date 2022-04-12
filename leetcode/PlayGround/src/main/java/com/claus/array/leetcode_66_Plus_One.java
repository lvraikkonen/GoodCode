package com.claus.array;

public class leetcode_66_Plus_One {
    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i=len-1; i>=0; i--) {
            digits[i] += 1;
            digits[i] %= 10;//进一位
            if (digits[i]!=0) {
                return digits;
            }
        }
        // 到最高位进一位
        digits = new int[len+1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int[] num = {9,9,9};
        int[] res = plusOne(num);
    }
}
