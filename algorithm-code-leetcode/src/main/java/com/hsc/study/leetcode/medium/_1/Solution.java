package com.hsc.study.leetcode.medium._1;

/**
 * @author wansong
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/add-two-numbers 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Next = l1;
        ListNode l2Next = l2;
        ListNode resHead = null;
        ListNode resNextHead = null;
        int carryValue = 0;
        while (l1Next != null || l2Next != null) {
            int val = carryValue;
            carryValue = 0;
            if (l1Next != null) {
                val += l1Next.val;
                l1Next = l1Next.next;
            }
            if (l2Next != null) {
                val += l2Next.val;
                l2Next = l2Next.next;
            }
            if (val >= 10) {
                carryValue = val / 10;
                val = val % 10;
            }
            if (resHead == null) {
                resHead = new ListNode(val);
                resNextHead = resHead;
            } else {
                resNextHead.next = new ListNode(val);
                resNextHead = resNextHead.next;
            }
        }
        if (carryValue > 0) {
            resNextHead.next = new ListNode(carryValue);
        }
        return resHead;
    }

    public static void main(String[] args) {

    }
}
