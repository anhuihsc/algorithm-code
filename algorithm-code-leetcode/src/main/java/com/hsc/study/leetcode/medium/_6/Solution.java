package com.hsc.study.leetcode.medium._6;

import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入："23" 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }
        int len = Double.valueOf(Math.pow(3.0, digits.length())).intValue();
        List<String> outPut = new ArrayList<String>(len);
        combinations(outPut,"",digits);
        return outPut;
    }

    public void combinations(List<String> outPut, String com, String nextDigits) {
        if (nextDigits.length() == 0) {
            outPut.add(com);
            return;
        }
        String dig = nextDigits.substring(0, 1);
        String value = phone.get(dig);
        for (int i = 0; i < value.length(); i++) {
            combinations(outPut, com + value.charAt(i), nextDigits.substring(1));
        }

    }

}
