package com.claus;

public class SingleLinkedList {

    private Node head = null;

    public static class Node {
        // Node definition
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }

    // 遍历整个链表
    public void printAll() {
        Node p = head;
        while (p!=null) {
            System.out.println(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    //
    public static Node createNode(int value) {
        return new Node(value, null);
    }

    /**
     * 单链表的插入、删除、查找 基本操作
     * 1. 表头部插入 （与输入顺序相反，逆序）
     */
    public void insertToHead(int value) {
        Node newNode = new Node(value, null);
        insertToHead(newNode);
    }

    public void insertToHead(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    /**
     * 2. 表尾部插入， 顺序插入
     */
    public void insertTail(int value) {

        Node newNode = new Node(value, null);
        // 空链表
        if (head == null) {
            head = newNode;
        } else {
            Node q = head;
            while (q.next != null) { // 一直找到尾部
                q = q.next;
            }
            newNode.next = q.next;
            q.next = newNode;
        }
    }

    /**
     * 3. 在某节点后插入
     */
    public void insertAfter(Node p, Node newNode) {
        if (p == null) return;

        newNode.next = p.next;
        p.next = newNode;
    }

    public void insertAfter(Node p, int value) {
        Node newNode = new Node(value, null);
        insertAfter(p, newNode);
    }

    /**
     * 4. 在某节点前插入
     */
    public void insertBefore(Node p, Node newNode) {
        if (p == null) return;

        if (head == p) {
            insertToHead(newNode);
            return;
        }
        Node q = head;
        while (q != null && q.next != p) {
            q = q.next; // move until node before p
        }
        if (q == null) {
            return;
        }
        newNode.next = p;
        q.next = newNode;
    }

    public void insertBefore(Node p, int value) {
        Node newNode = new Node(value, null);
        insertBefore(p, newNode);
    }

    /**
     * 5. 删除某节点
     */
    public void deleteByNode(Node p) {
        if (p == null || head == null) return;

        if (p == head) {
            head = head.next;
            return;
        }
        Node q = head;
        while (q != null && q.next != p) {
            q = q.next; // find the node before tobe deleted node
        }
        if (q == null) {
            return;
        }
        q.next = q.next.next;
    }

    // main
    public static void main(String[] args) {
        SingleLinkedList link = new SingleLinkedList();
        System.out.println("hello");

        //
        int data[] = {1,2,5,3,1};
        for (int i=0; i < data.length; i++) {
//            link.insertToHead(data[i]);
            link.insertTail(data[i]);
        }
        link.printAll();
    }
}
