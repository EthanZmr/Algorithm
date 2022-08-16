package leetcode;

import java.util.Arrays;

/**
 * 给你一个数组nums和一个值val，你需要原地移除所有数值等于val的元素
 * 并返回移除后数组的新长度
 * 不要使用额外的数组空间，你必须仅使用O(1)额外空间
 * 并原地修改输入数组
 * */
public class LeetCode27_RemoveElement {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 2, 3, 0, 4, 2};       
        int val = 2;
        int result = removeElement(arr, val);
        System.out.println(Arrays.toString(arr));
        System.out.println(result);
    }

    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[slow] == val && nums[fast] != val) {
                swap(nums, slow, fast);
            }
            if (nums[slow] != val) {
                slow++;
            }
        }
        return slow;
    }


    public static void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
