package leetcode;
/**
 * 给定n个非负整数表示每个宽度为1的柱子的高度图
 * 计算按此排列的柱子, 下雨之后能接多少雨水
 *
 * height = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
 * return 6
 */
public class LeetCode42_TappingRainWater {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        
        int sum = 0;
        int maxValIndex = 0;
        int i = 1;
        while (i < height.length) {
            if (height[i] > height[maxValIndex]) {
                maxValIndex = i;
            }
            i++;
        }
        
        int left = 0;
        int right = height.length - 1;
        int tmp = left;
        while (left < maxValIndex) {
            if(height[left] < height[tmp]) {
                sum = sum + (height[tmp] - height[left]);
            } else {
                tmp = left;
            }
            left++;
        }

        tmp = right;
        while (right > maxValIndex) {
            if (height[right] < height[tmp]) {
                sum = sum + (height[tmp] - height[right]);
            } else {
                tmp = right;
            }
            right--;
        }
        return sum;
    }
}
