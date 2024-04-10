package DynamicProgramming.KnapsackVariations;

import java.util.Arrays;

/*
        Given N items where each item has some weight and profit associated with it and also given a bag with
        capacity W,[i.e., the bag can hold at most W weight in it]. The task is to put the items into the bag
        such that the sum of profits associated with them is the maximum possible.
*/
public class Knapsack01 {

    public static void main(String[] args) {
        int n = 3;
        int W = 10;
        int[] profits = {1, 2, 3};
        int[] weights = {4, 5, 1};

        int maxProfitRecursion = recursion(profits, weights, W, n);

        int[][] dp = new int[n + 1][W + 1];
        for (int[] i : dp)
            Arrays.fill(i, -1);
        int maxProfitMemoization = memoization(profits, weights, W, n, dp);
    }

    public static int recursion(int[] profits, int[] weights, int W, int n) {
        if (W == 0 || n == 0) //Base Condition
            return 0;
        if (weights[n - 1] <= W)
            return Math.max(recursion(profits, weights, W - weights[n - 1], n - 1) + profits[n - 1],
                    recursion(profits, weights, W, n - 1));
        else
            return recursion(profits, weights, W, n - 1);
    }

    public static int memoization(int[] profits, int[] weights, int W, int n, int[][] dp) {
        if (W == 0 || n == 0)
            return 0;
        if (dp[n][W] != -1)
            return dp[n][W];
        if (weights[n - 1] <= W)
            return dp[n][W] = Math.max(memoization(profits, weights, W - weights[n - 1], n - 1, dp) + profits[n - 1],
                    memoization(profits, weights, W, n - 1, dp));
        else
            return dp[n][W] = memoization(profits, weights, W, n - 1, dp);
    }
}
