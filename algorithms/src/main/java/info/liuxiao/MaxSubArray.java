package info.liuxiao;

public class MaxSubArray {
	/**
	 * @author xiao
	 * @time 2015年12月2日00:39:18
	 * 求子数组的最大和
	 * 由 N 个整数元素组成的一维数组 (A[0], A[1],…,A[n-1], A[n])，这个数组有很多连续子数组，那么其中数组之和的最大值是什么呢？
	 * 例如，数组 int A[5] = {-1, 2, 3, -4, 2};
	 * 符合条件的子数组为 {2, 3}，即答案为 5;
	 */
	
	/**
	 * 穷举法实现
	 * 时间复杂度O(n^2)
	 * @param A
	 * @param n
	 * @return
	 */
	public static int MaxSubArrayEXM(int[] A, int n)
	{
	    int max = Integer.MIN_VALUE;//初始值为最小值
	    int sum, i, j;
	    for (i = 0; i < n; i++) {
	        sum = 0;
	        for (j = i; j < n; j++) {
	            sum += A[j];
	            if (sum > max) {
	                max = sum;
	            }
	        }
	    }
	    return max;
	}
	
	/**
	 * 动态规划实现
	 * 时间复杂度O(n)
	 * 设sum[i]为前i个元素中，包含第i个元素且和最大的连续子数组，result 为已找到的子数组中和最大的。
	 * 对第i+1个元素有两种选择：做为新子数组的第一个元素、放入前面找到的子数组。
	 * sum[i+1] = max{A[i+1], sum[i]+A[i+1]};
	 * result = max{result, sum[i+1]};
	 */
	public static int maxSubArray(int[] A, int n) {
		int[] sum = new int[n];
		int result = A[0];
		int i = 0;

		for (i = 0; i < n; i++) {
			if (i == 0) {
				sum[0] = A[0];
			} else {
				sum[i] = Math.max(A[i], sum[i - 1] + A[i]);
				result = Math.max(result, sum[i]);
			}
		}
		return result;
	}
	
	/**
	 * 参考July的解法
	 * 时间复杂度O(n)
	 * 只要连续相加的sum还是大于等于零的，就继续加上下一个数。在这期间，将sum出现的最大值缓存到max。
	 * 
	 */
	public static int maxSubArray2(int[] A, int n) {
		int sum = 0;// 执行连续相加时的和，如果为负值了，就用下一个数组元素代替
		int max = A[0];

		for (int i = 0; i < n; i++) {
			if (sum < 0) {
				sum = A[i];// sum小于零，说明前面连续相加的元素不能组成最大子数组了，从A[i]元素作为新的起点
			} else {
				sum += A[i];// 否则，继续加上这个元素
			}

			if (sum > max) {
				max = sum;// 然后和max对比，如果大于，将这个数存入到max
			}
		}
		return max;
	}	
	
	public static void main(String[] args) {
		int[] A1 = { -1, 2, 3, -4, 2 };
		int[] A2 = { -1, -2, -3, -4 };
		int[] A3 = { 1, -2, 3, 10, -4, 7, 2, -5 };
		System.out.println(MaxSubArrayEXM(A1, A1.length));// 5
		System.out.println(MaxSubArrayEXM(A2, A2.length));// -1
		System.out.println(MaxSubArrayEXM(A3, A3.length));// 18
		
		System.out.println(maxSubArray(A1, A1.length));// 5
		System.out.println(maxSubArray(A2, A2.length));// -1
		System.out.println(maxSubArray(A3, A3.length));// 18
		
		System.out.println(maxSubArray2(A1, A1.length));// 5
		System.out.println(maxSubArray2(A2, A2.length));// -1
		System.out.println(maxSubArray2(A3, A3.length));// 18
	}
}
