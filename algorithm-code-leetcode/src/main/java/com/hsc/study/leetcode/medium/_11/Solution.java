package com.hsc.study.leetcode.medium._11;

/**
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

 说明：每次只能向下或者向右移动一步。

 示例:

 输入:
 [
   [1,3,1],
 [1,5,1],
 [4,2,1]
 ]
 输出: 7
 解释: 因为路径 1→3→1→1→1 的总和最小。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/minimum-path-sum
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 定义 dp[i][j] 表示从开始节点到i，j 总和最小
 那么 必然有dp[i][j]=min(dp[i-1][j],dp[i][j-1])+nums[i][j];

 */
public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length <= 0 || grid[0].length <= 0) {
            throw new IllegalArgumentException("parms is invalid");
        }
        int r=grid.length;
        int c=grid[0].length;
        int dp[][]=new int[r][c];
        dp[0][0]=grid[0][0];
        for (int i = 1; i < r; i++) {
            dp[i][0] =dp[i-1][0]+grid[i][0];
        }
        for (int j = 1; j < c; j++) {
            dp[0][j] =  dp[0][j-1]+grid[0][j];
        }
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[r-1][c-1];
    }


    public static void main(String[] args) {
        Solution solution=new Solution();
    }

}
