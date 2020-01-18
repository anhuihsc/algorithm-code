package com.hsc.study.leetcode.simple._8;

/**
 *  和 _7 类似
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * <p>
 * 给定数组 nums = [1,1,2],
 * <p>
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。 示例 2:
 * <p>
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * <p>
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sloution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return doublePoint(nums);
    }

    /**
     *  双指针快慢指针
     *
     */
    public int solve(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public int doublePoint(int[] nums) {
        int len = nums.length;
        int i = 1, j = 1;
        int val = nums[0];
        while (i < len) {
            while (j < nums.length && nums[j] == val) {
                j++;
                len--;
            }
            if (j >= nums.length) {
                break;
            }
            if (i != j) {
                nums[i] = nums[j];
            }
            val = nums[i];
            i++;
            j++;
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,2};
        Sloution sloution = new Sloution();
        int len = sloution.removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}
