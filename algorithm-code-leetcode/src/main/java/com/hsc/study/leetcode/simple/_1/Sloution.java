package com.hsc.study.leetcode.simple._1;

import java.util.HashMap;
import java.util.Map;

/**
 *     两数之和,类似题目还有三个数之和、四个数之合
 *
 *
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
public class Sloution {

    public int[] twoSum(int[] nums, int target) {
        return hash(nums, target);
    }

    /**
     * 暴力解法
     */
    private int[] violence(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    private int[] hash(int[] nums, int target) {
        // Map< Integer num,Integer index>
        Map<Integer, Integer> numMap = new HashMap<Integer, Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
            if (numMap.containsKey(val)) {
                return new int[] {i, numMap.get(val)};
            } else {
                numMap.put(nums[i], i);
            }
        }
        return null;
    }
}
