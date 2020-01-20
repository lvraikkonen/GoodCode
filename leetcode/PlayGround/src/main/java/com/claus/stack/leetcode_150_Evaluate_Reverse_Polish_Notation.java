package com.claus.stack;

import java.util.Stack;

public class leetcode_150_Evaluate_Reverse_Polish_Notation {

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s: tokens) {
            if (s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (s.equals("-")) {
                stack.push(-stack.pop() + stack.pop());
            } else if (s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (s.equals("/")){
                int num = stack.pop();
                stack.push(stack.pop() / num);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) throws Exception {
        String[] s = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(s));
    }
}
