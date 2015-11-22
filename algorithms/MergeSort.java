package algorithms;

public class MergeSort {

	/**
	 * 归并和快速排序不同的是，采用二分分割，对其子数组进行排序，递归的最后进行归并
	 * 如果p>=r说明该数组只有一个元素了
	 */
	
	public void mergeSort(int[] A, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;// 不分奇偶，整数相除丢失小数部分，只取整数部分
			mergeSort(A, p, q);
			mergeSort(A, q + 1, r);
			this.merge(A, p, q, r);
		}
	}
	
	/**
	 * 假设子数组A[p..q]和A[q+1..r]都已排序好，此时需要申请内存来临时储存这两个数组
	 * 对这两个数组进行迭代，比较大小，取最小的放入数组A，迭代器加1
	 * @param A 需要把子数组A[p..q]和A[q+1..r]合并的数组
	 * @param p
	 * @param q
	 * @param r
	 */
	public void merge(int[] A, int p, int q, int r) {
		int n1 = q - p + 1;//左子数组长度
		int n2 = r - q;//右子数组长度
		int[] L = new int[n1 + 1];
		int[] R = new int[n2 + 1];

		for (int i = 0; i < n1; i++)
			L[i] = A[p + i];
		L[n1] = Integer.MAX_VALUE;//子数组最后一个设为哨兵，总是最大的

		for (int i = 0; i < n2; i++)
			R[i] = A[q + i +1];
		R[n2] = Integer.MAX_VALUE;

		int i = 0;
		int j = 0;
		for (int k = p; k <= r; k++) {//需要填充A数组r-p+1次，即数组下标从p到r
			if (L[i] < R[j]) {
				A[k] = L[i];
				i++;
			} else {
				A[k] = R[j];
				j++;
			}
		}
	}

	public static void main(String[] args) {
		int[] A = { 5, 13, 2, 25, 7, 17, 20, 7, 4 };
		MergeSort ms = new MergeSort();
		ms.mergeSort(A, 0, A.length - 1);

		for (int i : A) {
			System.out.println(i);
		}
	}

}
