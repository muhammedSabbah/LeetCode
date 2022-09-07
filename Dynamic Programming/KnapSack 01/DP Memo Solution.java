package com.google;

public class KnapSack {
	static int[][] memo;

	public static int knapSack(int[] weight, int[] prices, int currentIndx, int reminder) {
		if (currentIndx == weight.length) {
			return 0;
		}

		if (memo[currentIndx][reminder] != 0) {
			return memo[currentIndx][reminder];
		}
    
		int choice1 = 0;
		if (reminder >= weight[currentIndx]) {
			choice1 = knapSack(weight, prices, currentIndx + 1, reminder - weight[currentIndx]) + prices[currentIndx];
		}
		int choice2 = knapSack(weight, prices, currentIndx + 1, reminder);
		return memo[currentIndx][reminder] = Math.max(choice1, choice2);
	}

	public static void main(String[] args) {
		int[] weight = { 10, 4, 20, 5, 7, 1, 1, 1, 1, 1, 1 };
		int[] prices = { 10, 15, 3, 1, 4, 1, 1, 1, 1, 1, 1 };
		int initailWeight = 12;
		memo = new int[weight.length][initailWeight + 1];
		int maxProfit = knapSack(weight, prices, 0, initailWeight);
		System.out.println(maxProfit);
	}

}
