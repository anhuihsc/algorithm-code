package com.hsc.study.leetcode.medium._7;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

 示例：

 给定一个链表: 1->2->3->4->5, 和 n = 2.

 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 说明：

 给定的 n 保证是有效的。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            throw new RuntimeException("listNode is null");
        }
        ListNode p = head;
        int len = len(head);
        len -= n;
        while (len > 0) {
            len--;
            p = p.next;
        }
        p.next = p.next.next;
        return head;
    }

    private int len(ListNode head) {
        ListNode p = head;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }

    public static void main(String[] args) {
        ListNode one=new ListNode(1);
        ListNode two=new ListNode(2);

        ListNode three=new ListNode(3);

        ListNode four=new ListNode(4);

        ListNode five=new ListNode(5);
        //one.next=two;
        //two.next=three;
        three.next=four;
        four.next=five;

        Solution solution=new Solution();
        solution.removeNthFromEnd(one,1);
    }
}
