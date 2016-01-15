package info.liuxiao;

public class QuickSort {

    /**
     * QuickSort partition:总是选择数组最后一个作为主元(pivot element)
     */

    /**
     * 快速排序的递归实现
     */
    public static void quickSort(int[] Data, int low, int hight) {
        if (low < hight) {
            int q = partition(Data, low, hight);// 划分数组，q前面都是小于或等于Data[q]的，q后面都是大于Data[q];
            quickSort(Data, low, q - 1);
            quickSort(Data, q + 1, hight);
        }
    }

    public static int partition(int[] Data, int low, int hight) {
        int x = Data[hight];// 选择数组最后一个作为基准pivot
        int i = low - 1;// 从头开始遍历
        for (int j = low; j < hight; j++) {
            if (Data[j] <= x) {
                i++;
                // 比基准小的都放在i+1的前面，大的保持不动
                exchange(Data, i, j);
            }
        }
        // 在最后将基准和i+1交换
        exchange(Data, hight, i + 1);

        return i + 1;// 返回基准的坐标进行分割数组
    }

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

    public static void main(String[] args) {
        int[] Data = {2, 8, 7, 1, 3, 5, 6, 4};
        quickSort(Data, 0, Data.length - 1);
        for (int i : Data)
            System.out.println(i);
    }
}