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

    /**
     * 非递归实现,节省内存空间
     * @param n
     */
    public static void print1ToMaxofNDigits2(int n) {
        if (n <= 0) {
            throw new RuntimeException("Invalid input, n must more than 0");
        }
        int[] arr = new int[n];
        while (increment(arr)) {
            printArray(arr);
        }
    }

    private static boolean increment(int[] arr) {
        int index = arr.length;
        boolean hasCarry;
        do {
            index--;
            arr[index] += 1;
            hasCarry = arr[index] % 10 == 0;
            arr[index] %= 10;
        } while (hasCarry && index > 0);

        return !(hasCarry && index == 0);//到最大数为false
    }

    public static void main(String[] args) {
        print1ToMaxofNDigits(2);
        print1ToMaxofNDigits2(2);

        //error test
        //print1ToMaxofNDigits(-1);
        //print1ToMaxofNDigits(0);
    }
}
