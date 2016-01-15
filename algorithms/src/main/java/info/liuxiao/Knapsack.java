package info.liuxiao;

import java.util.*;

public class Knapsack {

	/**
	 * @author xiao
	 * @date 2015-11-25 03:10:22
	 * 
	 * 动态规划之背包问题：
	 * 
	 * C[]: 表示各个物品的体积
	 * V[]: 表示各个物品的价值
	 * d(i,j)定义为：前i个物品放入体积为j背包中的最大价值
	 * 
	 * 第i个物品不装入背包时，最大价值为：d(i-1,j)
	 * 第i个物品装入背包时，最大价值为:d(i-1,j-C[i-1])+V[i-1]
	 * 说明：数组下标从0开始，所以第i个物品的体积和价值分别为：C[i-1]和V[i-1]
	 * 
	 * 状态转移方程为：
	 * d(i,j)=max{d(i-1,j), d(i-1,j-C[i-1])+V[i-1]}
	 */
	
	/**
	 * 背包问题实现
	 * @param n 物品个数
	 * @param c 背包体积
	 * @param C 各个物品的体积
	 * @param V 各个物品的价值
	 * @return 最优解
	 */
	public static int knapsack(int n, int c, int[] C, int[] V) {
		int[][] D = new int[n + 1][c + 1];//D[0][]和D[][0]为0

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= c; j++) {
				if (i==0 || j==0) {
					D[i][j] = 0;
				} else if (j >= C[i-1]) {
					D[i][j] = Math.max(D[i - 1][j], D[i - 1][j - C[i-1]] + V[i-1]);
				}else {//j < C[i-1]//背包体积小于物体体积
					D[i][j] = D[i-1][j];
				}
			}
		}

		return D[n][c];
	}
	
	/**
	 * 背包问题优化空间复杂度，打印放入背包中的物品编号
	 * @param n 物品个数
	 * @param c 背包体积
	 * @param C 各个物品的体积
	 * @param V 各个物品的价值
	 * @return 最优解的物品编号
	 */
	public static List<Integer> printNumber(int n, int c, int[] C, int[] V) {
		List<Integer> A = new ArrayList<>();
		int[] D = new int[c + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = c; j >= 0; j--) {//此处注意从c开始递减
				if (j >= C[i - 1] && j > 0) {
					D[j] = Math.max(D[j], D[j - C[i - 1]] + V[i - 1]);

				}
			}
		}

		int knapsackSpace = c;
		while (D[knapsackSpace] == D[knapsackSpace - 1]) {
			knapsackSpace--;//假如背包价值和背包空间-1的时候价值相同，空间 -1
		}//找到一共实际使用了多少空间

		for (int i = 1; i <= n; i++) {
			//假如背包实际空间减去当前物品的空间，其价值刚好和物品的价值相等，说明此物品被放入了。
			if ((knapsackSpace >= C[i - 1]) && (D[knapsackSpace - C[i - 1]] == D[knapsackSpace] - V[i - 1])) {
				A.add(i - 1);
				knapsackSpace -= C[i - 1];
			}
		}
		return A;
	}	
	
	public static void main(String[] args) {
		int n = 5;
		int c = 10;
		int[] C = { 3, 5, 2, 7, 4 };
		int[] V = { 2, 4, 1, 6, 5 };
		int maxValue = knapsack(n, c, C, V);
		System.out.println("The maximum value: " + maxValue);

		List<Integer> numberList = printNumber(n, c, C, V);
		System.out.print("The object number: ");
			for (Integer x : numberList) {
				System.out.print(x + " ");
			
			}
	}
}
