package DynamicProgramming.Variations;

import java.util.Arrays;

public class HouseRobber2 {

    static void main() {
        int[] nums = {1,2,3};
        rob(nums);
    }

    static int[] dp;
    public static int rob(int[] nums) {
        int n=nums.length;
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        int includeLast = helper(1,n,nums);
        Arrays.fill(dp,-1);
        int includeFirst = helper(0,n-1,nums);
        return Math.max(includeFirst,includeLast);
    }

    public static int helper(int start, int end, int[] nums){
        if(start>=end)
            return 0;
        if(dp[start]!=-1)
            return dp[start];
        int include = helper(start+2,end,nums)+nums[start];
        int exclude = helper(start+1,end,nums);
        return dp[start]=Math.max(include,exclude);
    }
}




