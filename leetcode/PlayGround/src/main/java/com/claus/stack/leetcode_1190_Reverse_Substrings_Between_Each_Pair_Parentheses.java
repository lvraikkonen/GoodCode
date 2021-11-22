package com.claus.stack;

import java.util.Deque;
import java.util.LinkedList;

public class leetcode_1190_Reverse_Substrings_Between_Each_Pair_Parentheses {
    /*
    对于当前遍历的字符：

    如果是左括号，将 str 插入到栈中，并将 str 置为空，进入下一层；
    如果是右括号，则说明遍历完了当前层，需要将 str 反转，返回给上一层。
        具体地，将栈顶字符串弹出，然后将反转后的 str 拼接到栈顶字符串末尾，将结果赋值给 str。
    如果是小写英文字母，将其加到 str 末尾。
     */
    public String reverseParentheses(String s) {
        Deque<String> stack = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(sb.toString());
                sb.setLength(0);
            } else if (ch == ')') {
                sb.reverse();
                sb.insert(0, stack.pop());
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public String reverseParentheses_1(String s) {
        int len = s.length();
        int[] pair = new int[len];
        Deque<Integer> stack = new LinkedList<>();
        for (int i=0; i < len; i++) {
            // 找到对应左括号的右括号位置
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        int index = 0, step = 1;
        while (index < len) {
            if (s.charAt(index) == '(' || s.charAt(index) == ')') {
                index = pair[index];
                step = -step; // 反向
            } else {
                sb.append(s.charAt(index));
            }
            index += step;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "(u(love)i)";
        leetcode_1190_Reverse_Substrings_Between_Each_Pair_Parentheses solution = new leetcode_1190_Reverse_Substrings_Between_Each_Pair_Parentheses();
        String res = solution.reverseParentheses_1(s);
    }
}
