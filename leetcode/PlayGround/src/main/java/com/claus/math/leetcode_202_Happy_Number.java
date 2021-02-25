package com.claus.math;

public class leetcode_202_Happy_Number {

    /*
    输入：19
    输出：true
    解释：
    12 + 92 = 82
    82 + 22 = 68
    62 + 82 = 100
    12 + 02 + 02 = 1
     */
    public static boolean isHappy(int n) {
        // 快慢指针的思路判断是否有环
        int slow = n, fast = n;
        do {
            slow = bitSquareSum(slow);
            fast = bitSquareSum(fast);
            fast = bitSquareSum(fast);
        } while (slow != fast);
        return slow == 1;
    }

    private static int bitSquareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int bit = n % 10;
            sum += bit * bit;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 19;
        boolean res = isHappy(19);
    }
}
