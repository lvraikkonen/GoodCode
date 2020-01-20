package com.claus.stack;

import com.claus.linkedList.ListNode;
import java.util.ArrayList;
import java.util.Stack;


public class leetcode_1019_Next_Greater_Node_In_Linked_List {

    public static int[] nextLargerNodes_1(ListNode head) {

        if (head==null) {
            return null;
        }
        ArrayList<Integer> values = new ArrayList<>();
        while (head!=null) {
            values.add(head.val);
            head = head.next;
        }

        Stack<Integer> stack = new Stack<>();
        int len = values.size();
        int ans[] = new int[len];
        for (int i=0; i < len; i++) {
            int value = values.get(i);
            while (stack.size()>0 && values.get(stack.peek()) < value) {
                int popIndex = stack.pop();
                ans[popIndex] = value;
            }
            stack.push(i);
        }

        return ans;
    }

    public static int[] nextLargerNodes_2(ListNode head) {
        int[] arr = new int[10000];
        int[] valueArr = new int[10000];
        Stack<Integer> stack = new Stack<>();
        int length = 0;
        int value;
        while (head != null) {
            value = head.val;
            valueArr[length] = value;
            while (!stack.isEmpty() && value > valueArr[stack.peek()]) {
                int popIndex = stack.pop();
                arr[popIndex] = value;
            }
            stack.push(length);
            length++;
            head = head.next;
        }
        int[] ans = new int[length];
        for (int i=0; i < length; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }
}


