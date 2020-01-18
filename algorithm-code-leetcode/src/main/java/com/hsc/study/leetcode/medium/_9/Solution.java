package com.hsc.study.leetcode.medium._9;

import java.util.*;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/3sum-closest 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        return doublePoint(nums, target);
    }

    private int doublePoint(int[] nums, int target) {
        int value = nums[0] + nums[1] + nums[2];
        int closeValue = Math.abs(value - target);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int left=i+1;
            int right=nums.length-1;
            while (left<right)
            {
                int sum = nums[left] + nums[right] + nums[i];
                if(sum==target)
                {
                    return sum;
                }

                if (Math.abs(sum - target) < closeValue) {
                    closeValue = Math.abs(sum - target);
                    value = sum;
                }
                if (sum > target) {
                    right--;
                } else {
                    left++;
                }

            }
        }
        return value;
    }
    /**
     *
     * O(n3)
     */
    private int violence(int[] nums, int target) {
        int value = nums[0] + nums[1] + nums[2];
        int closeValue = Math.abs(value - target);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int tmp = nums[i] + nums[j] + nums[k];
                    if (Math.abs(tmp - target) < closeValue) {
                        closeValue = Math.abs(tmp - target);
                        value = tmp;
                    }
                }
            }
        }
        return value;
    }
    //public  List<List<Integer>> doublePoint(int[] nums,int target) {
    //    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    //    int len = nums.length;
    //    Arrays.sort(nums); // 排序
    //    int closeValue = Math.abs(nums[0] + nums[1] + nums[2] - target);
    //    for (int i = 0; i < len ; i++) {
    //        if(nums[i] > target) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
    //        if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
    //        int L = i+1;
    //        int R = len-1;
    //        while(L < R){
    //            int sum = nums[i] + nums[L] + nums[R];
    //            if(sum == 0){
    //                ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
    //                while (L<R && nums[L] == nums[L+1]) L++; // 去重
    //                while (L<R && nums[R] == nums[R-1]) R--; // 去重
    //                L++;
    //                R--;
    //            }
    //            else if (sum < 0) L++;
    //            else if (sum > 0) R--;
    //        }
    //    }
    //    return ans;
    //}

}
