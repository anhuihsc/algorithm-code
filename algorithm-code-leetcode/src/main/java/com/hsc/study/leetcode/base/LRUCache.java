package com.hsc.study.leetcode.base;

/**
 * @author wansong
 * @date 2021/7/14
 */
public class LRUCache {
    private int capacity;
    private ListNode headNode;
    private int len;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.headNode = new ListNode();
        this.len=0;
    }

    public int get(int key) {
        ListNode node = findPreNode(key);
        if (node == null) {
            return 0;
        }
        ListNode cur=node.next;
        deleteNodeByPreNode(node);
        insertAtBegin(cur.key, cur.val);
        return node.val;
    }

    private void deleteNodeByPreNode(ListNode preNode) {
        ListNode node = preNode.next;
        preNode.next = node.next;
        node.next = null;
        len--;
    }

    private void insertAtBegin(int key, int value) {
        ListNode node = new ListNode();
        node.key = key;
        node.val = value;
        node.next = headNode.next;
        headNode.next = node;
        len++;
    }

    public void put(int key, int value) {
        ListNode preNode = findPreNode(key);
        if (preNode != null) {
            deleteNodeByPreNode(preNode);
            insertAtBegin(key, value);
        } else {
            if (len >= capacity) {
                deleteEndNode();
            }
            insertAtBegin(key, value);
        }
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

    private ListNode findPreNode(Integer data) {
        ListNode node = headNode;
        while (node.next != null) {
            if (data.equals(node.next.key)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public class ListNode {
        public int val;
        public int key;
        public ListNode next;

    }

    public static void main(String[] args) {
        LRUCache lruCache=new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);
    }
}
