package leetcode;

import java.util.Arrays;

/**
 * 给定一个n*n的二进制矩阵, 先水平翻转图像, 然后反转图像并返回结果
 * 水平翻转就是将图片的每一行都进行翻转, 即逆序
 * 反转图片就是想图片中的0全部替换成1,1全部替换成0
 */
public class LeetCode832_flippingAnImage {
    public static void main(String[] args) {
        int[][] image = new int[][]{
                {1, 1, 0},
                {1, 0, 1},
                {0, 0, 0}};
        int[][] arr = flipAndInvertImage(image);
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static int[][] flipAndInvertImage(int[][] image) {
        int[][] arr = new int[image.length][image.length];
        for (int i = 0; i < image.length; i++) {
            // 1. 翻转
            for (int j = arr[i].length - 1; j >= 0 ; j--) {
                if (image[i][j] == 0) {
                    image[i][j] = 1;
                } else {
                    image[i][j] = 0;
                }
                arr[i][arr[i].length - j - 1] = image[i][j];
            }
        }
        return arr;
    }
}
