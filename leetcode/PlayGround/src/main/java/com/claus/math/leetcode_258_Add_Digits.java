package com.claus.math;

public class leetcode_258_Add_Digits {
    public static int addDigits(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }

    public static int addDigits_1(int num) {
        if (num < 10) return num;
        return num%9 == 0 ? 9 : num%9;
    }

    public static void main(String[] args) {
        int num = 38;
        int res = addDigits(num);
    }
}
