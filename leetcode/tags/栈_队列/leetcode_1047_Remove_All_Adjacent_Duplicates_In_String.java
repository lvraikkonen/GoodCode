/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: leetcode_1047_Remove_All_Adjacent_Duplicates_In_String
 * Author:   lvshuo
 * Date:     2020/2/4 1:46 下午
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.claus.stack;

import java.util.Stack;

public class leetcode_1047_Remove_All_Adjacent_Duplicates_In_String {

    public static String removeDuplicates(String S) {
        // 用栈，每次添加时检查栈顶元素和添加元素是否相同
        char[] s = S.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i=0; i < s.length; i++) {
            if (stack.isEmpty() || s[i] != stack.peek()) {
                stack.push(s[i]);
            }
            else {
                stack.pop();
            }
        }
        StringBuilder ans = new StringBuilder();
        for (Character c: stack) {
            ans.append(c);
        }
        return ans.toString();
    }

    public static void main(String[] args) throws Exception {
        String S = "abbaca";
        System.out.println(removeDuplicates(S));

    }

}