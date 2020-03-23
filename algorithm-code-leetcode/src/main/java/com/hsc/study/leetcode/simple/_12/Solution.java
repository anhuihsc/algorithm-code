package com.hsc.study.leetcode.simple._12;

import com.hsc.study.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Stack;

/**
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例： 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3 / \ 9  20 /  \ 15   7 返回它的最大深度 3 。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public int maxDepth(TreeNode root) {
      return recurse(root);
    }

    private int recurse(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }

        return Math.max(1 + recurse(treeNode.left), 1 + recurse(treeNode.right));
    }
}
