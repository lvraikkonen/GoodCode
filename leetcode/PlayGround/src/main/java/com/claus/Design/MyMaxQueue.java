package com.claus.Design;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MyMaxQueue {

    // 剑指 Offer 59 - II. 队列的最大值

    /*
    使用一个双端队列实现一个单调队列，保存队列中所有单调递减元素
     */
    private Queue<Integer> queue; // 存储数据元素的队列
    private Deque<Integer> deque; // 单调递减队列

    public MyMaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        if (!deque.isEmpty()) {
            return deque.peekFirst();
        }
        return -1;
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!deque.isEmpty() && deque.peekLast() < value) {
            // 如果单调队列不为空，并且队尾元素比新元素小，则将队尾元素出队
            deque.pollLast();
        }
        deque.offerLast(value);
    }

    public int pop_front() {
        if (deque.isEmpty()) {
            return -1;
        }
        if (queue.peek().equals(deque.peekFirst())) {
            // 如果队列的队头和单调队列的队头相等，单调队列队头出队
            deque.pollFirst();
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        MyMaxQueue maxQueue = new MyMaxQueue();
        maxQueue.push_back(5);
        maxQueue.push_back(1);
        maxQueue.push_back(3);
        maxQueue.push_back(2);
        int res1 = maxQueue.pop_front();
        int maxV = maxQueue.max_value();
    }
}
