package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 *
 * 整数数组nums和一个整数目标值target，
 * 在该数组中找出和为目标值target的那两个整数,
 * 返回它们的数组下标
 *
 */
public class LeetCode01_TwoSum {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(arr, 9)));
    }

    // 构建哈希表一一对应
    public static int[] twoSum(int[] nums, int target) {
        int[] indexs = new int[2];
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                indexs[0] = i;
                indexs[1] = hash.get(nums[i]);
                return indexs;
            }
            hash.put(target - nums[i], i);
        }
        return indexs;
    }

//    public static int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            int num = target - nums[i];
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[j] == num) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return null;
//    }
}
