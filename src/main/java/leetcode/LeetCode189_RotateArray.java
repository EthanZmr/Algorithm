package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个数组, 将数组中的元素向右轮转K个位置
 * 其中k是非负数
 * 至少三种不同的方法解决这个问题
 * 使用空间复杂度为O(1)的原地算法解决这个问题
 */
public class LeetCode189_RotateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 4;
        rotate01(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate01(int[] nums, int k) {
        if (nums.length < 2 || k == nums.length || k == 0) {
            return;
        }
        if (k > nums.length) {
            k = k % nums.length;
        }
        int left = 0;
        int right = nums.length - k - 1;
        // 先翻转左边
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
        // 再翻转右边
        left = nums.length - k;
        right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
        // 最后再翻转一次整体
        left = 0;
        right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void rotate02(int[] nums, int k) {
        if (nums.length < 2 || k == 0 || k == nums.length) {
            return;
        }
        if (k > nums.length) {
            k = k % nums.length;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = nums.length - k; i < nums.length; i++) {
            result.add(nums[i]);
        }
        for (int i = 0; i < nums.length - k; i++) {
            result.add(nums[i]);
        }
        for (int i = 0; i < result.size(); i++) {
            nums[i] = result.get(i);
        }
    }

    public static void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
