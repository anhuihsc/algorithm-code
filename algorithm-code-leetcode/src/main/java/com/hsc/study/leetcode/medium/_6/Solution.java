package com.hsc.study.leetcode.medium._6;

import java.util.*;

/**
 * @author wansong
 */
public class Solution {
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        if (digits == null) {
            return Collections.emptyList();
        }
        int len=Double.valueOf(Math.pow(3.0,digits.length())).intValue();
        List<String> ret = new ArrayList<String>(len);
        for (int i = 0; i < digits.length(); i++) {
            String value = phone.get(digits.charAt(i) + "");
            if (value == null) {
                continue;
            }
        }

        return null;
    }
}
