package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个包含n+1个整数的数组nums, 其数字都在[1, n]
 * 范围内(包括1和n), 可知至少存在一个重复的整数
 * 假设nums只有一个重复的整数, 返回这个重复的整数
 * 你设计的解决方案必须不修改数组nums且只用常量级O(1)的额外空间
 *
 * nums = [1, 3, 4, 2, 2]
 * return 2
 */
public class LeetCode287_FindTheDuplicateNumber {
    public static void main(String[] args) {

    }

    public static int findDuplicate01(int[] nums) {
        Set<Integer> sets = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!sets.add(nums[i])) {
                return nums[i];
            }
        }
        return -1;
    }

    public static int findDuplicate02(int[] nums) {
        if (nums.length < 2) {
            return -1;
        }
        int slow = 0;
        int fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                fast = 0;
                while (nums[slow] != nums[fast]) {
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return nums[slow];
            }
        }
    }
}
