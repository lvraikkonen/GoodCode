package com.claus.stack;

import java.util.Stack;

public class leetcode_32_Longest_Valid_Parentheses {

    /*
    扫描到左括号，就将当前位置入栈。

    扫描到右括号，就将栈顶出栈（代表栈顶的左括号匹配到了右括号），然后分两种情况。
    - 栈不空，那么就用当前的位置减去栈顶的存的位置，然后就得到当前合法序列的长度，然后更新一下最长长度。
    - 栈是空的，说明之前没有与之匹配的左括号，那么就将当前的位置入栈
     */
    public static int longestValidParentheses(String s) {
        int maxn = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i=0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    // 栈空，将当前位置压栈作为标志
                    stack.push(i);
                } else {
                    // 挑战最大值 当前位置-栈顶的索引
                    maxn = Math.max(maxn, i - stack.peek());
                }
            }
        }
        return maxn;
    }

    public static void main(String[] args) {
        String s = ")()())";
        int result = longestValidParentheses(s);
    }
}
