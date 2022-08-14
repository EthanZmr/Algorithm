package noob_00;

import java.util.Arrays;

/**
 * 前缀和
 */
public class PrefixSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(preSum(arr, 1, 2));
    }

    public static int preSum(int[] nums, int left, int right) {
        if (left == 0 || left == right) {
            return nums[right];
        }
        int[] help = new int[nums.length];
        help[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            help[i] = help[i - 1] + nums[i];
        }
        System.out.println(Arrays.toString(help));
        return help[right] - help[left];
    }
}
