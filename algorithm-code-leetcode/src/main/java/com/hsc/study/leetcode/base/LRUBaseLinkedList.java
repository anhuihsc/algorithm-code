package com.hsc.study.leetcode.base;

import com.hsc.study.leetcode.ListNode;

import java.util.Scanner;

/**
 * @author wansong
 * @date 2021/2/15
 * 目标：基于链表实现LRU算法
 * LRU 最近最久未使用淘汰策略
 * O（n）
 */
public class LRUBaseLinkedList<T> {
    /**
     * 默认链表容量
     */
    private final static Integer DEFAULT_CAPACITY = 10;

    /**
     * 头结点
     */
    private ListNode<T> headNode;

    /**
     * 链表容量
     */
    private int capacity;
    /**
     * 链表长度
     */
    private int len;


    public LRUBaseLinkedList(int capacity) {
        this.capacity = capacity;
        this.headNode = new ListNode<>(null);
        this.len = 0;
    }

    public LRUBaseLinkedList() {
        this.capacity = DEFAULT_CAPACITY;
        this.headNode = new ListNode<>(null);
        this.len = 0;
    }

    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException("data is null");
        }
        ListNode preNode = findPreNode(data);
        if (preNode != null) {
            deleteNodeByPreNode(preNode);
            insertAtBegin(data);
        } else {
            if (len > capacity) {
                deleteEndNode();
            }
            insertAtBegin(data);
        }
    }


    private ListNode findPreNode(T data) {
        ListNode node = headNode;
        while (node.next != null) {
            if (data.equals(node.next.val)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    private void deleteNodeByPreNode(ListNode preNode) {
        ListNode node = preNode.next;
        preNode.next = node.next;
        node.next = null;
        len--;
    }

    private void insertAtBegin(T data) {
        ListNode node = new ListNode<>(data);
        node.next = headNode.next;
        headNode.next = node;
        len++;
    }

    private void deleteEndNode() {
        ListNode pNode = headNode;
        if (pNode.next == null) {
            return;
        }
        // 倒数第二个结点
        while (pNode.next.next != null) {
            pNode = pNode.next;
        }
        ListNode node = pNode.next;
        node.next = null;
        pNode.next = null;
        len--;
    }
    private void printAll() {
        ListNode node = headNode.next;
        while (node != null) {
            System.out.print(node.val + ",");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUBaseLinkedList<Integer> list = new LRUBaseLinkedList<>(10);
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.add(sc.nextInt());
            list.printAll();
        }
    }


}
