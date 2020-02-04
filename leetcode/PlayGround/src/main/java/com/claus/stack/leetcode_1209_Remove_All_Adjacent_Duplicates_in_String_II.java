/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: leetcode_1209_Remove_All_Adjacent_Duplicates_in_String_II
 * Author:   lvshuo
 * Date:     2020/2/4 2:31 下午
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.claus.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * 将元素依次入栈并统计元素数量。每次入栈判断是否和栈顶元素相同：
 * 如果与栈顶元素相同，那么将栈顶元素的数量加 1；
 * 如果栈顶元素数量达到 k，则将栈顶元素出栈；
 * 如果待入栈元素与栈顶元素不同，那么直接入栈并将该元素个数置为 1
 */
public class leetcode_1209_Remove_All_Adjacent_Duplicates_in_String_II {
    public static String removeDuplicates(String s, int k) {
        Stack<Character> stack = new Stack<>();
        int[] num = new int[s.length()];
        for (int i=0; i<s.length(); i++) {
            Character chr = s.charAt(i);
            if (stack.isEmpty() || chr != stack.peek()) {
                stack.push(chr);
                num[stack.size()-1] = 1;
            } else {
                num[stack.size()-1] += 1;
            }
            if (num[stack.size()-1] == k) {
                stack.pop();
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()){
            Character c = stack.pop();
            for (int i=0; i<num[stack.size()]; i++) {
                ans.append(c);
            }
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) throws Exception {
        String s = "iiiixxxxxiiccccczzffffflllllllllfffffllyyyyyuuuuuz";
        int k = 5;
        System.out.println(removeDuplicates(s, k));
    }
}