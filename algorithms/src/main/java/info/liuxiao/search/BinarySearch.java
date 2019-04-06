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
}
