package info.liuxiao.search;

import com.sun.istack.internal.NotNull;

/**
 * Binary Search
 * Created by Sean on 16/1/4.
 */
public class BinarySearch {
    /**
     * Recursive
     */
    @NotNull
    public static boolean search(int[] a, int low, int high, int num) {
        if (null == a) {
            throw new IllegalArgumentException("The array is null");
        }

        if (low > high) {
            return false;
        }

        int mid = low + (high - low) / 2;//avoid int overflow

        if (num < a[mid]) {
            return search(a, low, mid - 1, num);
        } else if (num > a[mid]) {
            return search(a, mid + 1, high, num);
        } else {
            return true;
        }
    }

    /**
     * loop
     */
    public static boolean search2(int[] a, int low, int high, int num) {
        if (null == a) {
            throw new IllegalArgumentException("The array is null");
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (num < a[mid]) {
                high = mid - 1;
            } else if (num > a[mid]) {
                low = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
     *
     */
    public static int search3(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        System.out.println(BinarySearch.search3(nums, 9));
    }

}
