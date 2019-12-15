package com.hsc.study.leetcode.simple._6;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/two-sum 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        return violence(nums,0);
    }

    /**
     *
     */

    private List<List<Integer>> violence(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i  +1; j < nums.length; j++) {
                for (int k = i+1; k < nums.length; k++) {
                    if (target == nums[i] + nums[j] + nums[k]) {
                        List<Integer> list = new ArrayList<Integer>(3);
                        list.add(i);
                        list.add(j);
                        list.add(k);
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }
}
