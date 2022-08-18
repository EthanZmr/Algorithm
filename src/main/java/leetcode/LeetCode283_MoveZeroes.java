package leetcode;

import java.util.Arrays;

/**
 * 给定一个数组nums, 编写一个函数将所有0移动到数组的末尾
 * 同时保持非0元素的相对顺序
 * 必须在不复制数组的情况下, 原地对数组进行操作
 *
 * nums = [0, 1, 0, 3, 12]  return [1, 3, 12, 0, 0]
 * nums = [0] return [0]
 */
public class LeetCode283_MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int j = 0;
        while (j < nums.length && nums[j] != 0) {
            j++;
        }
        for (int i = 0;i < nums.length; i++) {
            if (nums[i] != 0 && i > j) {
                nums[j] = nums[i];
                j++;
            }
        }
        while (j < nums.length) {
            nums[j] = 0;
            j++;
        }
    }

    public static void moveZeroes2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k] = nums[i];
                k++;
            }
        }

        while (k < nums.length) {
            nums[k] = 0;
            k++;
        }
    }
}
