package leetcode;

import java.util.Arrays;

/**
 *  给你两个按非递减顺序排列的整数数组nums1和nums2
 *  另有两个整数m和n,分别表示nums1和nums2中的元素数目
 *  请你合并nums2到nums1中,使合并后的数组同样按照非递减顺序排列
 *
 *  nums1初始长度为m+n,nums2长度为n
 *
 *  nums1=[1, 2, 3, 0, 0, 0] m = 3
 *  nums2=[2, 5, 6] n = 3
 *
 *  return [1, 2, 2, 3, 5, 6]
 * */
public class LeetCode88_MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {0};
        int[] nums2 = {1};
        int m = 0;
        int n = 1;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int[] arr = new int[m + n];
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                arr[i+j] = nums1[i];
                i++;
            }
            if (nums1[i] > nums2[j]) {
                arr[i+j] = nums2[j];
                j++;
            }
            if (nums1[i] == nums2[j]) {
                arr[i+j] = arr[i];
                i++;
                arr[i+j] = arr[j];
                j++;
            }
        }
        while (i < m) {
            arr[i+j] = nums1[i];
            i++;
        }
        while(j < n) {
            arr[i+j] = nums2[j];
            j++;
        }
        System.arraycopy(arr, 0, nums1, 0, m+n);
    }

}
