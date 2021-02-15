package com.hsc.study.leetcode.hard._7;

import com.hsc.study.leetcode.ListNode;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给你这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 解题思路 1.
 *
 * @author wansong
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        return null;
    }

    public static void main(String[] args) {
        DelayQueue<DelayTest> delayQueue=new DelayQueue<DelayTest>();
        final boolean add = delayQueue.add(new DelayTest());
    }

    private static class DelayTest implements Delayed
    {
        public long getDelay(TimeUnit unit) {
            return 0;
        }

        public int compareTo(Delayed o) {
            return 0;
        }
    }
}
