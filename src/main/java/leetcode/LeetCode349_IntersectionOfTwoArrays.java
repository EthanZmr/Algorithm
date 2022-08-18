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
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        // 两个set集合
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }

        for (int j = 0; j < nums2.length; j++) {
            if (set1.contains(nums2[j])) {
                set2.add(nums2[j]);
            }
        }

        int[] arr = new int[set2.size()];
        int k = 0;
        for (Integer val : set2) {
            arr[k++] = val;
        }
        return arr;

    }

}
