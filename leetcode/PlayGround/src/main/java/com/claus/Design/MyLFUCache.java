package com.claus.Design;

import java.util.HashMap;
import java.util.Map;

class Node {
    int key;
    int value;
    int freq = 1;
    Node prev;
    Node next;

    public Node() {}

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;

    public DoublyLinkedList() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void addNode(Node node) {
        // 表头添加节点
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}

public class MyLFUCache {
    Map<Integer, Node> cacheData; // 存储缓存的内容
    Map<Integer, DoublyLinkedList> freqMap; // 存储每个频次对应的双向链表
    int size;
    int capacity;
    int min; // 存储当前最小频次

    public MyLFUCache(int capacity) {
        cacheData = new HashMap<>(capacity);
        freqMap = new HashMap<>();
        this.capacity = capacity;
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

    public static void main(String[] args) {
        MyLFUCache cache = new MyLFUCache(2);
        cache.put(1, 111);   // cache=[1,_], cnt(1)=1
        cache.put(2, 222);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        cache.get(1);      // 返回 111
        // cache=[1,2], cnt(2)=1, cnt(1)=2
        cache.put(3, 333);   // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
        // cache=[3,1], cnt(3)=1, cnt(1)=2
        cache.get(2);      // 返回 -1（未找到）
        cache.get(3);      // 返回 333
        // cache=[3,1], cnt(3)=2, cnt(1)=2
        cache.put(4, 444);   // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
        // cache=[4,3], cnt(4)=1, cnt(3)=2
        cache.get(1);      // 返回 -1（未找到）
        cache.get(3);      // 返回 3
        // cache=[3,4], cnt(4)=1, cnt(3)=3
        cache.get(4);      // 返回 4
        cache.put(4, 999);
    }
}



