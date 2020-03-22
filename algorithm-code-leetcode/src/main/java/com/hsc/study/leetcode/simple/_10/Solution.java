package com.hsc.study.leetcode.simple._10;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2 输出： 2 解释： 有两种方法可以爬到楼顶。 1.  1 阶 + 1 阶 2.  2 阶 示例 2：
 * <p>
 * 输入： 3 输出： 3 解释： 有三种方法可以爬到楼顶。 1.  1 阶 + 1 阶 + 1 阶 2.  1 阶 + 2 阶 3.  2 阶 + 1 阶
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/climbing-stairs 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解题： 可以使用递归 或者动态规划
 * 定义 dp[n] 表示到n层 多少种楼梯爬法
 * dp[n]=dp[n-1]+dp[n-2]
 */
public class Solution {

    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i- 1] + dp[i - 2];
        }

        return dp[n];

    }

    int recurse(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return recurse(n - 1) + recurse(n - 2);
    }

}
