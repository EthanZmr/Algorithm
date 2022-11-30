package noob_00;

/**
 * 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {2, 7, 14, 19, 22, 35};
        int val = 19;
        System.out.println(exist(nums, val));
    }

    public static boolean exist(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] < val) {
                left = mid + 1;
            } else if (nums[mid] > val) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }


    /**
     * 在有序数组中找到>=val最左的位置
     * */
    public static int findLeft(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        int mid;
        int index = -1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] >= val) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }

    /**
     * 局部最小值:
     * 有一个无序数组，任意两个相邻的两个数不相等
     * 如果nums[0] < nums[1]  那么0位置的数就是局部最小
     * 如果nums[N-1] < nums[N-2] 那么N-1位置的数就是局部最小
     * 如果nums[i] < nums[i-1] && nums[i] < nums[i+1] 那么i位置的数就是局部最小
     * 返回其中一个局部最小就ok
     */
    public static int findRelativeMinVal(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums[0] < nums[1]) {
            return nums[0];
        }
        if (nums[nums.length-1] < nums[nums.length - 2]) {
            return nums[nums.length - 1];
        }

        int left = 0;
        int right = nums.length - 1;
        int mid;
        // 边界问题, 在left~right区间必须要有三个或以上元素
        while (left < right - 1) {
            mid = (left + right) / 2;
            // 如果mid位置的值比相邻左边大, 也比相邻右边大, 返回nums[mid]
            if (nums[mid] < nums[mid-1] && nums[mid] < nums[mid+1]) {
                return nums[mid];
            }
            // 如果mid位置的值比相邻左边大, 砍掉右边一半
            // 如果mid位置的值比相邻右边大, 砍掉左边一半
            // 由于相邻不相等的条件, 不会存在相等情况
            if (nums[mid] > nums[mid-1]) {
                right = mid - 1;
                continue;
            }
            if (nums[mid] < nums[mid + 1] ) {
                left = mid + 1;
            }
        }
        return Math.min(nums[left], nums[right]);
    }

    /**
     * 生成一个相邻位置的值不相等的随机数组
     * @param maxLength
     * @param maxValue
     * @return
     */
    public static int[] randomArray(int maxLength, int maxValue) {
        int len = (int)(Math.random() * maxLength);
        int[] arr = new int[len];
        if (len > 0) {
            arr[0] = (int)(Math.random() * maxValue);
            for (int i = 1; i < len; i++) {
                do {
                    arr[i] = (int)(Math.random() * maxValue);
                } while (arr[i] == arr[i - 1]);
            }
        }
        return arr;
    }



}
