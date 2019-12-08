package com.hsc.study.leetcode.medium._4;

/**
 * @author wansong
 */
public class Solution {

    public static int myAtoi(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        Long ret = 0L;
        boolean neg = false;
        boolean first=false;
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) == ' ') && ret == 0 && !first) {
                continue;
            }
            if (str.charAt(i) == '-' && !first) {
                first = true;
                neg = true;
            } else if (str.charAt(i) == '+' && !first) {
                first = true;
            } else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                ret = ret * 10 + str.charAt(i) - 48;
                if (ret > Integer.MAX_VALUE) {
                    break;
                }
            } else {
                break;
            }
        }
        ret = neg ? -ret : ret;
        if (ret < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        if (ret > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return ret.intValue();
    }

    public static void main(String[] args) {

        System.out.println(Integer.MAX_VALUE);
        System.out.println(myAtoi("2147483648"));
    }
}
