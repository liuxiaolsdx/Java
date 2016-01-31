package info.liuxiao.problems;

/**
 * Fibonacci
 * Created by Sean on 16/1/31.
 */
public class Fibonacci {
    /**
     * 题目: 写一个函数,输入n,求斐波那契(Fibonacci)数列的第n项.斐波那契数列的定义如下:
     *       |-  0             n=0
     * f(n)= |-  1             n=1
     *       |-  f(n-1)+f(n-2) n>1
     */

    /**
     * 常见递归解法,由于重复计算结点会造成效率很慢.
     * 时间复杂度是以n的指数的方式增长.
     * @param n 输入值
     * @return int
     */
    public int fibonacci(int n) {
        if (n <= 0)
            return 0;

        if (n == 1)
            return 1;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * 将已经得到的数列中间项保存起来.
     * 递推实现,时间复杂度O(n).
     * @param n
     * @return
     */
    public int fibonacci2(int n) {
        int[] result = {0, 1};
        if (n <= 1)
            return result[n];

        int fibNMinusOne = 1;//f(n-1)
        int fibNMinusTwo = 0;//f(n-2)
        int fibN = 0;//f(n)
        for (int i = 2; i <= n; i++){
            fibN = fibNMinusOne + fibNMinusTwo;//获得当前i的斐波那契

            //然后存储上次计算的值,作为下次循环的增量.
            fibNMinusTwo = fibNMinusOne;
            fibNMinusOne = fibN;
        }
        return fibN;
    }
}
