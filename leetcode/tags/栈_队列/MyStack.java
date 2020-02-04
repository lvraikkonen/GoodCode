/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: leetcode_225_Implement_Stack_using_Queues
 * Author:   lvshuo
 * Date:     2020/2/3 5:06 下午
 * Description: 用队列实现栈
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.claus.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 〈用队列实现栈〉
 * leetcode 225 Implement stack using queue
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 *
 * 方法1：两个队列，压入 O(1)，弹出 O(n)
 * 方法2：一个队列，压入 O(n), 弹出 O(1)
 */
public class MyStack {

//    // 方法1
//    private Queue<Integer> q1 = new LinkedList<>();
//    private Queue<Integer> q2 = new LinkedList<>();
//    private int top;
//
//    /** Initialize your data structure here. */
//    public MyStack() {
//
//    }
//
//    /** Push element x onto stack. */
//    public void push(int x) {
//        q1.add(x);
//        top = x;
//    }
//
//    /** Removes the element on top of the stack and returns that element. */
//    public int pop() {
//        while (q1.size() > 1) {
//            top = q1.remove();
//            q2.add(top);
//        }
//        int tmp = q1.remove(); // pop the top element
//        // swap q1 & q2
//        Queue<Integer> temp = q1;
//        q1 = q2;
//        q2 = temp;
//        return tmp;
//    }
//
//    /** Get the top element. */
//    public int top() {
//        return top;
//    }
//
//    /** Returns whether the stack is empty. */
//    public boolean empty() {
//        return q1.isEmpty();
//    }

    //方法2 当入队一个新元素的时候，把队列的顺序反转过来
    private Queue<Integer> queue = new LinkedList<>();

    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        int count = queue.size();
        while (count > 1) {
            queue.add(queue.remove());
            count--;
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.remove();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}