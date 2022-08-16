package leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

/**
 * 给定一个排序数组nums和一个目标值target
 * 在数组中找到目标值并返回其索引
 * 如果目标值不存在于数组中
 * 返回它将会被按顺序插入的位置
 *
 * 要求复杂度为O(logN)
 */
public class LeetCode35_SearchInsertPosition {
    public static void main(String[] args) {
        int maxLength = 7;
        int maxValue = 10;
        int testTimes = 5000000;
        boolean flag = true;
        for (int i = 0; i < testTimes; i++) {
            int[] arr = randomArray(maxLength, maxValue);
            int target = (int) (Math.random() * 800);
            int result1 = searchInsert(arr, target);
            int result2 = check(arr, target);
            if (result1 != result2) {
                flag = false;
                System.out.println(Arrays.toString(arr));
                System.out.println(target);
                break;
            }
        }
        System.out.println(flag ? "Nice!" : "Fucking Fuck!!!");
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums[0] >= target) {
            return 0;
        }
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }

        int left = 1;
        int right = nums.length - 1;
        int mid;
        int index = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
                index = left;
            }
        }
        return index;
    }

    public static int[] randomArray(int maxLength, int maxValue) {
        int len = (int)(Math.random() * maxLength);
        int[] arr = new int[len];
        Set<Integer> sets = new HashSet<>();
        for (int i = 0; i < len; i++) {
            do {
                arr[i] = (int)(Math.random() * maxValue);
            } while (sets.contains(arr[i]));
            sets.add(arr[i]);
        }
        Arrays.sort(arr);

        return arr;
    }


    public static int check(int[] nums, int target) {
        if (nums.length <= 0 || nums[0] >= target) {
            return 0;
        }
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }
}
