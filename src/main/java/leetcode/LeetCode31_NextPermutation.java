package leetcode;

import java.util.Arrays;
import java.util.Collections;

/**
 * 整数数组的一个排列就是将其所有成员以序列或线性顺序排列
 * 例：arr = [1, 2, 3], 以下都可以视作arr的排列:
 * [1, 2, 3], [1, 3, 2], [3, 1, 2], [2, 3, 1]
 * 整数数组的下一个排列是指其整数的下一个字典序更大的排列。
 * 更正式的, 如果数组的所有排列根据其字典顺序从小到大排列在
 * 一个容器中, 那么数组的下一个排列就是在这个有序容器中排在它
 * 后面的那个排列, 如果不存在下一个更大的排列, 那么这个数组必须重排
 * 为字典序最小的排列(即：其元素按照升序排列)
 * 例：arr = [1, 2, 3]的下一个排列是[1, 3, 2]
 * arr = [2, 3, 1]的下一个排列是[3, 1, 2]
 * arr = [3, 2, 1]的下一个排列是[1, 2, 3],
 * 因为[3, 2, 1]不存在一个字典序更大的排列
 *
 * 给你一个整数数组nums， 找出nums的下一个排列
 * 必须原地修改, 只允许使用额外常数空间
 */
public class LeetCode31_NextPermutation {
    public static void main(String[] args) {
        int[] arr1 = {3, 2, 1};
        nextPermutation(arr1);
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = {2, 3, 1};
        nextPermutation(arr2);
        System.out.println(Arrays.toString(arr2));
        int[] arr3 = {1, 1, 5};
        nextPermutation(arr3);
        System.out.println(Arrays.toString(arr3));
        int[] arr4 = {1, 3, 2};
        nextPermutation(arr4);
        System.out.println(Arrays.toString(arr4));
    }

    public static void nextPermutation(int[] nums) {
        // 1. 找到最靠右的较小数
        int rightClosestMinValueIndex = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i < nums.length - 1 && nums[i] < nums[i + 1]) {
                rightClosestMinValueIndex = i;
                break;
            }
        }
        // 找不到=>reverse
        if (rightClosestMinValueIndex == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        // 2. 找到最靠左的较大数
        int leftClosestMaxValueIndex = -1;
        for (int i = nums.length - 1; i > rightClosestMinValueIndex; i--) {
            if (nums[i] > nums[rightClosestMinValueIndex]) {
                if (leftClosestMaxValueIndex >= 0 && nums[i] > nums[leftClosestMaxValueIndex]) {
                    continue;
                }
                leftClosestMaxValueIndex = i;
            }
        }
        // 3. 交换较大数和较小数
        swap(nums, rightClosestMinValueIndex, leftClosestMaxValueIndex);
        // 4. 对交换后的较大数之后的元素进行升序排序
        reverse(nums, rightClosestMinValueIndex + 1, nums.length - 1);
    }

    public static void swap (int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void reverse(int[] nums, int left, int right) {
        int i = left;
        int j = right;
        while (i <= j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
