package info.liuxiao.problems;

/**
 * SMath
 * Created by Sean on 16/2/2.
 */
public class SMath {
    /**
     * 题目:实现数值的整数次方.
     */
    public static double power(double base, int exponent) {
        double result = 1.0;
        if (Math.abs(base - 0.0) < 0.0000001) {//note: base maybe equal 0 when exponent is negative.
            return 0.0;
        }

        int absExponent = exponent < 0 ? -exponent : exponent;

        //for (int i = 0; i < absExponent; i++) {
        //    result *= base;
        //}
        result = powerWithUnsignedExponet(base, absExponent);
        return exponent < 0 ? 1 / result : result;
    }

    /**
     * 一个数的正整数次方可以用二分法来降低运算时间,从O(n) -> O(logn)
     * 对于a^x,当x为偶数时,即a^(x/2) * a^(x/2);当x为奇数时,即a^[(x-1)/2] * a^[(x-1)/2] * a
     * @param base 底
     * @param exponent 指数
     * @return 结果
     */
    public static double powerWithUnsignedExponet(double base, int exponent) {
        if (exponent == 0)
            return 1;
        if (exponent == 1)//递归结束条件
            return base;

        double result = powerWithUnsignedExponet(base, exponent/2);

        result *= result;

        if (exponent%2 != 0) {
            result *= base;
        }
        return result;
    }
    /**
     * 题目20: 顺时针打印矩阵
     * 输入一个矩阵,按照从外向里以顺时针的顺序一次打印出每一个数字.例如输入如下矩阵:
     * 1   2   3   4
     * 5   6   7   8
     * 9   10  11  12
     * 13  14  15  16
     * 则依次打印出:1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
     */
    /*
    1*1 2*2矩阵需打印的圈左上角坐标:(0,0)
    3*3 4*4矩阵需打印的圈左上角坐标:(0,0)(1,1)
    5*5 6*6矩阵需打印的圈左上角坐标:(0,0)(1,1)(2,2)
    7*7 8*8矩阵需打印的圈左上角坐标:(0,0)(1,1)(2,2)(3,3)
    ...
    所以x*y的矩阵需打印的圈左上角坐标:(0,0)(1,1)...(z,z) z=min{[x/2]-1,[y/2]-1} []取上
     */

    public static void printMatrixClockwisely(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int start = 0;
        int rows = matrix.length;
        int columns = matrix[0].length;
        //这个矩阵需要打印的圈数
        while (start*2 < rows && start*2 < columns) {
            printMatrixInCircle(matrix, rows, columns, start);
            start++;
        }
    }

    /**
     * 打印以start坐标为起始的圈.打印的圈分为三种,一种是一个正方形,一种是一横,一种是一竖.
     * @param matrix the matrix
     * @param rows the matrix rows
     * @param columns the matrix columns
     * @param start start index
     */
    private static void printMatrixInCircle(int[][] matrix, int rows, int columns, int start) {
        //圈的右下脚坐标为:
        int endX = rows - 1 - start;
        int endY = columns - 1 - start;

        if (endX == start && endY != start) {//横
            for (int i = start; i <= endY; i++) {
                printNumber(matrix[start][i]);
            }
        } else if (endY == start && endX != start) {//竖
            for (int i = start; i <= endX; i++) {
                printNumber(matrix[i][start]);
            }
        } else {
            for (int i = start; i <= endY; i++) {
                printNumber(matrix[start][i]);
            }
            for (int i = start+1; i <= endX; i++) {
                printNumber(matrix[i][endY]);
            }
            for (int i = endY-1; i >= start; i--) {
                printNumber(matrix[endX][i]);
            }
            for (int i = endX-1; i > start; i--) {
                printNumber(matrix[i][start]);
            }
        }
    }

    private static void printNumber(int number) {
        System.out.print(number + " ");
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};//1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
        int[][] matrixVertical = {{1,2,3},{4,5,6},{7,8,9},{10,11,12},{13,14,15}};//1 2 3 6 9 12 15 14 13 10 7 4 5 8 11
        int[][] matrixHorizontal = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};//1 2 3 4 8 12 11 10 9 5 6 7
        int[][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};//1 2 3 6 9 8 7 4 5
        SMath.printMatrixClockwisely(matrix);
        System.out.println();
        SMath.printMatrixClockwisely(matrixVertical);
        System.out.println();
        SMath.printMatrixClockwisely(matrixHorizontal);
        System.out.println();
        SMath.printMatrixClockwisely(matrix1);
    }
}
