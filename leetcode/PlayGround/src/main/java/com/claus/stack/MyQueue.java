/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: leetcode_232_Implement_Queue_using_Stacks
 * Author:   lvshuo
 * Date:     2020/2/3 5:08 下午
 * Description: 用队列实现栈
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.claus.stack;

import java.util.Stack;

/**
 * 〈用队列实现栈〉
 * leetcode 232 Implement queue using stack
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 *
 * 队列中的元素都从后端（rear）入队（push），从前端（front）出队（pop）
 * 方法1：两个栈
 * 方法2：
 */
public class MyQueue {

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();
    private int front;

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        // 最新压入的元素必须得放在栈底
        if (s1.empty()) {
            front = x;
        }
        while (!s1.isEmpty()) {
            // 压入栈2
            s2.push(s1.pop());
        }
        s2.push(x);
        while (!s2.isEmpty()) {
            // 放回栈1
            s1.push(s2.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int tmp = s1.pop();
        if (!s1.empty()) {
            front = s1.peek();
        }
        return tmp;
    }

    /** Get the front element. */
    public int peek() {
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
    }
}