package info.liuxiao.problems;

import info.liuxiao.util.Number;

/**
 * reorder a array by odd-even
 * Created by Sean on 16/2/9.
 */
public class ReorderOddEven {
    /**
     * 题目14: 输入一个整数数组, 实现一个函数来调整该数组中数字的顺序, 使得所有奇数位于数组的前半部分,所有偶数位于数组的后半部分.
     */

    /**
     * 书上是采用的两个指针,一个从头,一个从尾部开始遍历.此处我采用的quick sort 里面的partition方法来解的.
     * @param arr input array
     * @param left left index
     * @param right right index
     */
    public static void reorderOddEven(int[] arr, int left, int right) {
        if (arr == null || left > right || right >= arr.length) {
            throw new RuntimeException("Invalid input.");
        }
        int odd = left -1;//odd之前的都是奇数,包括odd
        for (int i = left; i <= right; i++) {
            if (arr[i] % 2 != 0) {
                odd++;
                Number.exchange(arr, odd, i);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] array2 = {1, 3, 5, 7, 9, 0, 2, 4, 6, 8};
        int[] array3 = {0, 2, 4, 6, 8, 1, 3, 5, 7, 9};
        int[] array4 = {3};
        reorderOddEven(array, 0, array.length-1);
        reorderOddEven(array2, 0, array2.length-1);
        reorderOddEven(array3, 0, array3.length-1);
        reorderOddEven(array4, 0, array4.length-1);
        try {
            reorderOddEven(null, 0, 0);
        } catch (RuntimeException e) {
            System.out.println("Null case test success!");
        }
        Number.printArray(array);
        Number.printArray(array2);
        Number.printArray(array3);
        Number.printArray(array4);
    }
}
