package com.hsc.study.leetcode.simple._5;

import com.hsc.study.leetcode.simple._4.TreeNode;

/**
 * @author wansong
 */
public class Solution {
    public static String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0) {
            return "";
        }
        if (strs.length == 1 ) {
            return strs[0];
        }
        int j = 0;
        for (j = 0; j<strs[0].length(); j++) {
            for (int i = 1; i < strs.length; i++) {
                if (j >= strs[i].length()) {
                    return strs[0].substring(0, j);
                }
                if (strs[i].charAt(j) != strs[0].charAt(j)) {
                   return strs[0].substring(0, j);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] {"aa","a","aa"}));
    }

}
