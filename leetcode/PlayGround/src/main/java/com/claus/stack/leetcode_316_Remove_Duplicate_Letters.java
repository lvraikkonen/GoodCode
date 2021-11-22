package com.claus.stack;

import java.util.Stack;

public class leetcode_316_Remove_Duplicate_Letters {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();

        // 计数器统计每个字符出现次数
        int[] count = new int[26];
        for (int i=0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        boolean[] inStack = new boolean[26];
        for (char c: s.toCharArray()) {
            // 遍历一个字母，计数-1
            count[c - 'a']--;

            if (inStack[c - 'a']){
                continue;
            } // 若不在栈中，则插入栈顶并标记为存在
            while (!stack.isEmpty() && c < stack.peek()) {
                // 若之后不存在栈顶元素会发生重复，则停止pop
                if (count[stack.peek() - 'a'] == 0) {
                    break;
                }
                inStack[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            inStack[c - 'a'] = true;
        }

        //out
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "cbacdcbc";
        leetcode_316_Remove_Duplicate_Letters solution = new leetcode_316_Remove_Duplicate_Letters();
        String res = solution.removeDuplicateLetters(s);
    }
}
