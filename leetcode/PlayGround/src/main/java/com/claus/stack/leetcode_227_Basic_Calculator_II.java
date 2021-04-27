package com.claus.stack;

import java.util.Stack;

public class leetcode_227_Basic_Calculator_II {

    public static int calculate(String s) {
        char[] source = s.toCharArray();
        // 保存上一个符号，初始化为+
        char sign = '+';
        Stack<Integer> numStack = new Stack<>();

        int num = 0;
        int result = 0;
        //遇到数字
        for (int i = 0; i < s.length(); i++) {
            char cur = source[i];
            if (cur >= '0' && cur <= '9') {
                num = num * 10 - '0' + cur;
            }
            //遇到操作符 （加减乘除空格的ASCII码都小于'0'）
            if ((cur < '0' && cur != ' ') || i == source.length - 1) {
                switch (sign) {
                    case '+':
                        numStack.push(num);
                        break;
                    case '-':
                        numStack.push(-num);
                        break;
                    case '*':
                        numStack.push(numStack.pop() * num);
                        break;
                    case '/':
                        numStack.push(numStack.pop() / num);
                        break;
                }
                sign = cur;
                num = 0;
            }
        }

        while (!numStack.isEmpty()) {
            result += numStack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        String s = " 3+5 / 2 ";
        int res = calculate(s);
    }
}
