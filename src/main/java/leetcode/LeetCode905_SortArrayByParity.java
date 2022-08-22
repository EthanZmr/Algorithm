package leetcode;

import java.util.Arrays;

public class LeetCode905_SortArrayByParity {
    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 3};
        int[] arr = sortArrayByParity(nums);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] sortArrayByParity(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] % 2 == 1 && nums[right] % 2 == 0) {
                swap(nums, left, right);
            }
            if (nums[left] % 2 == 0) {
                left++;
            }
            if (nums[right] % 2 == 1) {
                right--;
            }
        }
        return nums;
    }

    public static void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
