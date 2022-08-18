package leetcode;

import java.util.Map;
import java.util.HashMap;

/**
 * 只出现一次的数字
 * 给定一个非空整数数组, 除了某个元素只出现一次以外
 * 其余每个元素均出现两次
 * 找出那个只出现了一次的元素
 *
 * 要求：O(n)时间复杂度 O(1)空间复杂度
 *
 * [2, 2, 1] return 1
 * [4, 1, 2, 1, 2] return 4
 */
public class LeetCode136_SingleNumber {
    public static void main(String[] args) {
        
    }

    public static int singleNumber(int[] nums) {
        // 首先想到的是用Map记录元素出现的次数
        Map<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (maps.containsKey(nums[i])) {
                maps.remove(nums[i]);
            } else {
                maps.put(nums[i], 1);
            }
        }
        return (Integer)(maps.keySet().toArray()[0]);
    }


    public static int bestWaySingleNumber(int[] nums) {
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans ^= nums[i];
            }
        }
        return ans;
    }
}
