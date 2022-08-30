package leetcode;

import java.util.Arrays;

/**
 * 给你一个有序数组nums, 请你原地删除重复出现的元素,
 * 使得出现次数超过两次的元素只出现两次, 返回删除后数组的新长度
 * 不要使用额外的数组空间, 你必须在原地修改输入数组
 * 并在使用O(1)额外空间的条件下完成
 *
 * nums = [1, 1, 1, 2, 2, 3]
 * return 5, nums = [1, 1, 2, 2, 3]
 */
public class LeetCode80_RemoveDuplicatesFromSortedArrayii {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 2, 2, 3, 4, 5};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null) {
            return -1;
        }
        if (nums.length < 3) {
            return nums.length;
        }
        int slow = 2;
        for (int fast = 2; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow - 2]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return slow;
    }
}
