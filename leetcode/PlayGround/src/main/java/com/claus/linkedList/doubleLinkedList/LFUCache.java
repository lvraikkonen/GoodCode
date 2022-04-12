package com.claus.linkedList.doubleLinkedList;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    private class Node {
        int key;
        int value;
        int freq = 1;
        Node prev, next;

        public Node() {}

        public Node(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    private class DoublyLinkedList {
        Node head, tail;

        public DoublyLinkedList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        public void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public void addNode(Node node) {
            // 表头添加结点
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
        }
    }

    Map<Integer, Node> cacheData; // 存储缓存的内容
    Map<Integer, DoublyLinkedList> freqMap; // 存储每个频次对应的双向链表
    int size;
    int capacity;
    int min; // 存储当前最小频次

    public LFUCache(int capacity) {
        cacheData = new HashMap<>(capacity);
        freqMap = new HashMap<>();
        this.capacity = capacity;
    }

    void freqInc(Node node) {
        // 从原freq对应的链表里移除, 并更新min
        int freq = node.freq;
        DoublyLinkedList linkedList = freqMap.get(freq);
        linkedList.removeNode(node);
        if (freq == min && linkedList.head.next == linkedList.tail) { // 最小频次链表空了
            min = freq + 1;
        }
        // 加入新freq对应的链表
        node.freq++;
        linkedList = freqMap.get(freq + 1);
        if (linkedList == null) {
            linkedList = new DoublyLinkedList();
            freqMap.put(freq + 1, linkedList);
        }
        linkedList.addNode(node);
    }

    public int get(int key) {
        Node node = cacheData.get(key);
        if (node == null) {
            return -1;
        }
        freqInc(node); // 给节点增加频率
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node = cacheData.get(key);
        if (node != null) {
            node.value = value;
            freqInc(node);
        } else {
            if (size == capacity) { // 删除最小频率双向链表中的最后一个节点
                DoublyLinkedList minFreqLinkedList = freqMap.get(min);
                cacheData.remove(minFreqLinkedList.tail.prev.key);
                minFreqLinkedList.removeNode(minFreqLinkedList.tail.prev); // 这里不需要维护min, 因为下面add了newNode后min肯定是1.
                size--;
            }
            Node newNode = new Node(key, value);
            cacheData.put(key, newNode); // 向cacheData添加数据
            DoublyLinkedList linkedList = freqMap.get(1);
            if (linkedList == null) {
                linkedList = new DoublyLinkedList();
                freqMap.put(1, linkedList);
            }
            linkedList.addNode(newNode);
            size++;
            min = 1;
        }
    }

}
