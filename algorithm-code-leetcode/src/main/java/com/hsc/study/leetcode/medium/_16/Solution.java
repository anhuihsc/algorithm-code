package com.hsc.study.leetcode.medium._16;

import com.hsc.study.leetcode.ListNode;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2 输出: 4->5->1->2->3->NULL 解释: 向右旋转 1 步: 5->1->2->3->4->NULL 向右旋转 2 步:
 * 4->5->1->2->3->NULL 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4 输出: 2->0->1->NULL 解释: 向右旋转 1 步: 2->0->1->NULL 向右旋转 2 步: 1->2->0->NULL 向右旋转 3 步:
 * 0->1->2->NULL 向右旋转 4 步: 2->0->1->NULL
 * https://leetcode-cn.com/problems/rotate-list/
 * 链表中的点已经相连，一次旋转操作意味着：

 先将链表闭合成环
 找到相应的位置断开这个环，确定新的链表头和链表尾
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oldTail=head;
        ListNode newTail=head;
        int len=1;
        for (len = 1; oldTail.next != null; len++) {
            oldTail = oldTail.next;
        }
        // 形成环
        oldTail.next=head;

        for (int i = 0; i < len- k % len - 1; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        //断开环
        newTail.next=null;
        return newHead;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

}
