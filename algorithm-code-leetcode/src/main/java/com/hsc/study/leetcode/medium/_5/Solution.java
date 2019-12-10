package com.hsc.study.leetcode.medium._5;

/**
 * @author wansong
 */
public class Solution {
    /**
     *     [1,8,6,2,5,4,8,3,7]
     *      暴力解法
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 1; i <= height.length; i++) {
            for (int j = i + 1; j <= height.length; j++) {
                int area = (j - i) * Math.min(height[i - 1], height[j - 1]);
                if (area > maxArea) {
                    maxArea = area;
                }

            }
        }

        return maxArea;
    }
}
