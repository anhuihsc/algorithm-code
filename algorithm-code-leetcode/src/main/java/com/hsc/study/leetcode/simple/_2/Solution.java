package com.hsc.study.leetcode.simple._2;

/**
 * @author wansong
 */
public class Solution {
    public static int reverse(int x) {
        int ret = 0;
        int input = x;
        while (input != 0) {
            int pop = input % 10;
            input = input / 10;
            if (ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)) {
                return 0;
            } else if (ret < Integer.MIN_VALUE / 10 || (ret == Integer.MIN_VALUE / 10 && input < Integer.MIN_VALUE % 10)) {
                return 0;
            }
            ret = ret * 10 + pop;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(-10%10);
    }
}
