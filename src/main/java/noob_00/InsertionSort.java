package noob_00;

import static noob_00.SelectionSort.print;
import static noob_00.SelectionSort.swap;

/**
 * 插入排序
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {7, 1, 3, 5, 7, 6, 1, 5};
        print(arr);
        insertSort(arr);
        print(arr);
    }

    public static void insertSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (nums[j] < nums[j-1]) {
                    swap(nums, j, j-1);
                }
            }
        }
    }
}
