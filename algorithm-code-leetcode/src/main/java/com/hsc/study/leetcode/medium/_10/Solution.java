package com.hsc.study.leetcode.medium._10;

import java.util.Arrays;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

 问总共有多少条不同的路径？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/unique-paths
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 动态规划可以解此题
 定义 dp[i][j] 为从开始位置到i，j可能走法
 那么不难看出dp[i][j]=dp[i-1][j]+dp[i][j-1];

 */
public class Solution {
    public int uniquePaths(int m, int n) {
        if (n<=0 || m <= 0) {
            throw new IllegalArgumentException("parms is invalid");
        }
        int [][] dp=new int[m][n];
        dp[0][0]=1;
        for (int i = 1; i < m; i++) {
            dp[i][0] =1;
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }


    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.uniquePaths(7,3));
    }

}
