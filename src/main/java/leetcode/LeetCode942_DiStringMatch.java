package leetcode;

import java.util.Arrays;

/**
 *  由范围[0, n]内所有整数组成的n+1个整数的排列序列
 *  可以表示为长度为n的字符串s,其中：
 *  如果perm[i] < prem[i+1], 那么s[i] == 'I'
 *  如果perm[i] > perm[i+1], 那么s[i] == 'D'
 *
 *  给定一个字符串s，重构排列perm并返回它, 
 *  如果有多个有效排列perm， 则返回其中一个
 *
 *  s="IDID"
 *  return [0, 4, 1, 3, 2]
 */
public class LeetCode942_DiStringMatch {
    public static void main(String[] args) {
        String s = "IDID";
        int[] arr = diStringMatch(s);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] diStringMatch(String s) {
        int[] arr = new int[s.length() + 1];
        int val1 = 0;
        int val2 = arr.length - 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                arr[i] = val1;
                val1++;
            }
            if (s.charAt(i) == 'D') {
                arr[i] = val2;
                val2--;
            }
        }
        arr[arr.length - 1] = val1 > val2 ? val1 : val2;
        return arr;
    }
}
