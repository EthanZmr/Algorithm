package leetcode;

/**
 *  给你一个按非递减顺序排序的整数数组nums, 
 *  返回每个数字的平方组成的新数组
 *  要求也按非递减顺序排序
 */
public class LeetCode977_SquaresOfSortedArray {
    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] arr = sortedSquares(nums);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] arr = new int[nums.length];
        int index = arr.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                arr[index] = nums[left] * nums[left];
                index--;
                left++;
            } else {
                arr[index] = nums[right] * nums[right];
                index--;
                right--;
            }
        }
        return arr;
    }
}
