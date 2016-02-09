package info.liuxiao.util;

import org.jetbrains.annotations.Contract;

/**
 * Some common operations about number.
 * Created by Sean on 16/2/9.
 */
public class Number {
    /**
     * 将数组中,坐标为a和b的数交换
     *
     * @param arr Array
     * @param a   index a
     * @param b   index b
     */
    public static void exchange(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    /**
     * 打印数组中的元素.
     *
     * @param arr Array
     */
    @Contract("null -> fail")
    public static void printArray(int[] arr) {
        if (arr == null) {
            throw new RuntimeException("Invalid Input!");
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


}
