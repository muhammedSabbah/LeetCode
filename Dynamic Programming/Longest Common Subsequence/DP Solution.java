package com.google;

public class LongestIncreasingSubSeq {

	// 5, 2, 7, 3, 4, 6
	static int[][] memo;

	public static int LIS(int[] elements, int current, int n, int prev) {
		if (current == n) {
			return 0;
		}

		if (memo[current][prev + 1] != 0) {
			return memo[current][prev + 1];
		}

		int choice1 = 0;
		if (prev == -1 || elements[current] > elements[prev]) {
			choice1 = 1 + LIS(elements, current + 1, n, current);
		}

		int choice2 = LIS(elements, current + 1, n, prev);

		return memo[current][prev + 1] = Math.max(choice1, choice2);
	}

	public static void main(String[] args) {
		int[] numbers = { 1, 3, 5, 4, 7 };
		int len = numbers.length;
		memo = new int[len][len];
		System.out.println(LIS(numbers, 0, len, -1));
	}

}
