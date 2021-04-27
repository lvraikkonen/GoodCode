package com.claus.Design;

import java.util.*;

// leetcode 341. Flatten Nested List Iterator
public class NestedIterator implements Iterator<Integer> {

    private Deque<NestedInteger> stack = new ArrayDeque<>();

    public NestedIterator(List<NestedInteger> list) {
        // 倒序入栈
        for (int i=list.size()-1; i>=0; i--) {
            NestedInteger item = list.get(i);
            stack.addLast(item);
        }
    }

    @Override
    public Integer next() {
        return hasNext() ? stack.pollLast().getInteger() : -1;
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger item = stack.peekLast();
            if (item.isInteger()) {
                return true;
            }
            stack.pollLast();
            for (int i=item.getList().size()-1; i>=0; i--) {
                stack.addLast(item.getList().get(i));
            }
        }
        return false;
    }
}

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

    //@return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();

}
