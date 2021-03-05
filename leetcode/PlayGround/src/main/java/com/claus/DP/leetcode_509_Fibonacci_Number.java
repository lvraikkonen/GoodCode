package com.claus.DP;

public class leetcode_509_Fibonacci_Number {
    public static int fib_naive(int n) {
        if (n==1||n==2) {
            return 1;
        }
        return fib_naive(n-1) + fib_naive(n-2);
    }

    public static int fib_memo(int n) {
        if (n<2) {
            return n;
        }
        int[] memo = new int[n+1];
        memo[1] = 1;
        for (int i=2; i<=n; i++) {
            memo[i] = memo[i-1] + memo[i-2];
        }
        return memo[n];
    }

    public static int fib_DP(int n) {
        if (n<2) {
            return n;
        }
        int[] dp = new int[n+1];
        // base case
        dp[0] = 0;
        dp[1] = 1;
        for (int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static int fib(int n) {
        if (n<2) {
            return n;
        }
        int prev = 0;
        int curr = 1;
        int sum =0;
        for (int i=2; i<=n; i++) {
            sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        int res = fib(5);
    }
}
