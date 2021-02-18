package com.claus.math;

public class leetcode_50_pow_x_n {
    public static double myPow(double num, int n) {
        long longn = n;
        return longn > 0 ? pow_fun(num,longn) : 1.0 / pow_fun(num, -longn);
    }

    private static double pow_fun(double num, long longn) {
        double result = 1.0;
        double basenum = num;
        while (longn > 0) {
            if (longn % 2 == 1) {
                result *= basenum;
            }
            basenum *= basenum;
            longn >>= 1; // n//2
        }
        return result;
    }

    public static void main(String[] args) {
        double res = myPow(2.1, 3);
    }
}
