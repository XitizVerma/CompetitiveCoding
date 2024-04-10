package DynamicProgramming.LongestCommonSubsequence;

import java.util.Arrays;

public class LcsLength {

    static int dp[][];
    public static void main(String[] args){
        String word1 = "abfc";
        String word2 = "abcd";

        int lcsLengthRecursion = lcsRecursion(word1.length(),word2.length(),word1,word2);

        dp = new int[word1.length()+1][word2.length()+1];
        for(int[] it:dp)
            Arrays.fill(it,-1);
        int lcsLengthMemoization = lcsMemoization(word1.length(),word2.length(),word1,word2);

    }

    private static int lcsRecursion(int m, int n, String word1, String word2) {
        if(m==0 || n==0)
            return 0;
        if(word1.charAt(m-1)==word2.charAt(n-1))
            return 1+lcsRecursion(m-1,n-1,word1,word2);
        else
            return Math.max(lcsRecursion(m-1,n,word1,word2),lcsRecursion(m,n-1,word1,word2));
    }

    private static int lcsMemoization(int m, int n, String word1, String word2) {
        if(m==0 || n==0)
            return 0;
        if(dp[m-1][n-1]!=-1)
            return dp[m-1][n-1];
        if(word1.charAt(m-1)==word2.charAt(n-1))
            return dp[m-1][n-1] = 1+lcsMemoization(m-1,n-1,word1,word2);
        else
            return dp[m-1][n-1] = Math.max(lcsMemoization(m-1,n,word1,word2),lcsMemoization(m,n-1,word1,word2));
    }

}
