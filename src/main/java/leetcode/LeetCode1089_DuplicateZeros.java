package leetcode;

import java.util.Arrays;

/**
 * 给你一个长度固定的整数数组arr, 
 * 请你将该数组中出现的每个零都复写一遍
 * 并将其余的元素向右平移
 * 请不要在唱过该数组长度的位置写入元素
 * 请对输入的数组就地进行上述修改
 * 不要从函数返回任何东西
 */
public class LeetCode1089_DuplicateZeros {
    public static void main(String[] args) {
        int[] nums = {1, 0, 2, 3, 0, 4, 5, 0};   
        duplicateZeros(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void duplicateZeros(int[] nums) {
        int j = nums.length;
        int i = 0;
        int index = 0;
        while (index < j) {
            if (nums[i] == 0) {
                index++;
            }
            i++;
            index++;
        }
        i--;
        index--;
        while(i >= 0) {
            if (index < j) {
                nums[index] = nums[i];
            }
            if (nums[i] == 0 && --index >= 0) {
                nums[index] = 0;
            }
            i--;
            index--;
        }
    }
}
