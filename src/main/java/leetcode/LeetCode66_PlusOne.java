package leetcode;

import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数
 * 在该数的基础上加1
 * 最高位数字存放在数组的首位
 * 数组中每个元素只存储单个数字
 * 可以假设除了整数0之外，这个整数不会以零开头
 *
 * digits = [1, 2, 3]
 * output: [1, 2, 4]
 */
public class LeetCode66_PlusOne {
    public static void main(String[] args) {
        int[] digits = {9};
        int[] arr = plusOne(digits);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[]{1};
        }
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i > 0) {
                if (digits[i] < 9) {
                    digits[i] = digits[i] + 1;
                    return digits;
                } else {
                    digits[i] = 0;
                }
            } else {
                if (digits[i] < 9) {
                    digits[i] = digits[i] + 1;
                    return digits;
                } else {
                    digits[i] = 0;
                    int[] arr = new int[digits.length+1];
                    arr[0] = 1;
                    System.arraycopy(digits, 0, arr, 1, digits.length);
                    return arr;
                }
            }
        }
        return null;
    }

    /**
     * 更简洁的写法
     * */
    public static int[] BestWayPlusOne(int[] digits) {
        if (nums == null || nums.length == 0) {
            return new int[]{1};
        }

        for (i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] arr = new int[digits.length + 1];
        arr[0] = 1;
        return arr;
    }
}
