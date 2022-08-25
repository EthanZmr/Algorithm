package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含n个整数的数组nums, 判断nums中是否存在三个元素a,b,c
 * 使得a+b+c=0? 请你找出所有和为0且不重复的三元组
 * 答案中不可以包含重复的三元组
 */
public class LeetCode15_ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, 4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return null;
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            List<Integer> list = new ArrayList<>();
            if (Math.abs(nums[i]) > Math.abs(nums[right])) {
                left = right - 1;
                if (nums[i] + nums[left] + nums[right] == 0) {
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                }
            } else if (Math.abs(nums[i]) < Math.abs(nums[right])){
                if (nums[i] + nums[left] + nums[right] == 0) {
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                }
                right--;
            } else {
                list.add(nums[i]);
                list.add(nums[right]);
                while (left < right) {
                    if (nums[left] == 0) {
                        list.add(nums[left]);
                        break;
                    }
                    left++;
                }
                if (list.size() == 3) {
                    result.add(list);
                }
            }
        }
        return result;
    }


}
