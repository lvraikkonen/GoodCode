package com.claus.linkedList.doubleLinkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private int size;
    private int capacity;
    private Map<Integer, DoubleListNode> map = new HashMap<>();
    private DoubleListNode head;
    private DoubleListNode tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DoubleListNode();
        tail = new DoubleListNode();
        head.next = tail;
        tail.prev = head;
    }

    // 头部插入结点
    private void addToHead(DoubleListNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    // 删除结点
    private void removeNode(DoubleListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 将结点移动到链表头
    private void moveToHead(DoubleListNode node) {
        removeNode(node);
        addToHead(node);
    }

    // 删除尾结点
    private DoubleListNode removeTail() {
        DoubleListNode res = tail.prev;
        removeNode(res);
        return res;
    }

    // 访问结点
    public int get(int key) {
        DoubleListNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        // 找到结点，并将结点移动到链表头
        moveToHead(node);
        return node.value;
    }

    // 插入结点
    public void put(int key, int value) {
        DoubleListNode node = map.get(key);
        if (node == null) { // new node
            DoubleListNode newNode = new DoubleListNode(key, value);
            map.put(key, newNode);
            // 插入链表头
            addToHead(newNode);
            size++;
            if (size > capacity) {
                // 超出容量，删除尾部最久没使用结点
                DoubleListNode tail = removeTail();
                map.remove(tail.key);
                size--;
            }
        } else {
            // 更新结点，并移动到链表头
            node.value = value;
            moveToHead(node);
        }
    }

    private class DoubleListNode {
        int key;
        int value;
        DoubleListNode prev;
        DoubleListNode next;

        public DoubleListNode() {}

        public DoubleListNode(int _key, int _value) {
            key = _key;
            value = _value;
            prev = null;
            next = null;
        }
    }

}
