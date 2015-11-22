package algorithms;

public class InsertionSort {

	/**
	 * 插入排序犹如对扑克牌排序
	 * 第i个数之前都是已经排序好的，设A[i]=key，用key和前面的每个数相比较，如果小于则往后移一个，
	 * 直达不小于，跳出while循环，将key插入到j+1的位置。
	 * 时间复杂度为：O(n^2)
	 */
	
	public static void insertionSort(int[] A) {
		for (int i = 1; i < A.length; i++) {
			int key = A[i];
			int j = i - 1;
			while (j >= 0 && A[j] > key) {
				A[j + 1] = A[j];
				j--;
			}
			A[j + 1] = key;
		}
	}

	public static void main(String[] args) {
		int[] A = { 5, 2, 4, 6, 1, 3 };
		insertionSort(A);
		for (int x : A)
			System.out.println(x);
	}
}
