package leetcode;

import java.util.*;

/**
 * 给你两个整数数组nums1和nums2, 以数组形式返回两数组的交集
 * 返回结果中每个元素出现的次数，应与元素在两数组中都出现的次数一致
 * 如果出现次数不一致，则考虑取较小值。
 * 可以不考虑输出结果的顺序
 *
 * [1, 2, 2, 1]  [2, 2]
 * return [2, 2]
 */
public class LeetCode350_IntersectionOfTwoArraysii {
    
    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] arr = intersectV1(nums1, nums2);
        int[] arr2 = intersectV2(nums1, nums2);
        int[] arr3 = intersectV3(nums1, nums2);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
    }

    /**
     * 1.0版本
     */
    public static int[] intersectV1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i : nums1) {
            if (map1.containsKey(i)) {
                map1.put(i, map1.get(i) + 1);
                continue;
            }
            map1.put(i, 1);
        }
        for (int j : nums2) {
            if (map2.containsKey(j)) {
                map2.put(j, map2.get(j) + 1);
                continue;
            }
            map2.put(j, 1);
        }

        for (Integer key : map1.keySet()) {
            if (map2.containsKey(key)) {
                int len = map1.get(key) > map2.get(key) ? map2.get(key) : map1.get(key);
                for (int k = 0; k < len; k++) {
                    result.add(key);
                }
            }
        }
        int[] arr = new int[result.size()];

        for (int k = 0; k < arr.length; k++) {
            arr[k] = result.get(k);
        }
        return arr;
    }

    /**
     * 2.0版本
     */
    public static int[] intersectV2(int[] nums1, int[] nums2) {
        Map<Integer, List<Integer>> map1 = new HashMap<>();
        Map<Integer, List<Integer>> map2 = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        // 遍历长数组
        int length = Math.max(nums1.length, nums2.length);
        for (int i = 0; i < length; i++) {
            setMap(nums1, map1, i);
            setMap(nums2, map2, i);
        }

        for (Integer key : map1.keySet()) {
            if (map2.containsKey(key)) {
                 result.addAll(map1.get(key).size() > map2.get(key).size() ? map2.get(key) : map1.get(key));
            }
        }
        int[] arr = new int[result.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = result.get(i);
        }

        return arr;
    }

    private static void setMap(int[] nums, Map<Integer, List<Integer>> map, int i) {
        if (i < nums.length ) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(nums[i]);
            } else {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(nums[i]);
                map.put(nums[i], tmp);
            }
        }
    }


    /**
     * 官方题解
     */
    public static int[] intersectV3(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersectV3(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int[] result = new int[nums1.length];
        int index= 0;
        for (int val : nums2) {
            int count = map.getOrDefault(val, 0);
            if (count > 0) {
                result[index++] = val;
                count--;
                if (count > 0) {
                    map.put(val, count);
                } else {
                    map.remove(val);
                }
            }
        }
        return Arrays.copyOfRange(result, 0, index);
    }
}
