package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个字符串s和一个字符c, 且c是s中出现过的字符
 * 返回一个整数数组answer, 其中answer.length == s.length
 * 且answer[i]是s中从下表i到离它最近的字符c的距离
 * 两个下标i和j之间的距离为abs(i-j)
 *
 * s = "loveleetcode"   c = "e"
 * answer = [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 */
public class LeetCode821_ShortestDistanceToACharacter {
    public static void main(String[] args) {
        String s = "loveleetcode";
        char c = 'e';
        int[] arr = shortestToChar(s, c);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 这是一坨屎！！！！！！！！！！！！！！！！！
     */
//    public static int[] shortestToChar(String s, char c) {
//        int[] arr = new int[s.length()];
//        char[] stc = s.toCharArray();
//        List<Integer> characters = new ArrayList<>();
//        int j = 0;
//        for (int i = 0; i < stc.length; i++) {
//            if (stc[i] == c) {
//                characters.add(i);
//            }
//        }
//        System.out.println();
//        for (int i = 0; i < stc.length; i++) {
//            if (j < characters.size()) {
//                if (i < characters.get(j)) {
//                    arr[i] = characters.get(j) - i;
//                    continue;
//                }
//                if (i == characters.get(j)) {
//                    j++;
//                }
//            }
//        }
//        return arr;
//    }

    /**
     * 两次遍历：从左往右  从右往左
     * 取每个位置的最小值
     * @param s
     * @param c
     * @return
     */
    public static int[] shortestToChar(String s, char c) {
        char[] stc = s.toCharArray();
        int[] arr = new int[stc.length];
        int index = -arr.length;
        for (int i = 0;i < stc.length; i++) {
            if (stc[i] == c) {
                index = i;
            }
            arr[i] = i - index;
        }
        index = stc.length * 2;
        for (int j = stc.length - 1; j >= 0; j--) {
            if (stc[j] == c) {
                index = j;
            }
            arr[j] = Math.min(arr[j], index - j);
        }
        return arr;
    }
}
