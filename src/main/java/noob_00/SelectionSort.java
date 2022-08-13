package noob_00;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {7, 1, 3, 5, 7, 6, 1, 5};
        print(arr);
        selectSort(arr);
        print(arr);
    }

    public static void print(int[] nums) {
        System.out.println(Arrays.toString(nums));
    }

    public static void selectSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int minValueIndex = i;
            for (int j = i+1; j < nums.length; j++) {
                minValueIndex = nums[j] < nums[minValueIndex] ? j : minValueIndex;
            }
            swap(nums, i, minValueIndex);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
