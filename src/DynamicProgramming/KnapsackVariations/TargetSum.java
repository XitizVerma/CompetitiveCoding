package DynamicProgramming.KnapsackVariations;

import java.util.Arrays;

/*
    Given nums array, find if the sum of subset of numbers equals to a particular value
*/
public class TargetSum {//Target Sum

    public static void main(String[] args){
        int[] arr = {2,3,5,8,10};
        int target = 11;
        int n = arr.length;

        boolean isSubsetSumRecursion = subsetSumRecursion(n,arr,target);

        int[][] dp = new int[target+1][n+1];
        Arrays.fill(dp,-1);
//        for(int i=0;i<=target;i++)
//            for(int j=0;j<=n;j++)
//                dp[i][j]=-1;
        int temp = subsetSumMemoization(n,arr,target,dp);
        boolean isSubsetSumMemoization = temp==1;

        if(isSubsetSumRecursion==isSubsetSumMemoization)
            System.out.println("TRUE");
    }

    private static boolean subsetSumRecursion(int n,int[] arr, int target) {
        if(target==0)
            return true;
        if(n==0)
            return false;
        if(arr[n-1]<=target)
            return subsetSumRecursion(n-1,arr,target-arr[n-1]) | subsetSumRecursion(n-1,arr,target);
        else
            return subsetSumRecursion(n-1,arr,target);
    }

    private static int subsetSumMemoization(int n,int[] arr, int target, int[][] dp) {
        if(target==0)
            return 1;
        if(n==0)
            return 0;
        if(dp[target][n]!=-1)
            return dp[target][n];
        if(arr[n-1]<=target)
            return dp[target][n]=subsetSumMemoization(n-1,arr,target-arr[n-1],dp) | subsetSumMemoization(n-1,arr,target,dp);
        else
            return dp[target][n]=subsetSumMemoization(n-1,arr,target,dp);
    }
}
