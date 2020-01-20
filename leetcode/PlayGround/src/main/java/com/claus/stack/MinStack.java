package com.claus.stack;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> data; // 数据栈
    private Stack<Integer> helper; // 辅助栈

    /**
     * initialize your data structure here
     */
    public MinStack() {
        data = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int x) {
        data.add(x);
        if (helper.isEmpty() || x <= helper.peek()) {
            helper.add(x);
        }
    }

    public void pop() {
        if (!data.isEmpty()) {
            int popData = data.pop();
            if (popData == helper.peek()) {
                helper.pop();
            }
        }
    }

    public int top() {
        if (!data.isEmpty()) {
            return data.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }

    public int getMin() {
        if (!helper.isEmpty()) {
            return helper.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }
}
