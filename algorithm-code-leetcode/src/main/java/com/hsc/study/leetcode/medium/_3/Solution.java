package com.hsc.study.leetcode.medium._3;

/**
 * @author wansong
 */
public class Solution {

    /**
     * 暴力解法
     */
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        int length = s.length();
        int maxLen = 1;
        int start = 0;
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        for (int len = 2; len <= length; len++) {
            for (int i = 0; i <= length - len; i++) {
                int j = len + i - 1;
                if (len == 2 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;

                } else if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                }
                if (len > maxLen && dp[i][j]) {
                    start = i;
                    maxLen = len;
                }
            }
        }
        return s.substring(start, maxLen + start);
    }

    /**
     * 暴力解法
     */
    public String longestPalindrome1(String s) {
        String maxStr = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String tmp = s.substring(i, j + 1);
                if (isPalindrome(tmp) && tmp.length() > maxStr.length()) {
                    maxStr = tmp;
                }
            }
        }
        return maxStr;
    }

    private boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() <= 1) {
            return true;
        }
        int mid = s.length() / 2;
        if (s.length() % 2 == 1) {
            mid = mid + 1;
        }

        for (int i = 0; i < mid; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestPalindrome("aaa"));
    }

}
