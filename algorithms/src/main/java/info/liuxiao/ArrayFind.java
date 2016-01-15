package info.liuxiao;

/**
 * Created by Sean on 15/12/26.
 */
public class ArrayFind {
    /*
    题目:在一个二维数组中,每一行都按照从左到右递增的顺序排序,每一列都按照从上到下递增的顺序排序.
    请完成一个函数,输入这样的一个二维数组和一个整数,判断数组中是否含有该整数.
     */

    /**
     * Find a number from a matrix.
     *
     * @param A       matrix
     * @param rows    the rows
     * @param columns the columns
     * @param number  the number
     * @return true:success
     */
    public static boolean find(int[][] A, int rows, int columns, int number) {
        if (A != null && rows > 0 && columns > 0) {
            int r = 0;
            int c = columns - 1;
            /*
            取数组中右上角的数字,和number比较.
            如果比number大,说明整列都会比number大,就从while循环中去除此列.
            如果比number小,就剔除这一行.
            直到遍历完整个二维数组.
             */
            while (r < rows && c >= 0) {
                if (A[r][c] == number) {
                    return true;
                } else if (A[r][c] > number) {
                    c--;
                } else {
                    r++;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}};

        if (ArrayFind.find(A, 4, 4, 7)) {
            System.out.println("Find 7 in the matrix!");
        } else {
            System.out.println("Can't find 7 in the matrix!");
        }

        if (ArrayFind.find(A, 4, 4, 19)) {
            System.out.println("Find 19 in the matrix!");
        } else {
            System.out.println("Can't find 19 in the matrix!");
        }

    }
}
