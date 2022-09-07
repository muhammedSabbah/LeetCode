package com.google;

public class KnapSack {

	static int[][] memo;

	public static int knapSackDP(int[] weight, int[] prices, int n, int initailWeight) {
		int current = 0;
		int prev = 0;
		for (int col = 1; col <= initailWeight; col++) {
			for (int row = 1; row <= n; row++) {
				current = 0;
				prev = memo[row - 1][col];
				if (col >= weight[row - 1]) {
					current = prices[row - 1] + memo[row - 1][col - weight[row - 1]];
				}
				memo[row][col] = Math.max(prev, current);
			}
		}
		return memo[n][initailWeight];
	}

	public static void main(String[] args) {
		int[] weight = { 10, 4, 20, 5, 7 };
		int[] prices = { 10, 15, 3, 1, 4 };
		int initailWeight = 12;
		int n = weight.length;
		memo = new int[n + 1][initailWeight + 1];
		int maxProfit = knapSackDP(weight, prices, n, initailWeight);
		System.out.println(maxProfit);

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= initailWeight; j++) {
				System.out.print(memo[i][j] + " ");
			}
			System.out.println();
		}
	}

}
