package DynamicProgramming.CSES;

import java.util.Arrays;
import java.util.Scanner;

public class DiceCombinations {

    static long[] dp;
    static int MOD = 1 << 9 + 7;

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int[] arr = {1, 2, 3, 4, 5, 6};
        int w = scr.nextInt();
        dp = new long[(int)(w + 1)];
        Arrays.fill(dp, -1);
        System.out.println(memoization(arr, w));
    }

    public static long memoization(int[] arr, int w) {
        if (w < 0)
            return 0;
        if (w == 0)
            return 1;
        if (dp[w] != -1)
            return dp[w];
        long count = 0;
        for (int i : arr) {
            count = (count + memoization(arr, w - i)) % MOD;
        }
        return dp[w] = count;
    }

}
