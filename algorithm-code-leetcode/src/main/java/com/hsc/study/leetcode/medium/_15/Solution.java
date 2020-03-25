package com.hsc.study.leetcode.medium._15;

import com.hsc.study.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: dividend = 10, divisor = 3 输出: 3 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3 示例 2:
 * <p>
 * 输入: dividend = 7, divisor = -3 输出: -2 解释: 7/-3 = truncate(-2.33333..) = -2  
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/divide-two-integers 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        long d1 = Math.abs(new Long(dividend));
        long d2 = Math.abs(new Long(divisor));
        boolean negative = (dividend ^ divisor) < 0;
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            if ((d1 >> i) >= d2) {//找出足够大的数2^n*divisor
                res += 1 << i;//将结果加上2^n
                d1 -= d2 << i;//将被除数减去2^n*divisor
            }
        }
        if (negative) {
            res = -res;
        }
        return res;
    }
    // 超时
    public int divide1(int dividend, int divisor) {
        long d1 = Math.abs(new Long(dividend));
        long d2 = Math.abs(new Long(divisor));
        int res = 0;
        d1 = d1 - d2;
        while (d1 >= 0) {
            res++;
            d1 = d1 - d2;
            if (res >= Integer.MAX_VALUE) {
                break;
            }
        }
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            res = -res;
        }
        return res;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.divide(-2147483648,-1));
    }

}
