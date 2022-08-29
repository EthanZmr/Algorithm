package leetcode;

import java.util.Arrays;

/**
 * 给你一个长度为n的整数数组nums
 * 和一个目标值target,
 * 请你从nums中选出三个整数,
 * 使它们的和与target最接近
 * 返回这三个数的和
 * 假定每组数组输入只存在恰好一个解+
 */
public class LeetCode16_ThreeSumClosest {
    public static void main(String[] args) {

    }

    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return -1;
        }
        Arrays.sort(nums);
        if (nums[0] + nums[1] + nums[2] >= target) {
            return nums[0] + nums[1] + nums[2];
        }
        if (nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] <= target) {
            return nums[nums.length - 1] + nums[nums.length -2] + nums[nums.length - 3];
        }
        int closestVal = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int tmpVal = target - sum;
                if (tmpVal < closestVal) {
                    closestVal = tmpVal;
                    result = sum;
                }
                if (sum < target) {
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                } else if (sum > target) {
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                } else {
                    return target;
                }
            }
        }
        return result;
    }
}
