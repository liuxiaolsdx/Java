/**
 * Rotation Array
 * Created by Sean on 16/1/13.
 */
public class RotationArray {
    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾,称之为数组的旋转.
     * 输入:旋转数组
     * 输出:数组中最小值
     */

    /**
     * 方法一: 遍历整个数组
     * O(n)
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int min(int[] arr, int left, int right) {
        if (null == arr || arr.length == 0) {
            throw new IllegalArgumentException("Invalid array.");
        }
        int min = arr[left];
        for (int i = left; i <= right; i++) {
            min = min < arr[i] ? min : arr[i];
        }
        return min;
    }

    /**
     * 方法二: 二分查找
     */
    public static int min2(int[] arr, int left, int right) {
        if (null == arr || arr.length == 0 || left > right) {
            throw new IllegalArgumentException("Invalid Input.");
        }

        if (left == right) {
            return arr[left];//the array only one element
        }
        int middle = left;

        while (arr[left] >= arr[right]) {
            if (right - left == 1) {
                middle = right;
                break;
            }
            middle = left + (right - left) / 2;
            if (arr[middle] >= arr[left]) {
                left = middle;
            } else if (arr[middle] <= arr[right]){
                right = middle;
            }
        }
        return arr[middle];
    }
}
