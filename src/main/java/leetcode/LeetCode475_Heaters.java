package leetcode;

import java.util.Arrays;

/**
 * 给出位于一条水平线上的房屋houses和供暖器heaters的位置
 * 请你找出并返回可以覆盖所有房屋的最小加热半径
 *
 * houses = [1, 2, 3]   heaters = [2]
 * return 1  仅在位置2上有一个供暖器, 加热半径为1时所有房屋都可以得到供暖
 *
 * houses = [1, 2, 3, 4]    heaters = [1, 4]
 * return 1
 * 在位置1, 4上有两个供暖器, 加热半径为1时所有房屋都能得到供暖
 */
public class LeetCode475_Heaters {
    public static void main(String[] args) {
        int[] houses = {282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923};
        int[] heaters = {823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612};
        System.out.println(findRadius01(houses, heaters));
    }

    public static int findRadius01(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int minRadius = 0;
        for (int i = 0;i < houses.length; i++) {
            int left = binarySearch(heaters, houses[i]);
            int right = left + 1;
            int leftDistance = left < 0 ? Integer.MAX_VALUE : houses[i] - heaters[left];
            int rightDistance = right >= heaters.length ? Integer.MAX_VALUE : heaters[right] - houses[i];
            int curDistance = Math.min(leftDistance, rightDistance);
            minRadius = Math.max(minRadius, curDistance);
        }
        return minRadius;
    }

    public static int binarySearch(int[] heaters, int target) {
        int left = 0;
        int right = heaters.length - 1;
        if (heaters[left] > target) {
            return -1;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (heaters[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static int findRadius02(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int j = 0;
        int minRadius = 0;
        for (int i = 0; i < houses.length; i++) {
            int curRadius = Math.abs(houses[i] - heaters[j]);
            while (j < heaters.length - 1 && Math.abs(houses[i] - heaters[j]) >= Math.abs(houses[i] - heaters[j + 1])) {
                j++;
                curRadius = Math.min(curRadius, Math.abs(houses[i] - heaters[j]));
            }
            minRadius = Math.max(minRadius, curRadius);
        }
        return minRadius;
    }
}
