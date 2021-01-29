package com.claus.stack;

import java.util.Stack;

public class leetcode_739_daily_temperature {

    public static int[] dailyTemperature(int[] T) {
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<>(); // 放元素索引
        // 单调栈
        // 倒着往栈里放
        for (int i=T.length-1; i>=0; i--) {
            while (!stack.empty() && T[stack.peek()] <= T[i]) {
                // 低的去掉
                stack.pop();
            }
            res[i] = stack.empty() ? 0 : (stack.peek()-i); // 索引间距
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result;
        result = dailyTemperature(temperatures);
    }
}
