package leetcode;

import java.util.Arrays;

/**
 * 给定一个非负整数数组nums, nums中一半整数是奇数,
 * 一半整数是偶数,对数组进行排序,以便：
 * 当nums[i]为奇数时,i也是奇数
 * 当nums[i]为偶数时,i也是偶数
 * 返回任何满足上述条件的数组
 * 
 * nums = [4, 2, 5, 7]
 * return [4, 5, 2, 7]
 */
public class LeetCode922_SortArrayByParityii {
    public static void main(String[] args) {
        int[] nums = {2, 3};
        int[] arr = sortArrayByParityII(nums);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] sortArrayByParityII(int[] nums) {
        int i = 0;
        int j = 1;
        int[] arr = new int[nums.length];
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] % 2 == 0) {
                arr[i] = nums[k];
                i += 2;
                continue;
            }
            arr[j] = nums[k];
            j += 2;
        }
        return arr;
    }
}
