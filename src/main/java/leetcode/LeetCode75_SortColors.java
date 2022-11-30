package leetcode;

import java.util.Arrays;

/**
 * 给定一个包含红色、白色和蓝色、共n个元素的数组nums
 * 原地对它们进行排序,使得相同颜色的元素相邻
 * 并按照红色、白色、蓝色顺序排序
 *
 * 必须在不使用库的sort函数的情况下解决这个问题
 * 使用常数空间O(1)
 */
public class LeetCode75_SortColors {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        if (nums.length == 2) {
            if (nums[0] > nums[1]) {
                int tmp = nums[0];
                nums[0] = nums[1];
                nums[1] = tmp;
            }
            return;
        }
        int i = -1;
        int j = nums.length;
        for (int k = 0; k < j; k++) {
            if (nums[k] == 0) {
                i++;
                if (i != k) {
                    swap(nums, i, k);
                }
            }
            if (nums[k] == 2) {
                j--;
                if (j != k) {
                    swap(nums, j, k);
                }
            }
            if (k > i && nums[k] != 1) {
                k--;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
