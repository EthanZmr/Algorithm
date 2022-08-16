package leetcode;

import java.util.Arrays;

/**
 * 给你一个数组nums和一个值val
 * 你需要原地移除所有数值等于val的元素
 * 并返回移除后数组的新长度
 * 不要使用额外的数组空间
 * 你必须仅使用O(1)额外空间并原地修改输入数组
 */
public class LeetCode27_RemoveElement {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        // return 5 nums = {0, 1, 3, 0, 4}
        int result = removeElement(arr, val);
        System.out.println(result);
        int[] arr2 = {3, 2, 2, 3};
        int val2 = 3;
        // return 2 nums = {2, 2};
        int result2 = removeElement(arr2, val2);
        System.out.println(result2);
    }

    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0] == val ? 0 : 1;
        }
        int i = 0;
        int j = 0;             
        while (j < nums.length) {
            if (nums[i] == val && nums[j] != val) {
                swap(nums, i, j);
            }

            if (nums[i] != val) {
                i++;
            }
            j++;
        }
        System.out.println(Arrays.toString(nums));
        return i;

    }

    public static void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
