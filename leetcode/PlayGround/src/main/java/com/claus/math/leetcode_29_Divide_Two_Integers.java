package com.claus.math;

public class leetcode_29_Divide_Two_Integers {

    public int divide(int dividend, int divisor) {
        int sign = (dividend ^ divisor) >= 0 ? 1 : -1;//判断符号
        long dividendTemp = Math.abs((long) dividend);//求绝对值
        long divisorTemp = Math.abs((long) divisor);
        long res = 0;
        while (dividendTemp >= divisorTemp) {
            long tmp = divisorTemp;
            long times = 1;//除数divisor的倍数
            while (dividendTemp >= (tmp << 1)) {
                tmp <<= 1;
                times <<= 1;
            }
            //被除数减去除数的times倍
            dividendTemp -= tmp;
            //累加times
            res += times;
        }
        //添加符号
        res = sign > 0 ? res : -res;
        //需要判断是否有溢出
        return res > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) res;
    }

    public static void main(String[] args) {
        leetcode_29_Divide_Two_Integers s = new leetcode_29_Divide_Two_Integers();
        int res = s.divide(10, 3);
    }
}
