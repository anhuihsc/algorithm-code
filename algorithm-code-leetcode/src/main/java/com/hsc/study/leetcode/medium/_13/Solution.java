//package com.hsc.study.leetcode.medium._13;
//
///**
// * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
// * <p>
// * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。 写入数据 put(key, value) -
// * 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
// * <p>
// * 进阶:
// * <p>
// * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/lru-cache 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
// */
//
//import java.util.List;
//
///**
// * 回溯法
// */
//class Solution {
//    int n;
//    String s;
//    LinkedList<String> segments = new LinkedList<String>();
//    ArrayList<String> output = new ArrayList<String>();
//
//    public boolean valid(String segment) {
//    /*
//    Check if the current segment is valid :
//    1. less or equal to 255
//    2. the first character could be '0'
//    only if the segment is equal to '0'
//    */
//        int m = segment.length();
//        if (m > 3)
//            return false;
//        return (segment.charAt(0) != '0') ? (Integer.valueOf(segment) <= 255) : (m == 1);
//    }
//
//    public void update_output(int curr_pos) {
//    /*
//    Append the current list of segments
//    to the list of solutions
//    */
//        String segment = s.substring(curr_pos + 1, n);
//        if (valid(segment)) {
//            segments.add(segment);
//            output.add(String.join(".", segments));
//            segments.removeLast();
//        }
//    }
//
//    public void backtrack(int prev_pos, int dots) {
//    /*
//    prev_pos : the position of the previously placed dot
//    dots : number of dots to place
//    */
//        // The current dot curr_pos could be placed
//        // in a range from prev_pos + 1 to prev_pos + 4.
//        // The dot couldn't be placed
//        // after the last character in the string.
//        int max_pos = Math.min(n - 1, prev_pos + 4);
//        for (int curr_pos = prev_pos + 1; curr_pos < max_pos; curr_pos++) {
//            String segment = s.substring(prev_pos + 1, curr_pos + 1);
//            if (valid(segment)) {
//                segments.add(segment);  // place dot
//                if (dots - 1 == 0)      // if all 3 dots are placed
//                    update_output(curr_pos);  // add the solution to output
//                else
//                    backtrack(curr_pos, dots - 1);  // continue to place dots
//                segments.removeLast();  // remove the last placed dot
//            }
//        }
//    }
//
//    public List<String> restoreIpAddresses(String s) {
//        n = s.length();
//        this.s = s;
//        backtrack(-1, 3);
//        return output;
//    }
//}
//
//}
//
//    ublic class Solution {
//    public boolean canJump(int[] nums) {
//        int n = nums.length;
//        int rightmost = 0;
//        for (int i = 0; i < n; ++i) {
//            if (i <= rightmost) {
//                rightmost = Math.max(rightmost, i + nums[i]);
//                if (rightmost >= n - 1) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//
//    public class Solution {
//        public int maxProfit(int prices[]) {
//            int minprice = Integer.MAX_VALUE;
//            int maxprofit = 0;
//            for (int i = 0; i < prices.length; i++) {
//                if (prices[i] < minprice)
//                    minprice = prices[i];
//                else if (prices[i] - minprice > maxprofit)
//                    maxprofit = prices[i] - minprice;
//            }
//            return maxprofit;
//        }
//    }
//
//
//    public int widthOfBinaryTree(TreeNode root) {
//        Queue<AnnotatedNode> queue = new LinkedList();
//        queue.add(new AnnotatedNode(root, 0, 0));
//        int curDepth = 0, left = 0, ans = 0;
//        while (!queue.isEmpty()) {
//            AnnotatedNode a = queue.poll();
//            if (a.node != null) {
//                queue.add(new AnnotatedNode(a.node.left, a.depth + 1, a.pos * 2));
//                queue.add(new AnnotatedNode(a.node.right, a.depth + 1, a.pos * 2 + 1));
//                if (curDepth != a.depth) {
//                    curDepth = a.depth;
//                    left = a.pos;
//                }
//                ans = Math.max(ans, a.pos - left + 1);
//            }
//        }
//        return ans;
//    }
//}
//
//class AnnotatedNode {
//    TreeNode node;
//    int depth, pos;
//    AnnotatedNode(TreeNode n, int d, int p) {
//        node = n;
//        depth = d;
//        pos = p;
//    }
//}
//
//
//}
