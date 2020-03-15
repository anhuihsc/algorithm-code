package com.hsc.study.leetcode.simple._9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4], 输出: 6 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/maximum-subarray 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 动态规划 推演过程：
 * 定义dp[i] 为前 i 个连续数组 最大和
 * dp[1] 组合[-2]  最大值-2
 * dp[2] 组合：[-2][1] [-2,1] 最大值是 1
 * dp[3] 组合[-2][1][-3][1,-3] [-2,1,-3]  最大值1
 *
 * dp[i-1]>0 dp[i]=d[i-1]+num[i];
 * dp[i-1]<0 dp[i]=num[i];
 *
 */
public class Sloution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length <= 0) {
            throw new IllegalArgumentException("nums is invalid");
        }
        int max = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = max;
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = nums[i] + dp[i - 1];
            } else {
                dp[i] = nums[i];
            }
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;

    }


}
