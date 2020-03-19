package com.hsc.study.leetcode.medium._14;

import com.hsc.study.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如: 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3 / \ 9  20 /  \ 15   7 返回其层次遍历结果：
 * <p>
 * [ [3], [9,20], [15,7] ]
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        ;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelTree = new LinkedList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                levelTree.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            res.add(levelTree);
        }
        return res;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
    }

}
