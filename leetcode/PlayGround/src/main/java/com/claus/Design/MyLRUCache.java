package com.claus.Design;

import java.util.HashMap;
import java.util.Map;

public class MyLRUCache {

    private class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {}

        public DLinkedNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }


    private Map<Integer, DLinkedNode> cache = new HashMap<>(); //
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public MyLRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    // 在链表头插入节点
    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    // 删除节点
    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 将节点移动到链表头
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    // 删除尾结点
    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    // 访问节点
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 找到该key，并将该node节点移动到链表头
        moveToHead(node);
        return node.value;
    }

    // 插入节点
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // 新key
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 添加进map
            cache.put(key, newNode);
            // 在双向链表头部插入节点
            addToHead(newNode);
            size++;
            if (size > capacity) {
                // 超出容量，删除尾部最久没使用节点
                DLinkedNode tail = removeTail();
                // 删除Map中对应项
                cache.remove(tail.key);
                size--;
            }
        } else {
            // 节点存在
            node.value = value; // 更新节点值
            // 将节点移动到链表头
            moveToHead(node);
        }
    }

    public static void main(String[] args) {
        MyLRUCache test = new MyLRUCache(2);
        test.put(1, 1);
        test.put(2, 2);
        test.get(1);
        test.put(3, 3);
        test.get(2);
        test.put(4, 4);
        test.get(1);
        test.get(3);
        test.get(4);
    }

}
