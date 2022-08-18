package leetcode;

import java.util.*;

/**
 *  给定两个数组nums1和nums2, 返回它们的交集
 *  输出结果中的每个元素一定是唯一的
 *  不考虑输出结果的顺序
 *
 *  nums1 = [1, 2, 2, 1] nums2 = [2, 2]
 *  return [2]
 *
 *  nums1 = [4, 9, 5] nums2 = [9, 4, 9, 8, 4]
 *  return [9, 4] 或 [4, 9] 都是正确的
 */
public class LeetCode349_IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] arr = intersection(nums1, nums2);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        
    }

}
