package com.claus.Design;

import java.util.Stack;

public class MyMinStack {
    private Stack<Integer> stack;
    private Stack<Integer> min_stack;

    public MyMinStack() {
        stack = new Stack<>();
        min_stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min_stack.isEmpty() || x <= min_stack.peek()) {
            min_stack.push(x);
        }
    }

    public void pop() {
        if (stack.pop().equals(min_stack.peek())) {
            min_stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min_stack.peek();
    }

    public static void main(String[] args) {
        int[] nums = {1,5,2,6,4};
        MyMinStack s = new MyMinStack();
        for (int n: nums) {
            s.push(n);
        }
        s.push(3);
        s.pop();
        int param_3 = s.top();
        int param_4 = s.getMin();
    }
}
