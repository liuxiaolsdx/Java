package info.liuxiao.problems;

/**
 * Print number
 * Created by Sean on 16/2/4.
 */
public class PrintNumber {
    /**
     * 题目:输入数字n,按顺序打印出从1到最大的n位十进制数.比如输入3,则打印出1,2,3一直到最大的3位数即999.
     */

    /**
     * 此处用数组来表达大数
     * @param n
     */
    public static void print1ToMaxofNDigits(int n) {
        if (n <= 0) {
            throw new RuntimeException("Input number must more than 0");
        }

        int[] arr = new int[n];
        printBignum(0, arr);
    }

    /**
     *
     * @param i index of start
     * @param arr the array saved single number by index
     */
    public static void printBignum(int i, int[] arr) {
        if (i >= arr.length) {
            printArray(arr);//说明已经设置完数组中的所有元素
        } else {
            for (int k = 0; k < 10; k++) {
                arr[i] = k;//每一位都可能为0~9,设置完然后设置下一位
                printBignum(i + 1, arr);//递归
            }
        }
    }

    private static void printArray(int[] arr) {
        int index = 0;//定义数组非零的下标位置
        while (index < arr.length && arr[index] == 0) {
            index++;
        }
        for (int i = index; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        //数组中有非零元素,需要换行.
        if (index < arr.length) {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        print1ToMaxofNDigits(2);
    }
}
