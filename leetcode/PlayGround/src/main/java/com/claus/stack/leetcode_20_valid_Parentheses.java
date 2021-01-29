package com.claus.stack;

import java.util.Stack;

public class leetcode_20_valid_Parentheses {

    public static boolean isValid(String s) {
        if (s==null || s.length()==0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            }
            else if (c == '[') {
                stack.push(']');
            }
            else if (c == '{') {
                stack.push('}');
            }
            else if (stack.empty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        String s = "([])";
        boolean flag = isValid(s);
    }
}
