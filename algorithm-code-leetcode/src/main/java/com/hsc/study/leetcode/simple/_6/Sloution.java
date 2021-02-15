package com.hsc.study.leetcode.simple._6;

import com.hsc.study.leetcode.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 *     两数之和,类似题目还有三个数之和、四个数之合
 *
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/two-sum 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sloution {
    public ListNode mergeTwoLists(  ListNode<Integer> l1,   ListNode<Integer> l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(0);
        ListNode pHead = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pHead.next = l1;
                l1 = l1.next;
            } else {
                pHead.next  = l2;
                l2 = l2.next;
            }
            pHead.next=pHead;
        }

        pHead.next = l1 == null ? l2 : l1;
        return head.next;
    }
}
