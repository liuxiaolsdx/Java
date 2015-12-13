package algorithms;

public class HeapSort {

	/**
	 * 堆排序实现，最大堆 
	 * 
	 * 参考算法导论6.1
	 * 
	 */

	/**
	 * 注意：数组下标从0开始，所以此处设根结点坐标从0开始
	 * 
	 * 笔记： 
	 * 1.给定一个结点的下标i,其：  
	 * 父节点下标：[(i-1)/2]([]位取整） 
	 * 左孩子下标：2*i+1 
	 * 右孩子下标：2*i+2 
	 * 
	 * 2.既然一个包含n个元素的队可以看做一颗完全二叉树，那么该堆的高度是Θ(lgn)。
	 * 
	 * 3.堆结构上的一些基本操作的运行时间至多与树的高度成正比，即时间复杂度为O(lgn).
	 */

	/**
	 * 1. MAX-HEAPIFY过程：其时间复杂度为O(lgn),它是维护最大堆性质的关键。
	 * 2. BULD-MAX-HEAP过程：具有线性时间复杂度，功能是从无序的输入数组中构造一个最大堆。
	 * 3. HEAPSORT 过程：其时间复杂度为O（nlgn),功能是对一个数组进行原址排序。
	 */
	
	public int parent(int i) {
		if (i == 0)
			return 0;
		else
			return (i - 1) / 2;
	}

	public int left(int i) {
		return 2 * i + 1;
	}

	public int right(int i) {
		return 2 * i + 2;
	}

	/**
	 * 先假设根结点为left(i)和right(i)的二叉树都是最大堆
	 * 
	 * @param A
	 * @param i
	 */
	public void maxHeapify(int[] A, int i, int heapSize) {
		int l = this.left(i);// 左孩子下标
		int r = this.right(i);// 又孩子下标
		int largest = 0;// 最大结点的下标

		if (l < heapSize && A[l] > A[i]) {
			largest = l;
		} else {
			largest = i;
		}

		if (r < heapSize && A[r] > A[largest]) {
			largest = r;
		}

		if (largest != i) {
			// 将最大的放在i结点上
			int temp = A[i];
			A[i] = A[largest];
			A[largest] = temp;

			maxHeapify(A, largest, heapSize);// largest下标的结点为原来A[i]
		}
	}

	/**
	 * 将A[0...n]转换成最大堆，子数组A[(n-1)/2+1..。n]为数组的叶结点
	 * 自底向上
	 * @param A
	 */
	public void buidMaxHeap(int[] A) {
		int heapSize = A.length;
		for (int i = (A.length - 1) / 2; i >= 0; i--) {
			this.maxHeapify(A, i, heapSize);
		}
	}

	/**
	 * 最后一个不需要置换到堆的最后，此时已经完成排序
	 * 
	 * 时间复杂度为：O(nlgn)
	 */
	public void heapSort(int[] A) {
		this.buidMaxHeap(A);
		int heapSize = A.length;
		for (int i = (A.length - 1); i > 0; i--) {
			// 将堆的根结点和最后一个结点交换
			int temp = A[0];
			A[0] = A[heapSize - 1];
			A[heapSize - 1] = temp;

			// 此时堆不满足堆的性质，将堆的长度减1（即最大的数在堆中剔除），进行堆性质维护
			heapSize--;
			this.maxHeapify(A, 0, heapSize);
		}
	}

	public static void main(String[] args) {
		int[] A = { 5, 13, 2, 25, 7, 17, 20, 8, 4 };
		HeapSort hs = new HeapSort();
		hs.heapSort(A);

		for (int i : A) {
			System.out.println(i);
		}
	}
}
