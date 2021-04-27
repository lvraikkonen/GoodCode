package com.claus.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class leetcode_331_Verify_Preorder_Serialization_of_a_Binary_Tree {

    public static boolean isValidSerialization(String preorder) {
        String[] strs = preorder.split(",");
        Deque<String> stack = new ArrayDeque<>();
        int n = strs.length;
        for (int i=0; i<n; i++) {
            if (strs[i].equals("#")) {
                // 判断当前栈顶是不是"#"
                // 连续两个# 说明前面那个元素为叶子结点
                while (!stack.isEmpty() && stack.peek().equals("#")) {
                    // 消除2个#，消除一个节点数字并转换成#
                    stack.pop();
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
                stack.push("#");
            } else {
                stack.push(strs[i]);
            }
        }
        // 判断栈中是不是仅剩下一个"#"
        return (stack.size()==1 && stack.peek().equals("#")) ? true : false;
    }

    public static void main(String[] args) {
        String s = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        boolean res = isValidSerialization(s);
    }
}
