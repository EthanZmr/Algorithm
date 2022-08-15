package leetcode;

/**
 * 给你一个升序排列的数组nums, 请你原地删除重复出现的元素
 * 使每一个元素只出现一次,返回删除后数组的新长度
 * 元素的相对顺序应该保持一致
 */
public class LeetCode26_RemoveSortedArrayDuplicates {

    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        // new arr is {0, 1, 2, 3, 4, _, _,...}
        int newLength = removeDuplicates(arr);
        System.out.println(newLength);
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j]
            }
            j++;
        }
        return i+1;
    }
}
