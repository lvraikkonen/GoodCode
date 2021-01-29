package com.claus.stack;

import com.claus.linkedList.ListNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class leetcode_1019_Next_Greater_Node_In_Linked_List {

    public static int[] nextLargerNodes_1(ListNode head) {

        // 单调栈的思路，链表从前到后遍历

        List<Integer> list = new ArrayList<>();
        // 遍历链表，元素存储到集合中
        while (head!=null) {
            list.add(head.val);
            head = head.next;
        }
        //栈中存储的是元素的下标，并且从栈底到栈顶元素在集合中对应的
        //值是从大到小的
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[list.size()];
        for (int i=0; i < list.size(); i++) {
            while (!stack.empty() && list.get(stack.peek())<list.get(i)) {
                //如果栈顶元素对应的值小于当前值，说明栈顶元素遇到了比他小的
                int index = stack.pop();
                res[index] = list.get(i);
            }
            stack.push(i);
        }
        return res;
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

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(5);
        head.next = node1;
        node1.next = node2;

        nextLargerNodes_1(head);
    }


}


