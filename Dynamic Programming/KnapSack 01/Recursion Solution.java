package com.google;

public class KnapSack {

	public static int knapSack(int[] weight, int[] prices, int currentIndx, int reminder) {
		if (currentIndx == weight.length) {
			return 0;
		}
		int choice1 = 0;
		if (reminder >= weight[currentIndx]) {
			choice1 = knapSack(weight, prices, currentIndx + 1, reminder - weight[currentIndx]) + prices[currentIndx];
		}
		int choice2 = knapSack(weight, prices, currentIndx + 1, reminder);
		return Math.max(choice1, choice2);
	}

	public static void main(String[] args) {
		int[] weight = { 10, 4, 20, 5, 7 };
		int[] prices = { 10, 15, 3, 1, 4 };
		int initailWeight = 12;
		int maxProfit = knapSack(weight, prices, 0, initailWeight);
		System.out.println(maxProfit);
	}

}
